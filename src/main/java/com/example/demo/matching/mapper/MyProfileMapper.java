package com.example.demo.matching.mapper;

import com.example.demo.matching.dto.request.MyProfile;
import com.example.demo.user.domain.User;

public class MyProfileMapper {

    public static MyProfile from(User user) {
        return new MyProfile(
                user.getId(),
                user.getGender(),
                user.getBirthYear(),
                user.isSmoker(),
                user.getSleepTime(),
                user.getWakeTime(),
                user.getCleaningCycle(),
                user.getDrinkingStyle(),
                user.isSnoring(),
                user.isBugKiller(),
                user.getRoommateDescription()
        );
    }
}