package com.example.demo.matching.mapper;

import com.example.demo.matching.dto.request.CandidateProfile;
import com.example.demo.user.domain.User;

public class CandidateProfileMapper {

    public static CandidateProfile from(User user) {
        return new CandidateProfile(
                user.getId(),
                user.getName(),
                user.getGender(),
                user.getBirthYear(),
                user.getSelfDescription()
        );
    }
}