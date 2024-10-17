package com.example.PredictionService.service;
import com.example.PredictionService.controller.domain.ExpertRatingResponse;
import com.example.PredictionService.domain.entity.ExpertRating;
import com.example.PredictionService.domain.entity.User;
import com.example.PredictionService.repository.ExpertRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpertRatingService {
    private final ExpertRatingRepository expertRatingRepository;


    public List<ExpertRatingResponse> getListByRating(){
        return expertRatingRepository.getListExpertByRating().stream()
                .map(ExpertRatingResponse::new).collect(Collectors.toList());
    }
    public ExpertRating saveRating(ExpertRating rating){
        return expertRatingRepository.save(rating);
    }
    @Transactional
    public ExpertRating createRating(User expert){
        return saveRating(ExpertRating.builder()
                .rating(0)
                .user(expert)
                .build());
    }

    public ExpertRating editRating(User expert){
        var expertRating = expertRatingRepository.getRatingByUser(expert).get();
        var rating = expertRating.getRating();
        expertRating.setRating(rating + 1);
        return saveRating(expertRating);
    }

    public void deleteRating(String id){
        expertRatingRepository.deleteById(UUID.fromString(id));
    }
}
