package com.example.PredictionService.controller.domain;

import lombok.Data;

@Data
public class MatchRequest {
    private String match_name;
    private String home_team;
    private String guest_team;
}
