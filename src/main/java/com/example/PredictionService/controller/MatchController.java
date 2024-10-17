package com.example.PredictionService.controller;

import com.example.PredictionService.controller.domain.MatchRequest;
import com.example.PredictionService.controller.domain.MatchResultRequest;
import com.example.PredictionService.domain.entity.Match;
import com.example.PredictionService.service.MatchService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.example.PredictionService.config.SecurityConfiguration.SECURITY_CONFIG_NAME;

@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
@SecurityRequirement(name = SECURITY_CONFIG_NAME)
public class MatchController {
    private final MatchService matchService;

    @GetMapping("/list")
    public ResponseEntity<List<Match>> getList(@PageableDefault()
                                                   Pageable pageable){
        return ResponseEntity.ok(matchService.getMatchList(pageable));
    }

    @PostMapping("/create")
    public ResponseEntity<Match> createMatch(@RequestBody MatchRequest newMatch){
        return ResponseEntity.ok(matchService.createMatch(newMatch));
    }

    @PutMapping("/edit-result")
    public ResponseEntity<Match> editResult(@RequestBody MatchResultRequest request){
        return ResponseEntity.ok(matchService.editMatchResult(request));
    }

}
