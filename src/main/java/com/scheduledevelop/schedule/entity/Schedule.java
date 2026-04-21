package com.scheduledevelop.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {
    //일정 제목, 일정 내용, 작성자명, 비밀번호, 작성/수정일을 저장
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String detail;
    private String name;
    private String password;


    public Schedule(String title, String detail, String name, String password) {
        this.title = title;
        this.detail = detail;
        this.name = name;
        this.password = password;

    }

    public void updateSchedule(String title, String name) {
        this.title = title;
        this.name = name;
    }
}
