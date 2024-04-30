package com.thinkdevs.msfitnessPlan.dao;

import com.thinkdevs.msfitnessPlan.model.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutRoutinesDao {
    private String fitnessGoal;
    private String description;
}
