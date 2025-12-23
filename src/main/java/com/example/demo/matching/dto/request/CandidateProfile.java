package com.example.demo.matching.dto.request;

import com.example.demo.user.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CandidateProfile {

    private Long id;
    private String name;
    private Gender gender;
    private int birthYear;

    private String selfDescription;
}