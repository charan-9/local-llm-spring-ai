package com.local.project.local_llm_spring_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LocalLlmSpringAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalLlmSpringAiApplication.class, args);
	}

	@Bean
	public ChatClient chatClient(ChatClient.Builder builder) {
		return builder.build();
	}

}
