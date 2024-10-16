package com.example.PredictionService.service;

import com.example.PredictionService.controller.domain.BlockedUserRequest;
import com.example.PredictionService.domain.Role;
import com.example.PredictionService.domain.entity.User;
import com.example.PredictionService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }


    public User create(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }
        return save(user);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

    }
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }
    public User blockUser(BlockedUserRequest userRequest){
        var blockedUser = getByUsername(userRequest.getUsername());
            if(blockedUser.getRole() != Role.ADMIN){
                blockedUser.setRole(Role.BLOCKED);
                return save(blockedUser);
            }else{
                throw new RuntimeException("У пользователя привелегии администратора");
            }
    }
}
