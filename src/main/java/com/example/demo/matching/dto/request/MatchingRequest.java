package com.example.demo.matching.dto.request;

import java.util.List;

public class MatchingRequest {

    private MyProfile myProfile;
    private Preferences preferences;
    private List<CandidateProfile> candidates;

    public MatchingRequest(
            MyProfile myProfile,
            Preferences preferences,
            List<CandidateProfile> candidates
    ) {
        this.myProfile = myProfile;
        this.preferences = preferences;
        this.candidates = candidates;
    }

    public MyProfile getMyProfile() {
        return myProfile;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public List<CandidateProfile> getCandidates() {
        return candidates;
    }
}