package com.example.springaiclient;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class SpringAiClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiClientApplication.class, args);
    }

    @Override
    public void run(String... args) {

        /*
        //1.initialize()
        var stdioParams = ServerParameters.builder("java")
                .args(
                        "-Dspring.ai.mcp.server.stdio=true",
                        "-Dspring.main.web-application-type=none",
                        "-Dlogging.pattern.console=",
                        "-jar", "/Users/-/source/mcp-server-sample/spring-ai-server/build/libs/spring-ai-server-0.0.1-SNAPSHOT.jar"
                )
                .build();
        var stdioTransport = new StdioClientTransport(stdioParams);
        var mcpClient = McpClient.sync(stdioTransport).build();
        mcpClient.initialize();

        //2.listTools()
        McpSchema.ListToolsResult toolsList = mcpClient.listTools();

        //3.callTool()
        McpSchema.CallToolResult knowledgeDocuments = mcpClient.callTool(
                new McpSchema.CallToolRequest("getCompanyKnowledgeDocuments", Map.of())
        );


        //4.knowledgeDocuments 결과를 Claude Desktop 에서 분석

        //5.end
        mcpClient.closeGracefully();
         */
    }
}
