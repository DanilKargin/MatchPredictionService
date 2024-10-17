package com.example.PredictionService.service;

import com.example.PredictionService.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final MatchRepository matchRepository;
    /*private final MatchMapper matchMapper;

    public List<MatchDto> getMatchList(Pageable pageable){
        Page<Match> matches = matchRepository.findAll(pageable);
        return matches.stream()
                .map(matchMapper::toDto).toList();
    }

    @Transactional
    public void saveMatch(MatchDto newMatch){
        matchRepository.save(matchMapper.toMatch(newMatch));
    }

    @Transactional
    public MatchDto updateMatchResult(MatchUpdateRequest request){
        var match = matchRepository.findById(UUID.fromString(request.getId())).get();
        match.setResult(MatchResult.valueOf(request.getMatch_result()));
        match.setStatus(MatchStatus.FINISHED);
        return matchMapper.toDto(matchRepository.save(match));
    }
    @Transactional
    public void deleteMatch(UUID id){
        matchRepository.deleteById(id);
    }

     */
}
