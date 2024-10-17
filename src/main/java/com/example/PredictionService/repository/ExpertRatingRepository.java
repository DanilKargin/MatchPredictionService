package com.example.PredictionService.repository;

import com.example.PredictionService.domain.entity.ExpertRating;
import com.example.PredictionService.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExpertRatingRepository extends JpaRepository<ExpertRating, UUID> {
    @Query("SELECT r FROM expert_ratings r join users u on r.user = u order by r.rating desc limit 10")
    List<ExpertRating> getListExpertByRating();

    @Query("SELECT r FROM expert_ratings r WHERE r.user = ?1")
    Optional<ExpertRating> getRatingByUser(User user);
}
