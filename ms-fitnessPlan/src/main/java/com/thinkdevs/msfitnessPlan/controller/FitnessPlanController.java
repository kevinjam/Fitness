package com.thinkdevs.msfitnessPlan.controller;

import com.thinkdevs.msfitnessPlan.dao.FitnessPlanDao;
import com.thinkdevs.msfitnessPlan.model.FitnessPlan;
import com.thinkdevs.msfitnessPlan.service.FitnessPlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fitness/plans")
@Slf4j
public class FitnessPlanController {

    private final FitnessPlanService fitnessPlanService;

    @GetMapping("/generate/{userId}")
    public ResponseEntity<FitnessPlanDao> generateFitnessPlan(@PathVariable Long userId) {
        FitnessPlanDao fitnessPlan = fitnessPlanService.generateFitnessPlan(userId);
        return new ResponseEntity<>(fitnessPlan, HttpStatus.OK);
    }

    @PostMapping("/create-fitness/{userId}")
    public FitnessPlan createFitnessPlan(@RequestBody FitnessPlanDao fitnessPlan,
                                         @PathVariable("userId") Long userId) {
        return fitnessPlanService.createFitnessPlan(fitnessPlan, userId);
    }




    @GetMapping("/{planId}")
    public ResponseEntity<FitnessPlan> getFitnessPlanById(@PathVariable Long planId) {
        // Implement logic to retrieve fitness plan details by ID
        // This is just a placeholder
//        FitnessPlan fitnessPlan = new FitnessPlan(
//                planId,
//                "Sample workout routine",
//                "Sample meal plan",
//                "Sample lifestyle suggestions");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
