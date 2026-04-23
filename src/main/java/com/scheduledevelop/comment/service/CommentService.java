package com.scheduledevelop.comment.service;


import com.scheduledevelop.comment.dto.CreateCommentRequest;
import com.scheduledevelop.comment.dto.CreateCommentResponse;
import com.scheduledevelop.comment.dto.GetCommentResponse;
import com.scheduledevelop.comment.entity.Comment;
import com.scheduledevelop.comment.repository.CommentRepository;
import com.scheduledevelop.schedule.entity.Schedule;
import com.scheduledevelop.schedule.repository.ScheduleRepository;
import com.scheduledevelop.user.entity.User;
import com.scheduledevelop.user.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;


    public CreateCommentResponse create(CreateCommentRequest request, HttpSession session) {

        Long userId = (Long) session.getAttribute("LOGIN_USER");
        if (userId == null) {
            throw new RuntimeException("로그인이 필요합니다.");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        Schedule schedule = scheduleRepository.findById(request.getScheduleId())
                .orElseThrow(() -> new RuntimeException("일정 없음"));

        Comment comment = new Comment(
                request.getContent(),
                schedule,
                user
        );

        return new CreateCommentResponse(commentRepository.save(comment));
    }

    public List<GetCommentResponse> getAll(Long scheduleId) {
        return commentRepository.findBySchedule_ScheduleId(scheduleId)
                .stream()
                .map(GetCommentResponse::new)
                .toList();
    }


    public void delete(Long commentId, HttpSession session) {

        Long userId = (Long) session.getAttribute("LOGIN_USER");

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("댓글 없음"));

        if (!comment.getUser().equals(userId)) {
            throw new RuntimeException("본인 댓글만 삭제 가능");
        }

        commentRepository.delete(comment);
    }
}
