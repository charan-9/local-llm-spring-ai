package com.local.project.local_llm_spring_ai.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.local.project.local_llm_spring_ai.dto.ChatRequest;
import com.local.project.local_llm_spring_ai.entity.ChatMessage;
import com.local.project.local_llm_spring_ai.service.ConversationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/conversation")
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService service;

    @PostMapping
    public String chat(@RequestBody ChatRequest request) {
        return service.chat(request);
    }

    @GetMapping("/getMessages")
    public List<ChatMessage> getMessages(@RequestParam String sessionId) {
        return service.getChatMessages(sessionId);
    }

}