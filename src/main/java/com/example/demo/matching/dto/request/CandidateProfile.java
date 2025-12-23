package com.example.demo.matching.dto.request;

import com.example.demo.user.domain.*;
import lombok.Getter;

import java.time.DayOfWeek;
import java.util.Set;

@Getter
public class CandidateProfile {

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



    public CandidateProfile(
            Long id,
            Gender gender,
            String name,
            int birthYear,
            String kakaoId,
            Mbti mbti,
            boolean smoker,
            int sleepTime,
            int wakeTime,
            boolean snoring,
            CleaningCycle cleaningCycle,
            DrinkingStyle drinkingStyle,
            boolean bugKiller,
            Set<DayOfWeek> absentDays,
            String hobby

    ) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.birthYear = birthYear;
        this.kakaoId = kakaoId;
        this.mbti = mbti;
        this.smoker = smoker;
        this.sleepTime = sleepTime;
        this.wakeTime = wakeTime;
        this.snoring = snoring;
        this.cleaningCycle = cleaningCycle;
        this.drinkingStyle = drinkingStyle;
        this.bugKiller = bugKiller;
        this.absentDays = absentDays;
        this.hobby = hobby;

    }


}