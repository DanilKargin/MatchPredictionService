package com.example.PredictionService.controller.domain;


import com.example.PredictionService.domain.entity.Predict;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class PredictResponse {
    private String predict_result;
    private String username;
    private String match_name;
    public PredictResponse(Predict predict){
        this.predict_result = predict.getResult().toString();
        this.username = predict.getUser().getUsername();
        this.match_name = predict.getMatch().getMatch_name();
    }
}
