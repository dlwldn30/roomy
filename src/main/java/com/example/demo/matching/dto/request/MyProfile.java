package com.example.demo.matching.dto.request;

import com.example.demo.user.domain.DrinkingStyle;
import com.example.demo.user.domain.Gender;
import com.example.demo.user.domain.CleaningCycle;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MyProfile {

    private Long id;
    private Gender gender;
    private int birthYear;

    private boolean smoker;
    private int sleepTime;
    private int wakeTime;

    private CleaningCycle cleaningCycle;
    private DrinkingStyle drinkingStyle;

    private boolean snoring;
    private boolean bugKiller;

    private String roommateDescription;
}
