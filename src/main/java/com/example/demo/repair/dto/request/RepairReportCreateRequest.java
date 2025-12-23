package com.example.demo.repair.dto.request;

import com.example.demo.repair.domain.Severity;
import lombok.Getter;

@Getter
public class RepairReportCreateRequest {

    private Long reporterId;
    private String floor;
    private String roomNumber;
    private String imageUrl;

    private String item;
    private String issue;
    private Severity severity;
    private int priorityScore;
    private String reasoning;
    private String description;
}