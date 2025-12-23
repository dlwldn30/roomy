package com.example.demo.user.dto;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.*;

import lombok.Getter;

import java.time.DayOfWeek;
import java.util.Set;

@Getter
public class UserResponse {

    private Long id;
    private Gender gender;
    private String name;
    private int birthYear;
    private String kakaoId;
    private Mbti mbti;
    private boolean smoker;
    private int sleepTime;
    private int wakeTime;
    private boolean snoring;
    private CleaningCycle cleaningCycle;
    private DrinkingStyle drinkingStyle;
    private boolean bugKiller;
    private Set<DayOfWeek> absentDays;
    private String hobby;
    private String  selfDescription;
    private String roommateDescription;

    public UserResponse(User user) {
        this.id = user.getId();
        this.gender = user.getGender();
        this.name = user.getName();
        this.birthYear = user.getBirthYear();
        this.kakaoId = user.getKakaoId();
        this.mbti = user.getMbti();
        this.smoker = user.isSmoker();
        this.sleepTime = user.getSleepTime();
        this.wakeTime = user.getWakeTime();
        this.snoring = user.isSnoring();
        this.cleaningCycle = user.getCleaningCycle();
        this.drinkingStyle = user.getDrinkingStyle();
        this.bugKiller = user.isBugKiller();
        this.absentDays = user.getAbsentDays();
        this.hobby = user.getHobby();
        this.selfDescription = user.getSelfDescription();
        this.roommateDescription = user.getRoommateDescription();

    }
}