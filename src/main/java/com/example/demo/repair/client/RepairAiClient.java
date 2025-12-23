package com.example.demo.repair.client;

import com.example.demo.repair.dto.request.RepairAnalyzeRequest;
import com.example.demo.repair.dto.response.RepairAnalyzeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class RepairAiClient {

    private final WebClient matchingWebClient;

    public RepairAnalyzeResponse analyze(RepairAnalyzeRequest request) {

        return matchingWebClient.post()
                .uri("/api/repair/analyze")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(RepairAnalyzeResponse.class)
                .block();
    }
}