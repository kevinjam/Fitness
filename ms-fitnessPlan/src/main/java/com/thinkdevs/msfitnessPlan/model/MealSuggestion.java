package com.thinkdevs.msfitnessPlan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class MealSuggestion {
    private String name;
    private String imageUrl;

}
