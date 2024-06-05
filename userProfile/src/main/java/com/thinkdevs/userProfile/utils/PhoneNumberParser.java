package com.thinkdevs.userProfile.utils;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.thinkdevs.userProfile.dto.PhoneNumberInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class PhoneNumberParser {

    public static Optional<PhoneNumberInfo> parsePhoneNumber(String phoneNumber) {
        var phoneNumberUtil = PhoneNumberUtil.getInstance();
        try {

            var parsedPhoneNumber = phoneNumberUtil.parse(phoneNumber, null);
            int countryCode = parsedPhoneNumber.getCountryCode();
            var country = phoneNumberUtil.getRegionCodeForCountryCode(countryCode);
            var nationalNumber = parsedPhoneNumber.getNationalNumber();
            return Optional.of(new PhoneNumberInfo(countryCode, country, nationalNumber));
        } catch (Exception e) {
            log.info("Error parsing phone number: " + e.getMessage());
            return Optional.empty();
        }
    }
}