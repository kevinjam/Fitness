package com.thinkdevs.msfitnessPlan.repository;

import com.thinkdevs.msfitnessPlan.model.WorkoutRoutines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRoutineRepository extends JpaRepository<WorkoutRoutines, Long> {
    WorkoutRoutines findByFitnessGoal(String fitnessGoal);
}
