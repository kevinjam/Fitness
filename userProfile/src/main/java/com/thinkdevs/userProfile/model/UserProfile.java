package com.thinkdevs.userProfile.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

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
    @NotNull
    private String phoneNumber;
    private int age;
    private double weight;
    private double height;
    private String fitnessGoals;
    private String dietaryPreferences;
    private String activityLevel;
    @JsonIgnore
    @NotNull
    private String password;
    private String token;
    private String country;
    private Integer countryCode;
}
