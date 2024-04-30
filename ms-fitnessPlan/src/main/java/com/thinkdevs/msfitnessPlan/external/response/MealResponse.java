package com.thinkdevs.msfitnessPlan.external.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class MealResponse {
    private List<Meals> meals;
}


@AllArgsConstructor
@RequiredArgsConstructor
@Data
 class Meals {

    private String idMeal;
    private String strMeal;
    private String strInstructions;
    private String strMealThumb;
    private String strYoutube;

    // Getters and Setters for all fields
}
