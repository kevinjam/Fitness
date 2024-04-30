package com.thinkdevs.msfitnessPlan.controller;

import com.thinkdevs.msfitnessPlan.dao.ExerciseDao;
import com.thinkdevs.msfitnessPlan.dao.ExerciseRequest;
import com.thinkdevs.msfitnessPlan.model.Exercise;
import com.thinkdevs.msfitnessPlan.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fitness/plans")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping("/exercises/{userId}")
    public List<Exercise> createExercise(@RequestBody List<ExerciseRequest> exercise, @PathVariable("userId") Long userId) {
        return exerciseService.createExercises(exercise, userId);
    }
}
