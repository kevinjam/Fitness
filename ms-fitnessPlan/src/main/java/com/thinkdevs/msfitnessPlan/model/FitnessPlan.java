package com.thinkdevs.msfitnessPlan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FitnessPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int durationInDays;
    @OneToMany(mappedBy = "fitnessPlan", cascade = CascadeType.ALL)
    private List<Exercise> exercises;
    @OneToMany(mappedBy = "fitnessPlan", cascade = CascadeType.ALL)
    private List<MealEntity> meals;

}