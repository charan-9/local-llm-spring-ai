package com.local.project.local_llm_spring_ai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.project.local_llm_spring_ai.dto.EmailRequest;
import com.local.project.local_llm_spring_ai.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/generate")
    public String getMethodName(@RequestBody EmailRequest emailRequest) {
        return emailService.generateEmail(emailRequest);
    }

}
