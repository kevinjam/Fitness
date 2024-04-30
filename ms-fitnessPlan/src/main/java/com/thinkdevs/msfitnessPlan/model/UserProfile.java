package com.thinkdevs.msfitnessPlan.model;

import lombok.Data;

@Data
public class UserProfile {
    private Long id;
    private String firstName;
    private int age;
    private double weight;
    private double height;
    private String fitnessGoals;
    private String dietaryPreferences;
    private String activityLevel;

}
