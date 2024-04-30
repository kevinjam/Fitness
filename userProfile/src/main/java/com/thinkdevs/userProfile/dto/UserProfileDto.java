package com.thinkdevs.userProfile.dto;


public record UserProfileDto(
        Long id,
        String firstName,

        int age,
        double weight,
        double height,
        String fitnessGoals,
        String dietaryPreferences,
        String activityLevel) {
}
