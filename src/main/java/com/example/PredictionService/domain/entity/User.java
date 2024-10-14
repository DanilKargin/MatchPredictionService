package com.example.PredictionService.entity;

import com.example.PredictionService.app_enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", columnDefinition = "string default CLIENT", nullable = false)
    private Role role;

    @Column(name = "username",unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "is_blocked", columnDefinition = "boolean default false", nullable = false)
    private Boolean is_blocked;

    @OneToOne(orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name="expert_rating_id")
    private ExpertRating expertRating;

    @OneToMany(mappedBy = "user")
    private List<Predict> predicts;
}
