package com.thinkdevs.userProfile.service;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.thinkdevs.userProfile.dto.PhoneNumberInfo;
import com.thinkdevs.userProfile.dto.response.UserResponse;
import com.thinkdevs.userProfile.exception.CustomException;
import com.thinkdevs.userProfile.model.UserProfile;
import com.thinkdevs.userProfile.repository.UserProfileRepository;
import com.thinkdevs.userProfile.dto.UserProfileDto;
import com.thinkdevs.userProfile.utils.PhoneNumberParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    public Optional<UserResponse> getUserProfileById(Long id) {
        var users = userProfileRepository.findById(id)
                .orElseThrow(() -> new CustomException("User Not Found with ID::" + id, 404));
        var userResponse = new UserResponse();
        copyProperties(users, userResponse);
        return Optional.of(userResponse);
    }

    public UserProfile createUserProfile(UserProfileDto userProfile) {
        if (userProfileRepository.findByPhoneNumber(userProfile.phoneNumber()).isPresent())
            throw new CustomException("User Already Exists with Phone Number::" + userProfile.phoneNumber(), 400);
        if (!isValidPhoneNumber(userProfile.phoneNumber()))
            throw new CustomException("User Phone Number is Invalid", 400);

        if (userProfile.password() == null || userProfile.password().isEmpty())
            throw new CustomException("Password is Empty", 400);

        var numberInfo = PhoneNumberParser.parsePhoneNumber(userProfile.phoneNumber());
        return userProfileRepository.save(UserProfile.builder()
                .id(userProfile.id())
                .phoneNumber(userProfile.phoneNumber())
                .firstName(userProfile.firstName())
                .age(userProfile.age())
                .weight(userProfile.weight())
                .height(userProfile.height())
                .fitnessGoals(userProfile.fitnessGoals())
                .dietaryPreferences(userProfile.dietaryPreferences())
                .activityLevel(userProfile.activityLevel())
                .password(passwordEncoder.encode(userProfile.password()))
                .country(numberInfo.get().country())
                .countryCode(numberInfo.get().countryCode())
                .build());
    }

    public boolean verifyPassword(UserProfile user, String rawPassword) {
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }

    public UserProfile findByPhoneNumber(String phoneNumber) {
        return userProfileRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new CustomException("User Not Found with Phone Number::" + phoneNumber, 404));
    }

    public Optional<UserProfile> authenticateUser(String phoneNumber, String password) {
        Optional<UserProfile> user = userProfileRepository.findByPhoneNumber(phoneNumber);
        if (user.isPresent()) {
            UserProfile userProfile = user.get();

            if (passwordEncoder.matches(password, userProfile.getPassword())) {
                return user;
            }
        }
        return Optional.empty();
    }

    public UserProfile updateUserProfile(Long id, UserProfileDto userProfile) {
        if (userProfileRepository.existsById(id)) {
            var user = UserProfile.builder()
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

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\+[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
