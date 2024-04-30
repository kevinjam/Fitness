package com.thinkdevs.msfitnessPlan.repository;

import com.thinkdevs.msfitnessPlan.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Optional<Exercise> findExerciseByName(String name);
}
