package com.thinkdevs.msfitnessPlan.dao;

import com.thinkdevs.msfitnessPlan.model.Exercise;
import com.thinkdevs.msfitnessPlan.model.MealEntity;
import com.thinkdevs.msfitnessPlan.model.MealPlan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FitnessPlanDao {
    private String name;
    private String description;
    private int durationInDays;
//    @OneToMany(mappedBy = "fitnessPlan", cascade = CascadeType.ALL)
    private List<String> fitnessGoals;
    private List<MealEntity> meals;


    private List<Exercise> exercises;
    private MealPlan mealPlan;
    private Map<String, String> lifestyleSuggestions;

    public FitnessPlanDao(List<Exercise> exercises,
                          MealPlan mealPlan, Map<String,
            String> lifestyleSuggestions) {
        this.exercises = exercises;
        this.mealPlan = mealPlan;
        this.lifestyleSuggestions = lifestyleSuggestions;
    }
}
