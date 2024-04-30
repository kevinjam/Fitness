package com.thinkdevs.msfitnessPlan.service;

import com.thinkdevs.msfitnessPlan.dao.ExerciseDao;
import com.thinkdevs.msfitnessPlan.dao.ExerciseRequest;
import com.thinkdevs.msfitnessPlan.model.Exercise;

import java.util.List;
import java.util.Optional;


public interface ExerciseService {
    List<Exercise> createExercises(List<ExerciseRequest> exerciseRequests, Long userId);

    Optional<Exercise> findExerciseByName(String name);
}
