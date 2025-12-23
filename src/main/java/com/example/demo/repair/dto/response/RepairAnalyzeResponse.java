package com.example.demo.repair.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RepairAnalyzeResponse {

    private AnalysisResult analysis;
    private List<DuplicateResult> duplicates;


    @JsonProperty("is_new")
    private Boolean isNew;

    private Long newReportId;   // ✅ 반드시 Long + 정확한 이름
}