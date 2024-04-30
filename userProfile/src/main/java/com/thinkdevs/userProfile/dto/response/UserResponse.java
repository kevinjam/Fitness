package com.thinkdevs.userProfile.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    private Long id;
    private String firstName;
    private int age;
    private double weight;
    private double height;
    private String fitnessGoals;
    private String dietaryPreferences;
    private String activityLevel;


}
