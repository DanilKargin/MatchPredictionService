package com.example.PredictionService.controller;

import com.example.PredictionService.domain.entity.User;
import com.example.PredictionService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;


}
