package com.example.demo.repair.dto.request;

import com.example.demo.repair.domain.RepairStatus;
import lombok.Getter;

@Getter
public class RepairReportStatusUpdateRequest {

    private RepairStatus status;
}