package com.example.PredictionService.controller;

import com.example.PredictionService.controller.domain.ExpertRatingResponse;
import com.example.PredictionService.service.ExpertRatingService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.PredictionService.config.SecurityConfiguration.SECURITY_CONFIG_NAME;

@RestController
@RequestMapping("/expert-rating")
@RequiredArgsConstructor
@SecurityRequirement(name = SECURITY_CONFIG_NAME)
public class ExpertRatingController {
    private final ExpertRatingService expertRatingService;

    @GetMapping("/top")
    public ResponseEntity<List<ExpertRatingResponse>> getTopByRating(){
        return ResponseEntity.ok(expertRatingService.getListByRating());
    }
}
