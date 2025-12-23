package com.example.demo.repair.repository;

import com.example.demo.repair.domain.RepairReport;
import com.example.demo.repair.domain.RepairStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepairReportRepository extends JpaRepository<RepairReport, Long> {

    List<RepairReport> findByStatus(RepairStatus status);

    List<RepairReport> findByBuilding(String building);
}
