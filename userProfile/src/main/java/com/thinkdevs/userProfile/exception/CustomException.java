package com.thinkdevs.userProfile.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private String errorCode;

    private Integer status;
}
