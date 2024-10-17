package com.example.PredictionService.service;

import com.example.PredictionService.repository.PredictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PredictService {
    private final PredictRepository predictRepository;


}
