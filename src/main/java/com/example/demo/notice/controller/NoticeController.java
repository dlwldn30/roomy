package com.example.demo.notice.controller;

import com.example.demo.common.ApiResponse;
import com.example.demo.notice.dto.NoticeRequest;
import com.example.demo.notice.dto.NoticeResponse;
import com.example.demo.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @PostMapping
    public ApiResponse<Void> create(@RequestBody NoticeRequest request) {
        noticeService.create(request);
        return ApiResponse.ok();
    }

    @GetMapping
    public ApiResponse<List<NoticeResponse>> findAll() {
        return ApiResponse.ok(noticeService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<NoticeResponse> findOne(@PathVariable Long id) {
        return ApiResponse.ok(noticeService.findOne(id));
    }
}