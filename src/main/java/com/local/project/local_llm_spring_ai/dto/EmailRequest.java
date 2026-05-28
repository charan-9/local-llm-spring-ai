package com.local.project.local_llm_spring_ai.dto;

import lombok.Data;

@Data
public class EmailRequest {
    private String emailType;
    private String tone;
    private String topic;
}
