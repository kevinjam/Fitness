package com.thinkdevs.msfitnessPlan.service;

import com.thinkdevs.msfitnessPlan.dao.WorkoutRoutinesDao;
import com.thinkdevs.msfitnessPlan.model.Exercise;
import com.thinkdevs.msfitnessPlan.model.WorkoutRoutines;
import com.thinkdevs.msfitnessPlan.repository.WorkoutRoutineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRoutineRepository workoutRoutineRepository;

    @Override
    public List<Exercise> getWorkoutRoutine(String fitnessGoal) {
        WorkoutRoutines workoutRoutines = workoutRoutineRepository.findByFitnessGoal(fitnessGoal);
        if (workoutRoutines != null) {
          //  return workoutRoutines.getExercises();
            return null;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public WorkoutRoutines findByFitnessGoal(String fitnessGoal) {
        return workoutRoutineRepository.findByFitnessGoal(fitnessGoal);
    }

    @Override
    public WorkoutRoutines createWorkoutRoutine(WorkoutRoutinesDao workoutRoutine) {
        var request = WorkoutRoutines.builder()
                .description(workoutRoutine.getDescription())
                .fitnessGoal(workoutRoutine.getFitnessGoal()).build();
        return workoutRoutineRepository.save(request);
    }
}
