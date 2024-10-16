package com.example.PredictionService.controller;

import com.example.PredictionService.controller.domain.SignInRequest;
import com.example.PredictionService.controller.domain.SignUpRequest;
import com.example.PredictionService.controller.domain.TokenResponse;
import com.example.PredictionService.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationUserController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public TokenResponse signUp(@RequestBody SignUpRequest request) {
        return authenticationService.signUp(request);
    }

    @PostMapping("/sign-in")
    public TokenResponse signIn(@RequestBody SignInRequest request) {
        return authenticationService.signIn(request);
    }
}
