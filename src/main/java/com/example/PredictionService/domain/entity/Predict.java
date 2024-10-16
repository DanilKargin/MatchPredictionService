package com.example.PredictionService.domain.entity;

import com.example.PredictionService.domain.MatchResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "predicts")
public class Predict {
    @Id
    @GeneratedValue
    @Column(name = "predict_id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "match_result")
    private MatchResult matchResult;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
