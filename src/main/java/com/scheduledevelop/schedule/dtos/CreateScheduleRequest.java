package com.scheduledevelop.schedule.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateScheduleRequest {
    @NotBlank(message = "제목은 필수입니다.")
    @Size(max = 10, message = "제목은 10자 이내입니다.")
    private String title;
    @NotBlank(message = "내용은 필수입니다.")
    private String detail;
    private String name;
    private String password;
}
