package com.thinkdevs.msfitnessPlan.service;

import com.thinkdevs.msfitnessPlan.model.Suggestion;
import com.thinkdevs.msfitnessPlan.repository.SuggestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository repository;

    @Override
    public List<String> getSuggestionsByCategory(String category) {
        List<Suggestion> suggestions = repository.findByCategory(category);
        return suggestions.stream()
                .map(Suggestion::getSuggestion)
                .collect(Collectors.toList());
    }

    public Optional<Suggestion> getDietaryTipByBMIRange(double bmi) {
        if (bmi < 18.5) {
            return Optional.of(repository.findSuggestionByCategory("dietaryTips",
                            "Start your day with a glass of water and fresh fruit.")
                    .orElse(new Suggestion("No category found", "No suggestion found")));

        } else if (bmi >= 25) {
            return Optional.of(repository.findSuggestionByCategory("dietaryTips",
                            "Focus on portion control and incorporate more fruits, vegetables, and whole grains.")
                    .orElse(new Suggestion("No category found", "No suggestion found")));
        } else {
            // Retrieve a generic tip for normal BMI range
            return repository.findByCategory("dietaryTips")
                    .stream()
                    .findAny();
        }
    }
}
