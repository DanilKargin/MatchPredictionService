package com.example.PredictionService.service;

import com.example.PredictionService.controller.domain.MatchRequest;
import com.example.PredictionService.controller.domain.MatchResultRequest;
import com.example.PredictionService.domain.MatchResult;
import com.example.PredictionService.domain.MatchStatus;
import com.example.PredictionService.domain.entity.Match;
import com.example.PredictionService.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final MatchRepository matchRepository;
    public List<Match> getMatchList(Pageable pageable){
        Page<Match> matches = matchRepository.findAll(pageable);
        return matches.stream().toList();
    }

    public Match saveMatch(Match match){
        return matchRepository.save(match);
    }

    public Match createMatch(MatchRequest newMatch){
        var match = Match.builder()
                .match_name(newMatch.getMatch_name())
                .home_team(newMatch.getHome_team())
                .guest_team(newMatch.getGuest_team())
                .status(MatchStatus.PLANNED)
                .build();
        return saveMatch(match);
    }
    public Match findByName(String name){
        return  matchRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Матч не найден"));
    }
    @Transactional
    public Match editMatchResult(MatchResultRequest request){
        var match = findByName(request.getName());
        match.setResult(MatchResult.valueOf(request.getResult()));
        match.setStatus(MatchStatus.FINISHED);
        // Здесь нужно вызвать метод подсчета рейтинга
        return saveMatch(match);
    }

    @Transactional
    public void deleteMatch(MatchRequest newMatch){
        var match = findByName(newMatch.getMatch_name());
        matchRepository.delete(match);
    }
}
