package com.thinkdevs.msfitnessPlan.exceptions;

public class WorkoutNotFoundException extends RuntimeException{

    public WorkoutNotFoundException(String message) {
        super(message);
    }
}
