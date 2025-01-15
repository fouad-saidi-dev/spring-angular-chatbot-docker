package com.fouadev.backend.loader;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {
    @Value("classpath:docs/CryptoWhiteBook.pdf")
    private Resource pdfResource;

    private VectorStore vectorStore;

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);


    public DataLoader(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }
    @PostConstruct
    public void loadData(){
        try {
            logger.info("PDF resource exists: {}", pdfResource.exists());
            PagePdfDocumentReader reader = new PagePdfDocumentReader(pdfResource);
            List<Document> documents = reader.get();
            TextSplitter textSplitter = new TokenTextSplitter();
            List<Document> chunks = textSplitter.split(documents);
            logger.info("Loaded " + chunks.size() + " chunks from PDF");
            vectorStore.accept(chunks);
            logger.info("Data loaded into vector store successfully");
        } catch (Exception e) {
            logger.error("Error loading data: ", e);
        }

    }
}