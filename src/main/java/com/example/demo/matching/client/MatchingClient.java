package com.example.demo.matching.client;

import com.example.demo.matching.dto.request.MatchingRequest;
import com.example.demo.matching.dto.response.MatchingResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MatchingClient {

    private final WebClient matchingWebClient;

    public List<MatchingResultResponse> match(MatchingRequest request) {
        return matchingWebClient.post()
                .uri("/api/matching/match")
                .bodyValue(request)
                .retrieve()
                .bodyToFlux(MatchingResultResponse.class)
                .collectList()
                .block();
    }
}