package com.example.demo.repair.dto.response;

import com.example.demo.repair.domain.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class RepairReportResponse {

    private Long id;
    private String building;
    private String floor;
    private String roomNumber;

    private String item;
    private String issue;
    private Severity severity;
    private Integer priorityScore;

    private String description;
    private String imagePath;

    private RepairStatus status;
    private LocalDateTime createdAt;

    public static RepairReportResponse from(RepairReport report) {
        return RepairReportResponse.builder()
                .id(report.getId())
                .floor(report.getFloor())
                .roomNumber(report.getRoomNumber())
                .item(report.getItem())
                .issue(report.getIssue())
                .severity(report.getSeverity())
                .priorityScore(report.getPriorityScore())
                .description(report.getDescription())
                .imagePath(report.getImageUrl())
                .status(report.getStatus())
                .createdAt(report.getCreatedAt())
                .build();
    }
}