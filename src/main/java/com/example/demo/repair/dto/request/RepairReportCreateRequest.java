package com.example.demo.repair.dto.request;

import com.example.demo.repair.domain.IssueType;
import com.example.demo.repair.domain.RepairItem;
import lombok.Getter;

@Getter
public class RepairReportCreateRequest {

    private Long reporterId;   // ✅ 추가

    private String building;
    private String floor;
    private String roomNumber;

    private RepairItem item;
    private IssueType issue;

    private String description;
    private String imageUrl;
}