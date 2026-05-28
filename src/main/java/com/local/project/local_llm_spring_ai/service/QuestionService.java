package com.local.project.local_llm_spring_ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final ChatClient chatClient;

    public QuestionService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String ask(String message) {
        return chatClient.prompt()
                .user(message)
                .system("You are a Java Tutor and will answer only to Java related questions. Strictly don't answer other questions, simply reject respectively")
                .call()
                .content();
    }
}
