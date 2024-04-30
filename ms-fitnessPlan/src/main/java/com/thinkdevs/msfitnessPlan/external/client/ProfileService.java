package com.thinkdevs.msfitnessPlan.external.client;

import com.thinkdevs.msfitnessPlan.exceptions.CustomException;
import com.thinkdevs.msfitnessPlan.model.UserProfile;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient("MS-PROFILE/api/v1/auth")
public interface ProfileService {

    @GetMapping("/{id}")
    ResponseEntity<UserProfile> getUserById(@PathVariable Long id);

    default ResponseEntity<Integer> fallback(Exception e){
        throw new CustomException("Profile Service not available",
                "UNAVAILABLE",
                500);
    }
}
