package com.example.PredictionService.repository;

import com.example.PredictionService.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT u FROM users u join expert_ratings r on u.user_id = r.user_id order by r.rating desc limit 10;")
    List<User> getListExpertByRating();

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
