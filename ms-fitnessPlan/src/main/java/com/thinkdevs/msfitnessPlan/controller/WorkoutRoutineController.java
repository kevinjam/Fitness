package com.thinkdevs.msfitnessPlan.controller;

import com.thinkdevs.msfitnessPlan.dao.WorkoutRoutinesDao;
import com.thinkdevs.msfitnessPlan.model.WorkoutRoutines;
import com.thinkdevs.msfitnessPlan.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fitness/plans")
@RequiredArgsConstructor
public class WorkoutRoutineController {
    private final WorkoutService workoutService;

    @PostMapping("/workout-routines")
    public WorkoutRoutines createWorkoutRoutine(@RequestBody WorkoutRoutinesDao workoutRoutine) {
        return workoutService.createWorkoutRoutine(workoutRoutine);
    }


}
