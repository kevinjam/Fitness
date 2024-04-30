package com.thinkdevs.msfitnessPlan.repository;

import com.thinkdevs.msfitnessPlan.model.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
    List<Suggestion> findByCategory(String category);


    @Query("SELECT s FROM Suggestion s WHERE s.category = :category AND s.suggestion = :suggestion")
    Optional<Suggestion> findSuggestionByCategory(@Param("category") String category,
                                                                   @Param("suggestion") String suggestion);

}
