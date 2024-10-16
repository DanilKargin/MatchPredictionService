package com.example.PredictionService.controller.domain;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
