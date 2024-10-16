package com.example.PredictionService.service;

import com.example.PredictionService.controller.domain.SignInRequest;
import com.example.PredictionService.controller.domain.SignUpRequest;
import com.example.PredictionService.controller.domain.TokenResponse;
import com.example.PredictionService.domain.Role;
import com.example.PredictionService.domain.entity.ExpertRating;
import com.example.PredictionService.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final ExpertRatingService expertRatingService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public TokenResponse signUpClient(SignUpRequest request) {

        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CLIENT)
                .build();

        userService.create(user);

        var jwt = jwtService.generateToken(user);
        return new TokenResponse(jwt);
    }
    @Transactional
    public TokenResponse signUpExpert(SignUpRequest request) {

        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.EXPERT)
                .build();

        userService.create(user);
        expertRatingService.createRating(user);

        var jwt = jwtService.generateToken(user);
        return new TokenResponse(jwt);
    }

    public TokenResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        var user = userService.userDetailsService()
                .loadUserByUsername(request.getUsername());

        var jwt = jwtService.generateToken(user);
        return new TokenResponse(jwt);
    }
}
