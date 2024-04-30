package com.thinkdevs.msfitnessPlan.repository;

import com.thinkdevs.msfitnessPlan.model.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MealRepository extends JpaRepository<MealEntity, Long> {
//    List<MealEntity> findByFitnessGoalsAndDietaryPreferences(List<String> fitnessGoals, String dietaryPreferences);
}