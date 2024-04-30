package com.thinkdevs.userProfile.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfile extends Auditing{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private int age;
    private double weight;
    private double height;
    private String fitnessGoals;
    private String dietaryPreferences;
    private String activityLevel;
    private String token;

}
