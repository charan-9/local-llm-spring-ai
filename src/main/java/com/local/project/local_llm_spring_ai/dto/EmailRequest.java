package com.local.project.local_llm_spring_ai.dto;

import lombok.Data;

@Data
public class EmailRequest {
    private String emailType;
    private String tone;
    private String topic;
}

// {
// "emailType": "Leave Request",
// "tone": "Professional",
// "topic": "Medical leave for 3 days"
// }