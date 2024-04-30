package com.thinkdevs.msfitnessPlan.service;

import com.thinkdevs.msfitnessPlan.model.MealEntity;

import java.util.List;

public interface MealService {
    List<MealEntity> findByFitnessGoalsAndDietaryPreferences(List<String> fitnessGoals, String dietaryPreferences);

}
