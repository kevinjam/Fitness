package com.thinkdevs.userProfile.controller;

import com.thinkdevs.userProfile.dto.UserProfileDto;
import com.thinkdevs.userProfile.dto.response.UserResponse;
import com.thinkdevs.userProfile.model.UserProfile;
import com.thinkdevs.userProfile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllUserProfiles() {
        List<UserProfile> userProfiles = userProfileService.getAllUserProfiles();
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserProfileById(@PathVariable Long id) {
        return new ResponseEntity<>(userProfileService.getUserProfileById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfileDto userProfile) {
        UserProfile createdProfile = userProfileService.createUserProfile(userProfile);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }

    //login

    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable Long id, @RequestBody UserProfileDto userProfile) {
        UserProfile updatedProfile = userProfileService.updateUserProfile(id, userProfile);
        if (updatedProfile != null) {
            return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable Long id) {
        userProfileService.deleteUserProfile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
