package com.local.project.local_llm_spring_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LlmController {

    private final ChatClient chatClient;

    public LlmController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String message) {
        return chatClient.prompt()
                .user(message)
                .system("You are a Java Tutor named Jenny, tell me your name when asked")
                .call()
                .content();
    }

}