package com.example.PredictionService.repository;

import com.example.PredictionService.domain.entity.ExpertRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExpertRatingRepository extends JpaRepository<ExpertRating, UUID> {
}
