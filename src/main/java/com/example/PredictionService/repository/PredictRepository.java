package com.example.PredictionService.repository;

import com.example.PredictionService.domain.entity.Predict;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PredictRepository extends JpaRepository<Predict, UUID> {

}
