package com.thinkdevs.msfitnessPlan.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExerciseRequest {
    private String fitnessGoal;
    private List<ExerciseDao> exercises;
}
