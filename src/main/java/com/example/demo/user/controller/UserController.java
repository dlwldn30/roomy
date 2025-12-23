package com.example.demo.user.controller;

import com.example.demo.notice.common.ApiResponse;
import com.example.demo.user.dto.UserCreateRequest;
import com.example.demo.user.dto.UserResponse;
import com.example.demo.user.dto.UserUpdateRequest;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 생성
    @PostMapping
    public ApiResponse<UserResponse> create(@RequestBody UserCreateRequest request) {
        UserResponse response = userService.create(request);
        return ApiResponse.ok(response);
    }

    // 유저 단건 조회
    @GetMapping("/{id}")
    public ApiResponse<UserResponse> find(@PathVariable Long id) {
        UserResponse response = userService.findById(id);
        return ApiResponse.ok(response);
    }

    // 유저 수정
    @PutMapping("/{id}")
    public ApiResponse<UserResponse> update(
            @PathVariable Long id,
            @RequestBody UserUpdateRequest request
    ) {
        UserResponse response = userService.update(id, request);
        return ApiResponse.ok(response);
    }


}