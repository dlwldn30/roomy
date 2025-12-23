package com.example.demo.repair.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "repair_report",
        indexes = {
                @Index(name = "idx_building", columnList = "building"),
                @Index(name = "idx_floor", columnList = "floor")
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class RepairReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 10, nullable = false)
    private String floor;

    @Column(name = "room_number", length = 20)
    private String roomNumber;

    @Column(nullable = false, length = 100)
    private String item;

    @Column(nullable = false, length = 100)
    private String issue;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Severity severity;

    @Column(name = "priority_score", nullable = false)
    private Integer priorityScore;

    @Column(columnDefinition = "TEXT")
    private String reasoning;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "reporter_id", nullable = false)
    private Long reporterId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RepairStatus status;

    @Column(name = "image_url", nullable = false, length = 255)
    private String imageUrl;


    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.status = RepairStatus.PENDING;
    }

    public void updateStatus(RepairStatus status) {
        this.status = status;
    }

    public void updateDescription(String description) {
        this.description = description;
    }
}