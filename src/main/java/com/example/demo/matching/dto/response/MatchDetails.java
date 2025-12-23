package com.example.demo.matching.dto.response;

import lombok.Getter;

@Getter
public class MatchDetails {

    private double tagScore;
    private double prefScore;
    private double textScore;
    private int age;
}