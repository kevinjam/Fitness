package com.thinkdevs.msfitnessPlan.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workout_routine_id")
    private WorkoutRoutines workoutRoutine;
    private String name;
    @Column(name = "sets_reps")
    private String setsReps;

    @ManyToOne
    @JoinColumn(name = "fitness_plan_id")
    private FitnessPlan fitnessPlan;


    public Exercise(Long id, String name, String setsReps) {
        this.id = id;
        this.name = name;
        this.setsReps = setsReps;
    }

    // In Exercise class
    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                // Include other fields as needed, excluding collections
                '}';
    }
}
