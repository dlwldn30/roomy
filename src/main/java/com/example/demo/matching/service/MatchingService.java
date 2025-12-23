package com.example.demo.matching.service;

import com.example.demo.matching.client.MatchingClient;
import com.example.demo.matching.dto.request.MatchingRequest;
import com.example.demo.matching.dto.request.Preferences;
import com.example.demo.matching.dto.response.MatchingResultResponse;
import com.example.demo.matching.mapper.CandidateProfileMapper;
import com.example.demo.matching.mapper.MyProfileMapper;
import com.example.demo.user.domain.User;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchingService {

    private final UserRepository userRepository;
    private final MatchingClient matchingClient;

    public List<MatchingResultResponse> match(Long myUserId, Preferences preferences) {

        log.info("Matching start - userId={}", myUserId);

        User me = userRepository.findById(myUserId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        int currentYear = Year.now().getValue();



        List<User> candidates = userRepository.findCandidates(
                myUserId

        );

        log.info("Candidate count={}", candidates.size());

        MatchingRequest request = new MatchingRequest(
                MyProfileMapper.from(me),
                preferences,
                candidates.stream()
                        .map(CandidateProfileMapper::from)
                        .toList()
        );

        try {
            return matchingClient.match(request);
        } catch (Exception e) {
            log.error("Matching algorithm server error", e);
            return List.of(); // fallback
        }
    }
}