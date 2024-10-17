package com.example.PredictionService.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "expert_ratings")
public class ExpertRating {
    @Id
    @GeneratedValue
    @Column(name = "expert_rating_id")
    private UUID id;

    @Column(name = "rating", columnDefinition = "integer default 0", nullable = false)
    private Integer rating;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private User user;
}
