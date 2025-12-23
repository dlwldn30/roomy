package com.example.demo.matching.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MatchingRequest {

    private MyProfile myProfile;
    private Preferences preferences;
    private List<CandidateProfile> candidates;
}