package com.thinkdevs.msfitnessPlan.service;

import com.thinkdevs.msfitnessPlan.dao.FitnessPlanDao;
import com.thinkdevs.msfitnessPlan.model.FitnessPlan;

public interface FitnessPlanService {
    FitnessPlanDao generateFitnessPlan(Long userId);

    FitnessPlan createFitnessPlan(FitnessPlanDao fitnessPlan, Long userId);

    FitnessPlan updateFitnessPlan(Long planId, FitnessPlan updatedPlan);

    void deleteFitnessPlan(Long planId);
}
