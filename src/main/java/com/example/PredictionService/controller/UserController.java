package com.example.PredictionService.controller;

import com.example.PredictionService.controller.domain.BlockedUserRequest;
import com.example.PredictionService.domain.entity.ExpertRating;
import com.example.PredictionService.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import static com.example.PredictionService.config.SecurityConfiguration.SECURITY_CONFIG_NAME;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@SecurityRequirement(name = SECURITY_CONFIG_NAME)
public class UserController {
    private UserService userService;

    @GetMapping
    public String getInfo(@AuthenticationPrincipal UserDetails user) {
        return user.getUsername();
    }

    @PostMapping("/block-user")
    public void blockUser(@RequestBody BlockedUserRequest request){
        userService.blockUser(request);
    }
}
