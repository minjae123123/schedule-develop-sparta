package com.scheduledevelop.user.dtos;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateUserRequest {
    private String name;
    private String email;

    @Size(min = 8, message = "비밀번호는 8자 이상이어야합니다")
    private String password;
}
