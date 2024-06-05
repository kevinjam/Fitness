-- V1__create_user_profile_table.sql
CREATE TABLE IF NOT EXISTS  user_profile
(
    id                  SERIAL PRIMARY KEY,
    first_name          VARCHAR(255),
    phone_number          VARCHAR(255),
    age                 INT              NOT NULL,
    weight              DOUBLE PRECISION NOT NULL,
    height              DOUBLE PRECISION NOT NULL,
    fitness_goals       VARCHAR(255),
    dietary_preferences VARCHAR(255),
    activity_level     VARCHAR(255),
    password     VARCHAR(255),
    token     VARCHAR(255),
    country     VARCHAR(255),
    country_code     INTEGER,
    created_by         VARCHAR(255),
    date_created       TIMESTAMP WITHOUT TIME ZONE,
    last_modified_by   VARCHAR(255),
    last_modified_date TIMESTAMP WITHOUT TIME ZONE
);
