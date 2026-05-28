package com.local.project.local_llm_spring_ai.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.local.project.local_llm_spring_ai.dto.SummaryRequest;
import com.local.project.local_llm_spring_ai.service.SummaryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SummaryController {
    private final SummaryService summaryService;

    @PostMapping("/summarize")
    public String Summarize(@RequestBody SummaryRequest request) {
        return summaryService.Summarize(request);
    }
}
