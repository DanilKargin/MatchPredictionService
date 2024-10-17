package com.example.PredictionService.repository;

import com.example.PredictionService.domain.entity.Match;
import com.example.PredictionService.domain.entity.Predict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PredictRepository extends JpaRepository<Predict, UUID> {
    @Query("SELECT p FROM predicts p JOIN matches m ON p.match = m WHERE m.status LIKE 'PLANNED'")
    List<Predict> getPredictsPlannedMatches();

    @Query("SELECT p FROM predicts p JOIN matches m ON p.match = m WHERE m = ?1 AND m.match_result = p.predict_result")
    List<Predict> getWinPredictsByMatch(Match match);
}
