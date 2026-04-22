package com.scheduledevelop.user.dtos;

import lombok.Getter;

@Getter
public class LoginResponse {

    private final Long userId;
    private final String message;

    public LoginResponse(Long userId, String message) {
        this.userId = userId;
        this.message = message;
    }
}
