package com.thinkdevs.userProfile.service;

import com.thinkdevs.userProfile.dto.response.UserResponse;
import com.thinkdevs.userProfile.exception.CustomException;
import com.thinkdevs.userProfile.model.UserProfile;
import com.thinkdevs.userProfile.repository.UserProfileRepository;
import com.thinkdevs.userProfile.dto.UserProfileDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    public Optional<UserResponse> getUserProfileById(Long id) {
        var users = userProfileRepository.findById(id)
                .orElseThrow(() -> new CustomException("User Not Found with ID::"+id, 404));
        var userResponse = new UserResponse();
        copyProperties(users,userResponse);
        log.info("user {} and response {}",users, userResponse);
        return Optional.of(userResponse);
    }

    public UserProfile createUserProfile(UserProfileDto userProfile) {

        var user =  UserProfile.builder()
                .id(userProfile.id())
                .firstName(userProfile.firstName())
                .age(userProfile.age())
                .weight(userProfile.weight())
                .height(userProfile.height())
                .fitnessGoals(userProfile.fitnessGoals())
                .dietaryPreferences(userProfile.dietaryPreferences())
                .activityLevel(userProfile.activityLevel())
                .build();
        return userProfileRepository.save(user);
    }

    public UserProfile updateUserProfile(Long id, UserProfileDto userProfile) {
        if (userProfileRepository.existsById(id)) {
            var user =  UserProfile.builder()
                    .id(userProfile.id())
                    .firstName(userProfile.firstName())
                    .age(userProfile.age())
                    .weight(userProfile.weight())
                    .height(userProfile.height())
                    .fitnessGoals(userProfile.fitnessGoals())
                    .dietaryPreferences(userProfile.dietaryPreferences())
                    .build();
            return userProfileRepository.save(user);
        }
        return null; // Or throw an exception
    }

    public void deleteUserProfile(Long id) {
        userProfileRepository.deleteById(id);
    }
}
