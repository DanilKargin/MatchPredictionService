package com.example.PredictionService.domain.entity;

import com.example.PredictionService.domain.MatchResult;
import com.example.PredictionService.domain.MatchStatus;
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
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue
    @Column(name = "match_id")
    private UUID id;

    @Column(name = "home_team", nullable = false)
    private String home_team;

    @Column(name = "guest_team", nullable = false)
    private String guest_team;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "string default PLANNED")
    private MatchStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "result")
    private MatchResult result;
}
