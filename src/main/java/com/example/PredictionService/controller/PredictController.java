package com.example.PredictionService.controller;

import com.example.PredictionService.controller.domain.PredictRequest;
import com.example.PredictionService.controller.domain.PredictResponse;
import com.example.PredictionService.domain.entity.Predict;
import com.example.PredictionService.service.PredictService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.PredictionService.config.SecurityConfiguration.SECURITY_CONFIG_NAME;

@RestController
@RequestMapping("/predict")
@RequiredArgsConstructor
@SecurityRequirement(name = SECURITY_CONFIG_NAME)
public class PredictController {
    private final PredictService predictService;

    @GetMapping("/list")
    public ResponseEntity<List<PredictResponse>> getPredicts(){
        return ResponseEntity.ok(predictService.getPredictList());
    }
    @PostMapping("/create")
    public ResponseEntity<Predict> createPredict(@RequestBody PredictRequest request){
        return ResponseEntity.ok(predictService.createPredict(request));
    }
}
