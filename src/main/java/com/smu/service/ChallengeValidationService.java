package com.smu.service;

import com.smu.model.Challenge;
import com.smu.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeValidationService {

    @Autowired
    private ChallengeRepository ChallengeRepository;

    public Challenge addEntity(Challenge challenge) {
        return ChallengeRepository.save(challenge);
    }

    public List<Challenge> getAllEntities() {
        return ChallengeRepository.findAll();
    }
}
