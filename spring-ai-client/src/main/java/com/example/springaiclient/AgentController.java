package com.example.springaiclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/agent")
public class AgentController {

    private final ChatClient chatClient;

    public AgentController(ChatClient.Builder chatClientBuilder, McpTools mcpTools) {
        this.chatClient = chatClientBuilder.defaultTools(mcpTools).build();
    }

    @GetMapping("/test")
    public String test(@RequestParam("prompt") String prompt) {
        log.info("사용자 질의: {}", prompt);
        PromptTemplate pt = new PromptTemplate(prompt);
        String result = this.chatClient.prompt(pt.create())
                .call()
                .content();
        log.info("AI 응답: {}", result);
        return result;
    }
}