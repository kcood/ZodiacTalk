package com.lark.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lark.firstProject.config.WebClientConfig;
import com.lark.firstProject.dto.GptTestDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GenerateFortuneService {
    private final ObjectMapper objectMapper;
    private final WebClient webClient;


//"gpt-4o-mini",


    public void foo(){

    }

    public void generateFortuneByGpt(){

    }

    public Mono<String> getChatResponse(String appMessage) throws JsonProcessingException {
        GptTestDto dto = objectMapper.readValue(appMessage, GptTestDto.class);
        String userMessage = dto.getMessage();

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4o",
                "messages", new Object[]{
                        //Map.of("role", "user", "content", "You are a helpful assistant."),
                        Map.of("role", "user", "content", userMessage)
                },
                "temperature", 0.8
        );

        return webClient.post()
                .uri("/chat/completions")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("response");

                    if (choices != null && !choices.isEmpty()) {
                        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
                        return message != null ? (String) message.get("content") : "No response from OpenAPI.";
                    }
                    return "No response from OpenAPI.";
                });
    }

}
