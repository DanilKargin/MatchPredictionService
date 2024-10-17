package com.example.PredictionService.controller;

import com.example.PredictionService.controller.domain.MatchUpdateRequest;
import com.example.PredictionService.dto.MatchDto;
import com.example.PredictionService.service.MatchService;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/match")
@AllArgsConstructor
public class MatchController {
    MatchService matchService;

    @GetMapping
    public ResponseEntity<String> getTest(){
        return ResponseEntity.ok("Все good");
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void createMatch(@RequestBody MatchDto newMatch){
        //matchService.saveMatch(newMatch);
    }
    /*@PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MatchDto> updateResultMatch(@RequestBody MatchUpdateRequest newResult){
        return ResponseEntity.ok(matchService.updateMatchResult(newResult));
    }*/

}
