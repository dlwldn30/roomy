package com.example.demo.user.service;

import com.example.demo.user.domain.User;
import com.example.demo.user.dto.UserCreateRequest;
import com.example.demo.user.dto.UserResponse;
import com.example.demo.user.dto.UserUpdateRequest;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 생성
    public UserResponse create(UserCreateRequest request) {
        User user = User.builder()
                .gender(request.getGender())
                .name(request.getName())
                .birthYear(request.getBirthYear())
                .kakaoId(request.getKakaoId())
                .mbti(request.getMbti())
                .smoker(request.isSmoker())
                .sleepTime(request.getSleepTime())
                .wakeTime(request.getWakeTime())
                .snoring(request.isSnoring())
                .cleaningCycle(request.getCleaningCycle())
                .drinkingStyle(request.getDrinkingStyle())
                .bugKiller(request.isBugKiller())
                .absentDays(request.getAbsentDays())
                .hobby(request.getHobby())
                .selfDescription(request.getSelfDescription())
                .roommateDescription(request.getRoommateDescription())
                .build();

        return new UserResponse(userRepository.save(user));
    }

    // 조회
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return new UserResponse(user);
    }

    // 수정
    public UserResponse update(Long id, UserUpdateRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.update(
                request.getGender(),
                request.getName(),
                request.getBirthYear(),
                request.getKakaoId(),
                request.getMbti(),
                request.isSmoker(),
                request.getSleepTime(),
                request.getWakeTime(),
                request.isSnoring(),
                request.getCleaningCycle(),
                request.getDrinkingStyle(),
                request.isBugKiller(),
                request.getAbsentDays(),
                request.getHobby(),
                request.getSelfDescription(),
                request.getRoommateDescription()
        );

        return new UserResponse(user);
    }


}