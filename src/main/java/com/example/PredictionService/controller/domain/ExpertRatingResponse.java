package com.example.PredictionService.controller.domain;

import com.example.PredictionService.domain.entity.ExpertRating;
import com.example.PredictionService.service.ExpertRatingService;
import lombok.Data;

@Data
public class ExpertRatingResponse {
    private int rating;
    private String username;
    public ExpertRatingResponse(ExpertRating expertRating){
        this.rating = expertRating.getRating();
        this.username = expertRating.getUser().getUsername();
    }
}
