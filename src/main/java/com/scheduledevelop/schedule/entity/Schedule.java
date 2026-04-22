package com.scheduledevelop.schedule.entity;

import com.scheduledevelop.user.entity.User;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    public Schedule(String title, String detail, User user) {
        this.title = title;
        this.detail = detail;
        this.user = user;

    }

    public void updateSchedule(String title, String name) {
        this.title = title;
        this.name = name;
    }
}
