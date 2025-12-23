package com.example.demo.repair.controller;

import com.example.demo.common.ApiResponse;
import com.example.demo.repair.dto.request.RepairAnalyzeRequest;
import com.example.demo.repair.dto.response.RepairAnalyzeResponse;
import com.example.demo.repair.service.RepairAnalyzeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/repair")
public class RepairAnalyzeController {

    private final RepairAnalyzeService repairAnalyzeService;

    @PostMapping("/analyze")
    public ApiResponse<RepairAnalyzeResponse> analyze(
            @RequestBody RepairAnalyzeRequest request
    ) {
        return ApiResponse.ok(
                repairAnalyzeService.analyze(request)
        );
    }
}