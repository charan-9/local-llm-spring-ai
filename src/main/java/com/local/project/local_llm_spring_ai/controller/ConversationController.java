package com.local.project.local_llm_spring_ai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.local.project.local_llm_spring_ai.dto.ChatRequest;
import com.local.project.local_llm_spring_ai.service.ConversationService;

@RestController
@RequestMapping("/api/conversation")
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService service;

    @PostMapping
    public String chat(@RequestBody ChatRequest request) {
        return service.chat(request);
    }
}