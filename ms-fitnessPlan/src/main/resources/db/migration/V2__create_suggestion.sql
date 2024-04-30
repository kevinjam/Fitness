CREATE TABLE IF NOT EXISTS fitness_plan (
                             id  SERIAL PRIMARY KEY,
                             name VARCHAR(255),
                             description VARCHAR(255),
                             duration_in_days INTEGER
);

CREATE TABLE IF NOT EXISTS  suggestion
(
    id         SERIAL PRIMARY KEY,
    category   VARCHAR(255),
    suggestion VARCHAR(255)
);
DROP TABLE IF EXISTS exercise;
CREATE TABLE IF NOT EXISTS workout_routines
(
    id SERIAL PRIMARY KEY,
    fitness_goal VARCHAR(255),
    description VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS exercise
(
    id SERIAL PRIMARY KEY,
    workout_routine_id INT,
    name VARCHAR(255),
    sets_reps VARCHAR(255),
    fitness_plan_id BIGINT,
    FOREIGN KEY (workout_routine_id) REFERENCES workout_routines(id),
    FOREIGN KEY (fitness_plan_id) REFERENCES fitness_plan(id)
    );
CREATE TABLE IF NOT EXISTS meals (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      description VARCHAR(255),
                      fitness_plan_id BIGINT, -- Foreign key column
                      FOREIGN KEY (fitness_plan_id) REFERENCES fitness_plan(id)
);

-- CREATE TABLE nutritional_info (
--                                   meal_id BIGINT,
--                                   nutrition_name VARCHAR(255),
--                                   nutrition_value DOUBLE PRECISION,
--                                   FOREIGN KEY (meal_id) REFERENCES meals(id)
-- );