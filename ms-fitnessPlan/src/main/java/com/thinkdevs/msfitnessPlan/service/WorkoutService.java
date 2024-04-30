package com.thinkdevs.msfitnessPlan.service;

import com.thinkdevs.msfitnessPlan.dao.WorkoutRoutinesDao;
import com.thinkdevs.msfitnessPlan.model.Exercise;
import com.thinkdevs.msfitnessPlan.model.WorkoutRoutines;

import java.util.List;

public interface WorkoutService {
    List<Exercise> getWorkoutRoutine(String fitnessGoal);

    WorkoutRoutines findByFitnessGoal(String fitnessGoal);

    WorkoutRoutines createWorkoutRoutine(WorkoutRoutinesDao workoutRoutine);
}
