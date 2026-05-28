package com.local.project.local_llm_spring_ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.local.project.local_llm_spring_ai.dto.EmailRequest;

@Service
public class EmailService {

    private final ChatClient chatClient;

    public EmailService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String generateEmail(EmailRequest request) {
        String prompt = """
                Generate a %s email.
                Tone: %s
                Topic: %s
                Keep it concise and professional.
                """.formatted(request.getEmailType(), request.getTone(), request.getTopic());

        return chatClient.prompt()
                .system("""
                        You are an expert corporate communication assistant.
                        Generate clean professional emails.
                        """)
                .user(prompt)
                .call()
                .content();

    }

}
