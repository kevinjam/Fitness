package com.thinkdevs.msfitnessPlan.service;


import com.thinkdevs.msfitnessPlan.dao.ExerciseDao;
import com.thinkdevs.msfitnessPlan.dao.FitnessPlanDao;
import com.thinkdevs.msfitnessPlan.exceptions.WorkoutNotFoundException;
import com.thinkdevs.msfitnessPlan.external.client.ProfileService;
import com.thinkdevs.msfitnessPlan.model.*;
import com.thinkdevs.msfitnessPlan.repository.FitnessPlanRepository;
import com.thinkdevs.msfitnessPlan.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class FitnessPlanServiceImpl implements FitnessPlanService {

    private final ProfileService profileService;
    private final SuggestionService suggestionService;
    private final WorkoutService workoutService;
    private final FitnessPlanRepository fitnessPlanRepository;
//    private final ExerciseService exerciseService;
    private final MealService mealService;

    @Override
    public FitnessPlanDao generateFitnessPlan(Long userId) {
        //TODO apply some machine learning or AI
        UserProfile userProfile = profileService.getUserById(userId).getBody();
        var workoutRoutine = generateWorkoutRoutine(userProfile);
        var mealPlan = generateMealPlan(userProfile);
        var lifestyleSuggestions = generateLifestyleSuggestions(userProfile);
        return new FitnessPlanDao(workoutRoutine, mealPlan, lifestyleSuggestions);
    }

    @Override
    public FitnessPlan createFitnessPlan(FitnessPlanDao fitnessPlanDao, Long userId) {
        UserProfile userProfile = profileService.getUserById(userId).getBody();
        List<Exercise> exercises = generateExercises(userProfile);
        log.info("Exercise ----- {} ", exercises);
        List<Meal> meals = generateMeals(fitnessPlanDao.getFitnessGoals());
        log.info("meals ----- {} ", meals);

//        List<MealEntity> meals = mealService.findByFitnessGoalsAndDietaryPreferences(
//                fitnessPlanDao.getFitnessGoals(), userProfile.getDietaryPreferences()
//        );
//        log.info("Meals ----- {} ", meals);
//        List<MealEntity> mealList = new ArrayList<>();
//        mealList.addAll(meals);




        FitnessPlan fitnessPlan = new FitnessPlan();
        fitnessPlan.setName(fitnessPlanDao.getName());
        fitnessPlan.setDescription(fitnessPlanDao.getDescription());
        fitnessPlan.setDurationInDays(fitnessPlanDao.getDurationInDays());
        fitnessPlan.setExercises(fitnessPlanDao.getExercises());
        fitnessPlan.setMeals(fitnessPlanDao.getMeals());
        return fitnessPlanRepository.save(fitnessPlan);
    }

    private List<Meal> generateMeals(List<String> fitnessGoals) {
        // Implement logic to generate meals based on fitness goals
        // This could involve selecting meals from a predefined database, adjusting nutritional content, etc.
        // For demonstration purposes, we'll create some sample meals

        List<Meal> meals = new ArrayList<>();
        for (String fitnessGoal : fitnessGoals) {
            if (fitnessGoal.equals("Build Muscle")) {
                meals.add(new Meal("High Protein Shake", "Protein powder, banana, almond milk"));
                meals.add(new Meal("Grilled Chicken Salad", "Grilled chicken, mixed greens, olive oil dressing"));
                // Add more meals for building muscle
            } else if (fitnessGoal.equals("Improve Strength")) {
                meals.add(new Meal("Salmon with Quinoa", "Grilled salmon, quinoa, steamed vegetables"));
                meals.add(new Meal("Turkey Sandwich", "Whole grain bread, turkey breast, lettuce, tomato"));
                // Add more meals for improving strength
            }
            // Add logic for other fitness goals
        }
        return meals;
    }

    private List<Exercise> generateExercises(UserProfile userProfile) {
        WorkoutRoutines workoutRoutines = workoutService.findByFitnessGoal(userProfile.getFitnessGoals());

        List<Exercise> exercises = new ArrayList<>();
        if (workoutRoutines != null){
            exercises.addAll(workoutRoutines.getExercises());
        }
        return exercises;
    }

    @Override
    public FitnessPlan updateFitnessPlan(Long planId, FitnessPlan updatedPlan) {
        return null;
    }

    @Override
    public void deleteFitnessPlan(Long planId) {

    }


    public List<Exercise> generateWorkoutRoutine(UserProfile userProfile) throws WorkoutNotFoundException {
        String fitnessGoal = userProfile.getFitnessGoals();
        log.info("Fitness Goal is here -{}- ", fitnessGoal);

        // Use WorkoutRoutineRepository to find the workout routine based on fitnessGoal
        WorkoutRoutines workoutRoutine = workoutService.findByFitnessGoal(fitnessGoal);
        System.out.println("---------------------  " + workoutRoutine);
        log.info("Found Workoutine ----- {}  ", workoutRoutine);
        if (workoutRoutine == null) {
            throw new WorkoutNotFoundException("Workout routine not found for fitness goal: " + fitnessGoal);
        }

        // Convert retrieved exercises (JPA entities) to a list of Exercise objects
        List<Exercise> exercises = new ArrayList<>();
        for (Exercise entityExercise : workoutRoutine.getExercises()) {
            exercises.add(new Exercise(entityExercise.getId(), entityExercise.getName(), entityExercise.getSetsReps()));
        }

        // Add additional exercises based on fitness goal
        switch (fitnessGoal) {
            case "WEIGHT_LOSS":
                exercises.addAll(buildCardioExercises(30)); // 30 minutes total cardio
                break;
            case "INCREASE MUSCLE MASS":
                exercises.addAll(buildCompoundExercises(3, 10)); // Example sets and reps
                break;
            // Add cases for other fitness goals
            default:
                break;
        }

        return exercises;
    }



//    private List<ExerciseDao> generateWorkoutRoutine(UserProfile userProfile) {
//        List<ExerciseDao> exerciseDaos = new ArrayList<>();
//
//        int age = userProfile.getAge();
//        int sets = age < 30 ? 3 : 2; // More sets for younger users (adjust thresholds as needed)
//        int reps = age < 30 ? 10 : 12;
//
//        // Choose exercises based on goals
//        switch (userProfile.getFitnessGoals()) {
//            case "WEIGHT_LOSS":
//                exerciseDaos.addAll(buildCardioExercises(30)); // 30 minutes total cardio
//                exerciseDaos.add(new ExerciseDao("Squats", sets + " sets of " + reps + " reps"));
//                exerciseDaos.add(new ExerciseDao("Push-ups", sets + " sets of " + reps + " reps (modify on knees if needed)"));
//                exerciseDaos.add(new ExerciseDao("Lunges", sets + " sets of " + reps + " reps per leg"));
//                exerciseDaos.add(new ExerciseDao("Russian Twists", sets + " sets of " + reps + " reps per side"));
//                break;
//            case "INCREASE MUSCLE MASS":
//                exerciseDaos.addAll(buildCompoundExercises(sets, reps)); // More emphasis on compound exercises
//                exerciseDaos.add(new ExerciseDao("Bicep Curls", sets + " sets of " + reps + " reps"));
//                exerciseDaos.add(new ExerciseDao("Tricep Extensions", sets + " sets of " + reps + " reps"));
//                exerciseDaos.add(new ExerciseDao("Calf Raises", sets + " sets of " + reps + " reps"));
//                break;
//            case "IMPROVE FLEXIBILITY":
//                exerciseDaos.add(new ExerciseDao("Yoga", "30 minutes"));
//                exerciseDaos.add(new ExerciseDao("Static Stretches (Hold each for 30 seconds)", "Focus on major muscle groups (legs, back, chest, shoulders)"));
//                exerciseDaos.add(new ExerciseDao("Foam Rolling", "10 minutes on major muscle groups"));
//                exerciseDaos.add(new ExerciseDao("Pilates", "20 minutes"));
//                break;
//            case "INCREASE BONE DENSITY":
//                exerciseDaos.addAll(buildWeightBearingExercises(sets, reps)); // Exercises with bodyweight or light weights
//                exerciseDaos.add(new ExerciseDao("Jumping Jacks", sets + " sets of 30 seconds"));
//                exerciseDaos.add(new ExerciseDao("Stair Climbing", "2 sets of 3 minutes each"));
//                exerciseDaos.add(new ExerciseDao("Dancing", "20 minutes"));
//                break;
//            case "IMPROVE CARDIOvascular HEALTH":
//                exerciseDaos.addAll(buildCardioExercises(30)); // 30 minutes total cardio
//                exerciseDaos.add(new ExerciseDao("Interval Training", "15 minutes (alternate between high intensity and recovery periods)"));
//                exerciseDaos.add(new ExerciseDao("Swimming", "20 minutes"));
//                exerciseDaos.add(new ExerciseDao("Cycling", "30 minutes"));
//                break;
//            case "GET TONED":
//                exerciseDaos.addAll(buildCompoundExercises(sets, reps)); // Include compound exercises for overall toning
//                exerciseDaos.add(new ExerciseDao("Lunges", sets + " sets of " + reps + " reps per leg"));
//                exerciseDaos.add(new ExerciseDao("Rows", sets + " sets of " + reps + " reps (use bodyweight or light weights)"));
//                exerciseDaos.add(new ExerciseDao("Overhead Press", sets + " sets of " + reps + " reps (use bodyweight or light weights)"));
//                break;
//            case "RELIEVE STRESS":
//                exerciseDaos.add(new ExerciseDao("Yoga", "45 minutes"));
//                exerciseDaos.add(new ExerciseDao("Meditation", "10 minutes"));
//                exerciseDaos.add(new ExerciseDao("Walking", "30 minutes in nature"));
//                exerciseDaos.add(new ExerciseDao("Tai Chi", "20 minutes"));
//                break;
//            case "BOOST ENERGY LEVELS":
//                exerciseDaos.addAll(buildCardioExercises(20)); // 20 minutes total cardio
//                exerciseDaos.add(new ExerciseDao("Strength Training (light weights)", sets + " sets of " + reps + " reps per exercise (focus on major muscle groups)"));
//                exerciseDaos.add(new ExerciseDao("Jumping Jacks", sets + " sets of 30 seconds"));
//                exerciseDaos.add(new ExerciseDao("Dancing", "15 minutes"));
//                break;
//            case "Jumping Jacks ":
//                exerciseDaos.add(new ExerciseDao("Plank", sets + " sets of 30 seconds hold"));
//                exerciseDaos.add(new ExerciseDao("Side Plank", sets + " sets of per side, 30 seconds hold (modify on knees if needed)"));
//                break;
//            default:
//                exerciseDaos.add(new ExerciseDao("Custom Exercise", "Custom Reps and Sets"));
//        }
//
//        return exerciseDaos;
//    }

    private List<ExerciseDao> buildWeightBearingExercises(int sets, int reps) {
        List<ExerciseDao> exerciseDaos = new ArrayList<>();

        // Sample weight-bearing exercises using bodyweight or light weights
        exerciseDaos.add(new ExerciseDao("Squats", sets + " sets of " + reps + " reps"));
        exerciseDaos.add(new ExerciseDao("Lunges", sets + " sets of " + reps + " reps per leg"));
        exerciseDaos.add(new ExerciseDao("Step-ups (find a sturdy bench or platform)", sets + " sets of " + reps + " reps per leg"));
        exerciseDaos.add(new ExerciseDao("Walking lunges", sets + " sets of " + reps + " meters walk forward"));

        return exerciseDaos;
    }


    // Helper methods to build different exercise categories
    private List<Exercise> buildCardioExercises(int totalDuration) {
        List<Exercise> cardioList = new ArrayList<>();
        int minutesPerExercise = totalDuration / 2; // Divide duration equally between two exercises

        // Example Cardio Exercises with durations
        cardioList.add(new Exercise(null,"Running", minutesPerExercise + " minutes"));
        cardioList.add(new Exercise(null,"Jumping Jacks", (totalDuration - minutesPerExercise) + " minutes at a moderate pace"));

        return cardioList;
    }

    private List<Exercise> buildCompoundExercises(int sets, int reps) {
        List<Exercise> compoundList = new ArrayList<>();

        // Example Compound Exercises targeting major muscle groups
        compoundList.add(new Exercise(null,"Squats", sets + " sets of " + reps + " reps"));
        compoundList.add(new Exercise(null,"Push-ups", sets + " sets of " + reps + " reps (modify on knees if needed)"));
        compoundList.add(new Exercise(null,"Deadlifts (bodyweight or light weights)", sets + " sets of " + reps + " reps"));
        compoundList.add(new Exercise(null,"Rows (use resistance bands or dumbbells if available)", sets + " sets of " + reps + " reps"));

        return compoundList;
    }


    public Map<String, String> generateLifestyleSuggestions(UserProfile userProfile) {
        Map<String, String> suggestions = new HashMap<>();

        // Basic checks for missing information
        if (userProfile == null) {
            suggestions.put("Error", "Missing user profile information. Let's get you started!");
            return suggestions;
        }

        // Access user details
        double weightInKg = userProfile.getWeight();
        double heightInMeters = userProfile.getHeight();

        // Calculate BMI (Body Mass Index)
        double bmi;
        // Handle potential exceptions during calculations
        try {
            bmi = calculateBMI(heightInMeters, weightInKg);
            suggestions.put("BMI", String.format("%.2f", bmi));

        } catch (ArithmeticException e) {
            suggestions.put("Error", "Error calculating BMI: " + e.getMessage());
            return suggestions;
        }
        // Fun message based on age
        suggestions.put("Fun Message", generateFunMessage(userProfile));
        Optional<Suggestion> dietaryTipByBMIRange = suggestionService.getDietaryTipByBMIRange(bmi);
        suggestions.put("Dietary Tip", dietaryTipByBMIRange.get().getSuggestion());

        return suggestions;
    }

    private double calculateBMI(double heightInMeters, double weightInKg) {
        // Handle potential division by zero
        if (heightInMeters <= 0) {
            throw new ArithmeticException("Height cannot be zero");
        }
        return weightInKg / (heightInMeters * heightInMeters);
    }

    public MealPlan generateMealPlan(UserProfile userProfile) {
        List<Meal> meals = new ArrayList<>();
        // Access dietary preferences from userProfile
        String dietaryPreferences = userProfile.getDietaryPreferences();

        // Logic to suggest meals based on dietary preferences (placeholder for future implementation)
        switch (dietaryPreferences) {
            case "FLEXIBILITY":
                // Sample meals for a flexible diet (replace with calls to external recipe APIs)
                meals.add(new Meal("Smoothie Bowl with Berries and Granola", "Morning (7:00 AM)"));
                meals.add(new Meal("Greek Yogurt with Fruit and Nuts", "Mid-Morning Snack (10:00 AM)"));
                meals.add(new Meal("Salmon with Roasted Vegetables and Quinoa", "Lunch (1:00 PM)"));
                // ... (add meals for rest of the day)
                break;
            case "VEGAN":
                // Sample vegan meals (replace with calls to external recipe APIs)
                meals.add(new Meal("Oatmeal with Berries and Nut Butter", "Morning (7:00 AM)"));
                meals.add(new Meal("Vegetable and Hummus Wrap", "Mid-Morning Snack (10:00 AM)"));
                meals.add(new Meal("Lentil Soup with Whole Grain Bread", "Lunch (1:00 PM)"));
                meals.add(new Meal("Stir-fried Tofu with Vegetables and Brown Rice", "Dinner (7:00 PM)"));
                // suggestions.addAll(getVeganMeals());
                break;
            case "PALEO":
                // Sample paleo meals (replace with calls to external recipe APIs)
                meals.add(new Meal("Scrambled Eggs with Vegetables", "Morning (7:00 AM)"));
                meals.add(new Meal("Handful of Almonds and Coconut Chips", "Mid-Morning Snack (10:00 AM)"));
                meals.add(new Meal("Grilled Chicken with Sweet Potato and Salad", "Lunch (1:00 PM)"));
                meals.add(new Meal("Salmon with Roasted Broccoli and Cauliflower", "Dinner (7:00 PM)"));
                break;
            default:
                meals.add(new Meal("Consult a Registered Dietitian", "For personalized meal plans"));
        }

        return new MealPlan(meals);
    }

    public static String generateFunMessage(UserProfile user) {
        StringBuilder messageBuilder = new StringBuilder();
        // Check for activity level (if available)
        if (user.getActivityLevel() != null) { // Assuming a getter for activityLevel exists
            String activityLevel = user.getActivityLevel();
            if (activityLevel.equals("high")) {
                messageBuilder.append("Wow, " + user.getFirstName() + "! All that exercise combined with a focus on energy levels is a great combination. Keep pushing those limits!\n");
            } else if (activityLevel.equals("low")) {
                messageBuilder.append("Hey " + user.getFirstName() + ", feeling a bit drained? Even small changes in your routine can make a big difference. Why not try a short walk or some light exercise to boost your energy?\n");
            }
        } else {
            // Use age for generic message
            int age = user.getAge();
            messageBuilder.append("At " + age + ", " + user.getFirstName() + ", getting enough sleep is crucial for energy levels. Aim for 7-8 hours a night and see the difference!\n");
        }

        // Dietary tip based on fitness goal
        String fitnessGoal = user.getFitnessGoals();
        if (fitnessGoal.equals(user.getFitnessGoals())) {
            String[] dietaryTipOptions = {
                    "Staying hydrated is key, " + user.getFirstName() + "! Aim for 8 glasses of water per day to keep your energy levels up.\n",
                    "Colorful fruits and veggies are packed with vitamins and minerals that can help you feel your best, " + user.getFirstName() + ". Aim for a rainbow on your plate!\n",
                    "Protein helps keep you feeling full and provides sustained energy throughout the day, " + user.getFirstName() + ". Consider adding lean protein sources like grilled chicken or fish to your meals.\n"
            };
            messageBuilder.append(dietaryTipOptions[(int) (Math.random() * dietaryTipOptions.length)]); // Random selection
        }

        return messageBuilder.toString(); // Return the combined message
    }


}


