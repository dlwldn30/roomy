package com.example.demo.matching.dto.response;

import lombok.Getter;

@Getter
public class MatchingResultResponse {

    private Long userId;
    private String name;
    private double totalScore;
    private int rank;
    private MatchDetails matchDetails;
}