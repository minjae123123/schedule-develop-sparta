package com.scheduledevelop.user.dtos;

import lombok.Getter;

@Getter
public class UpdateUserRequest {
    private String name;
    private String email;
}
