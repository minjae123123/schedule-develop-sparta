package com.scheduledevelop.dtos;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    private String name;
    private String email;
}
