package com.smu.repository;

import com.smu.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    void addChallenge(Challenge challenge);

    void deleteChallengeById(Long id);

    List<Challenge> findAllChallenges(String email);

    Challenge findChallengeById(String challengeName);

}
