package com.example.demo.repair.repository;

import com.example.demo.repair.domain.RepairReport;
import com.example.demo.repair.domain.RepairStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepairReportRepository extends JpaRepository<RepairReport, Long> {

    List<RepairReport> findByStatus(RepairStatus status);

    @Query("""
        select r
        from RepairReport r
        where r.floor = :floor
          and (
                (r.roomNumber = :roomNumber)
             or (r.roomNumber is null and :roomNumber is null)
          )
    """)
    List<RepairReport> findBySameLocation(
            @Param("floor") String floor,
            @Param("roomNumber") String roomNumber
    );
}