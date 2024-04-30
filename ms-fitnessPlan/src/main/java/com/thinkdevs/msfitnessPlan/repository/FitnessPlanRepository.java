package com.thinkdevs.msfitnessPlan.repository;

import com.thinkdevs.msfitnessPlan.model.FitnessPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FitnessPlanRepository extends JpaRepository<FitnessPlan, Long> {
}
