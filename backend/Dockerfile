FROM openjdk:17-oracle
VOLUME /tmp
COPY target/backend*.jar app.jar
EXPOSE 8074
ENTRYPOINT ["java","-jar","app.jar"]