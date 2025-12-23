package com.example.demo.matching.mapper;

import com.example.demo.matching.dto.request.MyProfile;
import com.example.demo.user.domain.User;

import java.util.List;

public class MyProfileMapper {

    public static MyProfile from(User user) {
        return new MyProfile(
                user.getId(),
                user.getGender(),
                user.getName(),
                user.getBirthYear(),
                user.getKakaoId(),
                user.getMbti(),
                user.isSmoker(),
                user.getSleepTime(),
                user.getWakeTime(),
                user.isSnoring(),
                user.getCleaningCycle(),
                user.getDrinkingStyle(),
                user.isBugKiller(),
                user.getAbsentDays(),
                user.getHobby()

        );
    }
}