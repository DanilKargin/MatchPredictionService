package com.example.PredictionService.controller.domain;

import lombok.Data;

@Data
public class PredictRequest {
    private String match_name;
    private String match_result;
}
