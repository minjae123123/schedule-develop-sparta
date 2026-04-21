package com.scheduledevelop.schedule.dtos;

import lombok.Getter;

@Getter
public class UpdateScheduleRequest {
    private String title;
    private String name;
    private String password;
}
