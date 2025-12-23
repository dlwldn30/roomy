package com.example.demo.user.dto;

import com.example.demo.user.domain.*;

import java.time.DayOfWeek;
import java.util.Set;

public class UserCreateRequest {

    private Gender gender;
    private String name;
    private int birthYear;
    private String kakaoId;
    private Mbti mbti;
    private boolean smoker;
    private int sleepTime;   // 0~23
    private int wakeTime;    // 0~23
    private boolean snoring;
    private CleaningCycle cleaningCycle;
    private DrinkingStyle drinkingStyle;
    private boolean bugKiller;
    private Set<DayOfWeek> absentDays;
    private String hobby;
    private String selfDescription;
    private String roommateDescription;

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getKakaoId() {
        return kakaoId;
    }

    public Mbti getMbti() {
        return mbti;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public int getWakeTime() {
        return wakeTime;
    }

    public boolean isSnoring() {
        return snoring;
    }

    public CleaningCycle getCleaningCycle() {
        return cleaningCycle;
    }

    public DrinkingStyle getDrinkingStyle() {
        return drinkingStyle;
    }

    public boolean isBugKiller() {
        return bugKiller;
    }

    public Set<DayOfWeek> getAbsentDays() {
        return absentDays;
    }

    public String getHobby() {
        return hobby;
    }

    public String getSelfDescription() {
        return selfDescription;
    }

    public String getRoommateDescription() {
        return roommateDescription;
    }

}