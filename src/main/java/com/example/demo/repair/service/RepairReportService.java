package com.example.demo.repair.service;

import com.example.demo.repair.domain.RepairReport;
import com.example.demo.repair.domain.RepairStatus;
import com.example.demo.repair.domain.Severity;
import com.example.demo.repair.dto.request.RepairReportCreateRequest;
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
        var analysis = response.getAnalysis();

        // ✅ analysis가 null이어도 DB가 터지지 않도록 기본값 보장
        String item = analysis != null ? analysis.getItem() : "UNKNOWN";
        String issue = analysis != null ? analysis.getIssue() : "UNKNOWN";
        Severity severity = analysis != null
                ? Severity.valueOf(analysis.getSeverity())
                : Severity.MEDIUM;
        Integer priorityScore = analysis != null
                ? analysis.getPriorityScore()
                : 5;
        String reasoning = analysis != null ? analysis.getReasoning() : null;
        String description = analysis != null
                ? analysis.getDescription()
                : "AI 분석 결과를 불러오지 못했습니다.";

        Long reportId = response.getNewReportId();

        RepairReport report = RepairReport.builder()
                .id(reportId)
                .floor(request.getFloor())
                .roomNumber(request.getRoomNumber())
                .item(item)
                .issue(issue)
                .severity(severity)
                .priorityScore(priorityScore)
                .reasoning(reasoning)
                .description(description)
                .imageUrl("storage/repair_images/" + reportId + ".jpg")
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