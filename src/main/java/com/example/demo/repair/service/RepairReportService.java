package com.example.demo.repair.service;

import com.example.demo.repair.domain.RepairReport;
import com.example.demo.repair.domain.RepairStatus;
import com.example.demo.repair.domain.Severity;
import com.example.demo.repair.dto.request.RepairReportCreateRequest;
import com.example.demo.repair.dto.response.AnalysisResult;
import com.example.demo.repair.dto.response.RepairAnalyzeResponse;
import com.example.demo.repair.dto.response.RepairReportResponse;
import com.example.demo.repair.repository.RepairReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairReportService {

    private final RepairReportRepository repairReportRepository;

    public void create(
            Long reporterId,
            RepairReportCreateRequest request,
            RepairAnalyzeResponse response
    ) {
        AnalysisResult analysis = response.getAnalysis();

        if (analysis == null) {
            throw new IllegalStateException("AI analysis result is null for new report");
        }

        RepairReport report = RepairReport.builder()
                .id(response.getNewReportId()) // 알고리즘에서 내려준 ID
                .floor(request.getFloor())
                .roomNumber(request.getRoomNumber())

                // 🔥 AI 분석 결과 매핑
                .item(analysis.getItem())
                .issue(analysis.getIssue())
                .severity(Severity.valueOf(analysis.getSeverity()))
                .priorityScore(analysis.getPriorityScore())
                .reasoning(analysis.getReasoning())
                .description(analysis.getDescription())

                // 🔧 메타 정보
                .imageUrl("storage/repair_images/" + response.getNewReportId() + ".jpg")
                .reporterId(reporterId)
                .status(RepairStatus.PENDING)
                .build();

        repairReportRepository.save(report);
    }

    public List<RepairReportResponse> getList(RepairStatus status) {
        return (status == null
                ? repairReportRepository.findAll()
                : repairReportRepository.findByStatus(status))
                .stream()
                .map(RepairReportResponse::from)
                .toList();
    }

    public RepairReportResponse getDetail(Long id) {
        return repairReportRepository.findById(id)
                .map(RepairReportResponse::from)
                .orElseThrow();
    }

    public void updateStatus(Long id, RepairStatus status) {
        RepairReport report = repairReportRepository.findById(id).orElseThrow();
        report.updateStatus(status);
    }

    public void updateDescription(Long id, String description) {
        RepairReport report = repairReportRepository.findById(id).orElseThrow();
        report.updateDescription(description);
    }

    public List<Long> getSameLocationReportIds(String floor, String roomNumber) {
        return repairReportRepository.findBySameLocation(floor, roomNumber)
                .stream()
                .map(RepairReport::getId)
                .toList();
    }

    public int getTotalCount() {
        return (int) repairReportRepository.count();
    }
}