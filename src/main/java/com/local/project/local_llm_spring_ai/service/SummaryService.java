package com.local.project.local_llm_spring_ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.local.project.local_llm_spring_ai.dto.SummaryRequest;

@Service
public class SummaryService {
    private final ChatClient chatClient;

    public SummaryService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String Summarize(SummaryRequest request) {
        return chatClient.prompt()
                .system("""
                        You are a text summarization expert.
                                Summarize clearly in bullet points.
                        """)
                .user(request.getText())
                .call()
                .content();
    }
}
