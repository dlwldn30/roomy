package com.example.demo.matching.mapper;

import com.example.demo.matching.dto.request.CandidateProfile;
import com.example.demo.user.domain.User;

import java.util.List;

public class CandidateProfileMapper {

    public static CandidateProfile from(User user) {
        return new CandidateProfile(
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