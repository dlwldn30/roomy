package com.example.demo.repair.controller;

import com.example.demo.common.ApiResponse;
import com.example.demo.repair.domain.RepairStatus;
import com.example.demo.repair.dto.request.*;
import com.example.demo.repair.dto.response.RepairAnalyzeResponse;
import com.example.demo.repair.dto.response.RepairReportResponse;
import com.example.demo.repair.service.RepairReportFacade;
import com.example.demo.repair.service.RepairReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repair-reports")
@RequiredArgsConstructor
public class RepairReportController {

    private final RepairReportService repairReportService;
    private final RepairReportFacade repairReportFacade;


    /** 🔥 신고 생성 (알고리즘 연동) */
    @PostMapping
    public ApiResponse<RepairAnalyzeResponse> create(
            @RequestBody RepairReportCreateRequest request
    ) {
        return ApiResponse.ok(
                repairReportFacade.analyzeAndCreate(request)
        );
    }

    @GetMapping
    public ApiResponse<List<RepairReportResponse>> list(
            @RequestParam(required = false) RepairStatus status
    ) {
        return ApiResponse.ok(
                repairReportService.getList(status)
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<RepairReportResponse> detail(
            @PathVariable Long id
    ) {
        return ApiResponse.ok(
                repairReportService.getDetail(id)
        );
    }

    @PatchMapping("/{id}/status")
    public ApiResponse<Void> updateStatus(
            @PathVariable Long id,
            @RequestBody RepairReportStatusUpdateRequest request
    ) {
        repairReportService.updateStatus(id, request.getStatus());
        return ApiResponse.ok();
    }

    @PatchMapping("/{id}/description")
    public ApiResponse<Void> updateDescription(
            @PathVariable Long id,
            @RequestBody RepairReportDescriptionRequest request
    ) {
        repairReportService.updateDescription(id, request.getDescription());
        return ApiResponse.ok();
    }
}