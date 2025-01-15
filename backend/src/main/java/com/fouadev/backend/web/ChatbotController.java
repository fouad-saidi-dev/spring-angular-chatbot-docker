package com.fouadev.backend.web;

import lombok.Getter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ChatbotController {
    private ChatClient chatClient;
    private VectorStore vectorStore;

    public ChatbotController(ChatClient.Builder chatClient, VectorStore vectorStore) {
        this.chatClient = chatClient
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore))
                .build();
        this.vectorStore = vectorStore;
    }

    @GetMapping("/chat")
    public String chat(String msg){
        return chatClient.prompt()
                .user(msg)
                .call()
                .content();
    }
}