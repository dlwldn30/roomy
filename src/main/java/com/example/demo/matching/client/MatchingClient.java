package com.example.demo.matching.client;

import com.example.demo.matching.dto.request.MatchingRequest;
import com.example.demo.matching.dto.response.MatchingResultResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class MatchingClient {

    private final WebClient webClient =
            WebClient.create("http://localhost:8000");

    public List<MatchingResultResponse> match(MatchingRequest request) {
        return webClient.post()
                .uri("/api/matching/match")
                .bodyValue(request)
                .retrieve()
                .bodyToFlux(MatchingResultResponse.class)
                .collectList()
                .block();
    }
}