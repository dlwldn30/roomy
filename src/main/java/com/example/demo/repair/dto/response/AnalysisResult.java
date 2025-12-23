package com.example.demo.repair.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnalysisResult {

    private String item;
    private String issue;
    private String severity;

    @JsonProperty("priority_score")
    private Integer priorityScore;

    private String reasoning;
    private String description;
}