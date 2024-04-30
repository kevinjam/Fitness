package com.thinkdevs.msfitnessPlan.service;

import com.thinkdevs.msfitnessPlan.model.MealEntity;
import com.thinkdevs.msfitnessPlan.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealsServiceImpl implements MealService{

    private final MealRepository mealRepository;

    @Override
    public List<MealEntity> findByFitnessGoalsAndDietaryPreferences(List<String> fitnessGoals, String dietaryPreferences) {
        return mealRepository.findAll();
    }
}
