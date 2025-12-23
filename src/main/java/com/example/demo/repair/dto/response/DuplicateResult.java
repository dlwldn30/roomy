package com.example.demo.repair.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DuplicateResult {

    private Long reportId;
    private String description;
    private String location;
}