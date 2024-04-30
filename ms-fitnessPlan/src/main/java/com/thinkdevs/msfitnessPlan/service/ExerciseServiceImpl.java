package com.thinkdevs.msfitnessPlan.service;

import com.thinkdevs.msfitnessPlan.dao.ExerciseDao;
import com.thinkdevs.msfitnessPlan.dao.ExerciseRequest;
import com.thinkdevs.msfitnessPlan.external.client.ProfileService;
import com.thinkdevs.msfitnessPlan.model.Exercise;
import com.thinkdevs.msfitnessPlan.model.UserProfile;
import com.thinkdevs.msfitnessPlan.model.WorkoutRoutines;
import com.thinkdevs.msfitnessPlan.repository.ExerciseRepository;
import com.thinkdevs.msfitnessPlan.repository.WorkoutRoutineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ProfileService profileService;
    private final WorkoutRoutineRepository workoutRoutineRepository;

    @Override
    public List<Exercise> createExercises(List<ExerciseRequest> exerciseRequests, Long userId) {
        UserProfile userProfile = profileService.getUserById(userId).getBody();
        if (userProfile == null || userProfile.getId() == null) {
            throw new RuntimeException("User Not Found with ID: " + userId);
        }

        List<Exercise> exercises = new ArrayList<>();

        for (ExerciseRequest exerciseRequest : exerciseRequests) {
            String fitnessGoal = exerciseRequest.getFitnessGoal();
            log.info("fitnessGoal === {} ", fitnessGoal);

            List<ExerciseDao> exerciseDTOs = exerciseRequest.getExercises();

            log.info("user exercise === {} ", exerciseDTOs);

            WorkoutRoutines workoutRoutine = workoutRoutineRepository.findByFitnessGoal(fitnessGoal);

            log.info("fitnessGoal === {} ", workoutRoutine);


            if (workoutRoutine == null) {
                throw new RuntimeException("Workout routine not found for fitness goal: " + fitnessGoal);
            }

            for (ExerciseDao exerciseDTO : exerciseDTOs) {
                Exercise exercise = new Exercise();
                exercise.setName(exerciseDTO.getName());
                exercise.setSetsReps(exerciseDTO.getSetsReps());
                exercise.setWorkoutRoutine(workoutRoutine);
                exercises.add(exerciseRepository.save(exercise));
            }
        }

        return exercises;
    }

    @Override
    public Optional<Exercise> findExerciseByName(String name) {
        return exerciseRepository.findExerciseByName(name);
    }
//    public Exercise createExercise(ExerciseDao exerciseDao, Long userId) {
//
//        UserProfile body = profileService.getUserById(userId).getBody();
//        if (body.getId() != null) {
//            var fitnessGoals = body.getFitnessGoals();
//            var workoutRoutines = workoutRoutineRepository.findByFitnessGoal(fitnessGoals);
//            if (workoutRoutines != null) {
//                Exercise exercise = new Exercise();
//                exercise.setName(exerciseDao.getName());
//                exercise.setSetsReps(exerciseDao.getSetsReps());
//                exercise.setWorkoutRoutine(workoutRoutines);
//                return exerciseRepository.save(exercise);
//            } else {
//                throw new RuntimeException("Workout routine not found with ID: " + workoutRoutines.getId());
//            }
//        }else {
//            throw new RuntimeException("User Not Found with ID: " + userId);
//        }
//    }

}
