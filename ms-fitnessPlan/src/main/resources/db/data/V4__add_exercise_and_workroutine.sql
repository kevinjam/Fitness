INSERT INTO workout_routines (fitness_goal, description)
SELECT * FROM (
                  VALUES
                      ('WEIGHT_LOSS', 'Focuses on burning calories and improving cardiovascular health.'),
                      ('INCREASE MUSCLE MASS', 'Builds muscle definition and strength.'),
                      ('IMPROVE FLEXIBILITY', 'Increases range of motion and reduces stiffness.'),
                      ('INCREASE BONE DENSITY', 'Strengthens bones and reduces risk of osteoporosis.'),
                      ('IMPROVE CARDIOVASCULAR HEALTH', 'Improves heart health and endurance.'),
                      ('GET TONED', 'Improves muscle tone and overall physique.'),
                      ('RELIEVE STRESS', 'Reduces stress and promotes relaxation.'),
                      ('BOOST ENERGY LEVELS', 'Increases energy levels and improves mood.'),
                      ('Jumping Jacks', 'Improves core strength and agility (jumping exercise)')
              ) AS new_data (fitness_goal, description)
WHERE NOT EXISTS (
    SELECT 1 FROM workout_routines wr
    WHERE wr.fitness_goal = new_data.fitness_goal
);

INSERT INTO meals (name, description)
SELECT * FROM(
                 VALUES
                     ('Oatmeal Breakfast', 'A nutritious breakfast option made with oats, milk, and fruits.'),
                     ('Grilled Chicken Salad', 'A healthy salad with grilled chicken, mixed greens, and vegetables.'),
                     ('Quinoa Bowl', 'A protein-rich meal made with quinoa, black beans, avocado, and vegetables.'),
                     ('Salmon with Sweet Potatoes', 'Baked salmon served with roasted sweet potatoes and steamed broccoli.'),
                     ('Vegetable Stir-Fry', 'A delicious stir-fry with tofu, mixed vegetables, and a savory sauce.'),
                     ('Turkey Sandwich', 'A classic sandwich made with whole wheat bread, sliced turkey, lettuce, and tomato.'),
                     ('Greek Yogurt Parfait', 'A refreshing parfait with Greek yogurt, granola, and mixed berries.'),
                     ('Black Bean Tacos', 'Healthy tacos filled with black beans, corn, avocado, and salsa.'),
                     ('Egg White Omelette', 'A low-calorie omelette made with egg whites, spinach, tomatoes, and feta cheese.'),
                     ('Peanut Butter Banana Smoothie', 'A tasty smoothie with banana, peanut butter, milk, and a touch of honey.')
) AS new_data (name, description)
WHERE NOT EXISTS(
    SELECT 1 FROM meals m
             where m.name = new_data.name
);



-- INSERT INTO exercise (workout_routine_id, name, sets_reps) -- Adjusted to "sets_reps"
-- SELECT id, 'Squats', sets_reps -- Matched the column name "sets_reps"
-- FROM workout_routines
-- WHERE fitness_goal = 'WEIGHT_LOSS';
--
--
--
-- -- Weight Loss Exercises
-- INSERT INTO exercise (workout_routine_id, name, sets_reps)
-- SELECT id, 'Squats', :weight_loss_setsReps FROM workout_routines WHERE fitness_goal = 'WEIGHT_LOSS';
--
-- INSERT INTO exercise (workout_routine_id, name, sets_reps)
-- SELECT id, 'Push-ups', :weight_loss_setsReps FROM workout_routines WHERE fitness_goal = 'WEIGHT_LOSS';
--
-- INSERT INTO exercise (workout_routine_id, name, sets_reps)
-- SELECT id, 'Lunges', :weight_loss_setsReps FROM workout_routines WHERE fitness_goal = 'WEIGHT_LOSS';
--
-- INSERT INTO exercise (workout_routine_id, name, sets_reps)
-- SELECT id, 'Russian Twists', :weight_loss_setsReps FROM workout_routines WHERE fitness_goal = 'WEIGHT_LOSS';
--
-- -- Muscle Mass Exercises (Replace with your exercises)
-- INSERT INTO exercise (workout_routine_id, name, sets_reps)
-- SELECT id, 'Bench Press', :muscle_mass_setsReps FROM workout_routines WHERE fitness_goal = 'INCREASE MUSCLE MASS';
--
-- INSERT INTO exercise (workout_routine_id, name, sets_reps)
-- SELECT id, 'Rows', :muscle_mass_setsReps FROM workout_routines WHERE fitness_goal = 'INCREASE MUSCLE MASS';
--
-- INSERT INTO exercise (workout_routine_id, name, sets_reps)
-- SELECT id, 'Overhead Press', :muscle_mass_setsReps FROM workout_routines WHERE fitness_goal = 'INCREASE MUSCLE MASS';
--
-- -- Repeat for other fitness goals with appropriate exercises and placeholder values
--
-- -- Flexibility Exercises
-- INSERT INTO exercise (workout_routine_id, name, sets_reps)
-- SELECT id, 'Yoga', '30 minutes' FROM workout_routines WHERE fitness_goal = 'IMPROVE FLEXIBILITY';
--
-- INSERT INTO exercise (workout_routine_id, name, sets_reps)
-- SELECT id, 'Static Stretches', 'Hold each for 30 seconds (Focus on major muscle groups)' FROM workout_routines WHERE fitness_goal = 'IMPROVE FLEXIBILITY';
--
-- INSERT INTO exercise (workout_routine_id, name, sets_reps)
-- SELECT id, 'Foam Rolling', '10 minutes on major muscle groups' FROM workout_routines WHERE fitness_goal = 'IMPROVE FLEXIBILITY';
--
-- INSERT INTO exercise (workout_routine_id, name, sets_reps)
-- SELECT id, 'Pilates', '20 minutes' FROM workout_routines WHERE fitness_goal = 'IMPROVE FLEXIBILITY';
--
-- -- ... Repeat for other fitness goals
--
-- -- Jumping Jacks Routine (just one exercise)
-- INSERT INTO exercise (workout_routine_id, name, sets_reps)
-- SELECT id, 'Jumping Jacks', :jumping_jacks_setsReps FROM workout_routines WHERE fitness_goal = 'Jumping Jacks';
