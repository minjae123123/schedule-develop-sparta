package com.scheduledevelop.dtos;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GetScheduleResponse {

    private final Long id;
    private final String title;
    private final String detail;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    //전체 조회 용
    public GetScheduleResponse(Long id, String title, String detail, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
