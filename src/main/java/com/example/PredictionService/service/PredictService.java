package com.example.PredictionService.service;

import com.example.PredictionService.controller.domain.PredictRequest;
import com.example.PredictionService.controller.domain.PredictResponse;
import com.example.PredictionService.domain.MatchResult;
import com.example.PredictionService.domain.MatchStatus;
import com.example.PredictionService.domain.entity.Match;
import com.example.PredictionService.domain.entity.Predict;
import com.example.PredictionService.repository.PredictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PredictService {
    private final PredictRepository predictRepository;
    private final MatchService matchService;
    private final UserService userService;


    public List<PredictResponse> getPredictList(){
        return predictRepository.getPredictsPlannedMatches().stream()
                .map(PredictResponse::new).collect(Collectors.toList());
    }
    public List<Predict> getPredictListByMatch(Match match){
        return predictRepository.getWinPredictsByMatch(match);
    }

    public Predict savePredict(Predict predict){
        return predictRepository.save(predict);
    }
    @Transactional
    public Predict createPredict(PredictRequest newPredict){
        var match = matchService.findByName(newPredict.getMatch_name());
        if(match.getStatus() != MatchStatus.PLANNED){
            throw new RuntimeException("Матч уже завершен");
        }
        var user = userService.getCurrentUser();
        var predict = Predict.builder()
                .predict_result(MatchResult.valueOf(newPredict.getMatch_result()))
                .user(user)
                .match(match)
                .build();
        return savePredict(predict);
    }

    public void deletePredict(String id){
        predictRepository.deleteById(UUID.fromString(id));
    }

}
