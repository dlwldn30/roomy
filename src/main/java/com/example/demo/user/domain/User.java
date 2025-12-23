package com.example.demo.user.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String name;

    private int birthYear;

    private String kakaoId;

    @Enumerated(EnumType.STRING)
    private Mbti mbti;

    private boolean smoker;

    // 시간대 (0~23)
    private int sleepTime;
    private int wakeTime;

    private boolean snoring;

    @Enumerated(EnumType.STRING)
    private CleaningCycle cleaningCycle;

    @Enumerated(EnumType.STRING)
    private DrinkingStyle drinkingStyle;

    private boolean bugKiller;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<DayOfWeek> absentDays;

    private String hobby;

    @Column(length = 1000)
    private String selfDescription;

    @Column(length = 1000)
    private String roommateDescription;



    public void update(
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
            String hobby,
            String selfDescription,
            String roommateDescription
    ) {
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
        this.selfDescription = selfDescription;
        this.roommateDescription = roommateDescription;
    }
}