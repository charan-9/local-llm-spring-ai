package com.local.project.local_llm_spring_ai.dto;

import lombok.Data;

@Data
public class ChatRequest {

    private String sessionId;
    private String message;
}