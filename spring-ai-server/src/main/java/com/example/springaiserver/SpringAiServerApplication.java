package com.example.springaiserver;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiServerApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider KnowledgeTools(KnowledgeService knowledgeService) {
        return MethodToolCallbackProvider.builder().toolObjects(knowledgeService).build();
    }

}
