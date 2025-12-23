package com.example.demo.matching.service;

import com.example.demo.matching.client.MatchingClient;
import com.example.demo.matching.dto.request.MatchingRequest;
import com.example.demo.matching.dto.request.Preferences;
import com.example.demo.matching.dto.response.MatchingResultResponse;
import com.example.demo.matching.mapper.CandidateProfileMapper;
import com.example.demo.matching.mapper.MyProfileMapper;
import com.example.demo.user.domain.User;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchingService {

    private final UserRepository userRepository;
    private final MatchingClient matchingClient;

    public List<MatchingResultResponse> match(Long myUserId, Preferences preferences) {

        User me = userRepository.findById(myUserId).orElseThrow();

        List<User> candidates = userRepository.findAll().stream()
                .filter(u -> !u.getId().equals(me.getId()))
                .toList();

        MatchingRequest request = new MatchingRequest(
                MyProfileMapper.from(me),
                preferences,
                candidates.stream()
                        .map(CandidateProfileMapper::from)
                        .toList()
        );

        return matchingClient.match(request);
    }
}