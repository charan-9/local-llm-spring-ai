package com.local.project.local_llm_spring_ai.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.*;
import org.springframework.stereotype.Service;

import com.local.project.local_llm_spring_ai.dto.ChatRequest;
import com.local.project.local_llm_spring_ai.entity.ChatMessage;
import com.local.project.local_llm_spring_ai.repository.ChatMessageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConversationService {
    private final ChatClient chatClient;
    private final ChatMessageRepository chatMessageRepository;

    public String chat(ChatRequest request) {
        List<ChatMessage> history = chatMessageRepository.findRecentMessages(request.getSessionId());
        List<Message> messages = new ArrayList<>();
        messages.add(new SystemMessage("""
                You are a helpful AI assistant.
                Keep the answers concise.
                """));
        for (ChatMessage chat : history) {
            if (chat.getRole().equals("user")) {
                messages.add(new UserMessage(chat.getContent()));
            }
            if (chat.getRole().equals("assistant")) {
                messages.add(new AssistantMessage(chat.getContent()));
            }

        }
        messages.add(new UserMessage(request.getMessage()));
        String response = chatClient.prompt()
                .messages(messages)
                .call()
                .content();
        chatMessageRepository.save(ChatMessage.builder()
                .sessionId(request.getSessionId())
                .role("user")
                .content(request.getMessage())
                .createdAt(LocalDateTime.now())
                .build());
        chatMessageRepository.save(ChatMessage.builder()
                .sessionId(request.getSessionId())
                .role("assistant")
                .content(response)
                .createdAt(LocalDateTime.now())
                .build());
        return response;
    }

}
