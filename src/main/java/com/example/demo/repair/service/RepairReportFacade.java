package com.example.demo.repair.service;

import com.example.demo.repair.dto.request.RepairAnalyzeRequest;
import com.example.demo.repair.dto.request.RepairReportCreateRequest;
import com.example.demo.repair.dto.response.RepairAnalyzeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairReportFacade {

    private final RepairAnalyzeService repairAnalyzeService;
    private final RepairReportService repairReportService;

    public RepairAnalyzeResponse analyzeAndCreate(
            RepairReportCreateRequest request
    ) {
        List<Long> existingReportIds =
                repairReportService.getSameLocationReportIds(
                        request.getFloor(),
                        request.getRoomNumber()
                );

        int totalReportCount = repairReportService.getTotalCount();

        RepairAnalyzeRequest analyzeRequest =
                new RepairAnalyzeRequest(
                        existingReportIds,
                        totalReportCount,
                        request.getFloor(),
                        request.getRoomNumber()
                );

        RepairAnalyzeResponse response =
                repairAnalyzeService.analyze(analyzeRequest);

        if (Boolean.TRUE.equals(response.getIsNew())) {
            repairReportService.create(
                    request.getReporterId(),
                    request,
                    response   // ✅ AI 결과 전체 전달
            );
        }

        return response;
    }
}