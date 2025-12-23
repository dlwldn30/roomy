package com.example.demo.repair.service;

import com.example.demo.repair.client.RepairAiClient;
import com.example.demo.repair.dto.request.RepairAnalyzeRequest;
import com.example.demo.repair.dto.response.RepairAnalyzeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RepairAnalyzeService {

    private final RepairAiClient repairAiClient;

    public RepairAnalyzeResponse analyze(
            RepairAnalyzeRequest request
    ) {
        return repairAiClient.analyze(request);
    }
}