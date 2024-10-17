package com.example.PredictionService.repository;

import com.example.PredictionService.domain.entity.Match;
import com.example.PredictionService.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface MatchRepository extends JpaRepository<Match, UUID> {
    @Query("SELECT * FROM matches m WHERE m.match_name LIKE ?1")
    Optional<Match> findByName(String name);
}
