package com.thinkdevs.msfitnessPlan.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class WorkoutRoutines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fitnessGoal;

    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "workoutRoutine")
    private List<Exercise> exercises;

    @Override
    public String toString() {
        return "WorkoutRoutines{" +
                "id=" + id +
                ", fitnessGoal='" + fitnessGoal + '\'' +
                // Include other fields as needed, excluding collections
                '}';
    }
}
