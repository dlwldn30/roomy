package com.example.demo.repair.service;

import com.example.demo.repair.domain.*;
import com.example.demo.repair.dto.request.*;
import com.example.demo.repair.dto.response.RepairReportResponse;
import com.example.demo.repair.repository.RepairReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairReportService {

    private final RepairReportRepository repairReportRepository;

    public RepairReportResponse create(
            Long reporterId,
            RepairReportCreateRequest request
    ) {
        RepairReport report = RepairReport.builder()
                .building(request.getBuilding())
                .floor(request.getFloor())
                .roomNumber(request.getRoomNumber())
                .item(request.getItem())
                .issue(request.getIssue())
                .severity(Severity.MEDIUM)
                .priorityScore(5)
                .description(request.getDescription())
                .imageUrl(request.getImageUrl())
                .reporterId(reporterId)
                .status(RepairStatus.PENDING)
                .build();

        return RepairReportResponse.from(
                repairReportRepository.save(report)
        );
    }

    public List<RepairReportResponse> getList(
            RepairStatus status,
            String building
    ) {
        List<RepairReport> reports;

        if (status != null) {
            reports = repairReportRepository.findByStatus(status);
        } else if (building != null) {
            reports = repairReportRepository.findByBuilding(building);
        } else {
            reports = repairReportRepository.findAll();
        }

        return reports.stream()
                .map(RepairReportResponse::from)
                .toList();
    }

    public RepairReportResponse getDetail(Long id) {
        RepairReport report = repairReportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("RepairReport not found"));
        return RepairReportResponse.from(report);
    }

    @Transactional
    public void updateStatus(
            Long id,
            RepairReportStatusUpdateRequest request
    ) {
        RepairReport report = repairReportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("RepairReport not found"));

        report.updateStatus(request.getStatus());
    }

    @Transactional
    public void updateDescription(Long id,RepairReportDescriptionRequest request){
        RepairReport report = repairReportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("RepairReport not found"));

        report.updateDescription(request.getDescription());
    }
}