package com.thinkdevs.userProfile.repository;

import com.thinkdevs.userProfile.dto.UserProfileDto;
import com.thinkdevs.userProfile.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByPhoneNumber(String phoneNumber);
}
