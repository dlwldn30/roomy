package com.example.demo.matching.dto.request;

import com.example.demo.user.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Preferences {

    private Gender targetGender;
    private boolean preferNonSmoker;
}