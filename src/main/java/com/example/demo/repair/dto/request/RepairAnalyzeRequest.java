package com.example.demo.repair.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RepairAnalyzeRequest {

    private List<Long> existingReportIds;
    private int totalReportCount;
    private String floor;
    private String roomNumber;
}