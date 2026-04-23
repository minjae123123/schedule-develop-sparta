package com.scheduledevelop.comment.dto;

import com.scheduledevelop.comment.entity.Comment;
import lombok.Getter;

@Getter
public class CreateCommentResponse {
    private final Long commentId;
    private final String content;
    private final Long userId;
    private final Long scheduleId;

    public CreateCommentResponse(Comment comment) {
        this.commentId = comment.getCommentId();
        this.content = comment.getContent();
        this.userId = comment.getUser().getUserId();
        this.scheduleId = comment.getSchedule().getScheduleId();
    }
}
