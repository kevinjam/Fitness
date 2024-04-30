package com.thinkdevs.userProfile.repository;

import com.thinkdevs.userProfile.dto.UserProfileDto;
import com.thinkdevs.userProfile.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
