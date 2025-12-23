package com.example.demo.matching.controller;

import com.example.demo.matching.dto.request.Preferences;
import com.example.demo.matching.dto.response.MatchingResultResponse;
import com.example.demo.matching.service.MatchingService;
import com.example.demo.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matching")
public class MatchingController {

    private final MatchingService matchingService;

    @PostMapping
    public ApiResponse<List<MatchingResultResponse>> match(
            @RequestParam Long userId,
            @RequestBody Preferences preferences
    ) {
        return ApiResponse.ok(
                matchingService.match(userId, preferences)
        );
    }
}