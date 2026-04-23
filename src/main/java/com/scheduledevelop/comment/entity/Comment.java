package com.scheduledevelop.comment.entity;

import com.scheduledevelop.schedule.entity.BaseEntity;
import com.scheduledevelop.schedule.entity.Schedule;
import com.scheduledevelop.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String content;

    // 🔥 일정과 연결
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    // 🔥 유저와 연결
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Comment(String content, Schedule schedule, User user) {
        this.content = content;
        this.schedule = schedule;
        this.user = user;
    }

    public void update(String content) {
        this.content = content;
    }
}
