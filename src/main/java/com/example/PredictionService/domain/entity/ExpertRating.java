package com.example.PredictionService.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expert_ratings")
public class ExpertRating {
    @Id
    @GeneratedValue
    @Column(name = "expert_rating_id")
    private UUID id;

    @Column(name = "rating", columnDefinition = "integer default 0", nullable = false)
    private Integer rating;

    @Column(name = "update_date", nullable = false)
    private Date updateDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
