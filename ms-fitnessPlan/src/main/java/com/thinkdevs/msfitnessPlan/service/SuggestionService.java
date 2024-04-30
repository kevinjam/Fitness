package com.thinkdevs.msfitnessPlan.service;

import com.thinkdevs.msfitnessPlan.model.Suggestion;

import java.util.List;
import java.util.Optional;

public interface SuggestionService {

    List<String> getSuggestionsByCategory(String category);

    Optional<Suggestion> getDietaryTipByBMIRange(double bmi);
}
