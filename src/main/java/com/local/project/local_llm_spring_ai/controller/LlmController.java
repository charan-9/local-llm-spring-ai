package com.local.project.local_llm_spring_ai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.local.project.local_llm_spring_ai.service.QuestionService;

@RestController
public class LlmController {

    private final QuestionService questionService;

    public LlmController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String message) {
        return questionService.ask(message);
    }

}