package com.scheduledevelop.dtos;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {
    private String title;
    private String detail;
    private String name;
    private String password;
}
