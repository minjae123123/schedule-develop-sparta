package com.scheduledevelop.comment.controller;

import com.scheduledevelop.comment.dto.CreateCommentRequest;
import com.scheduledevelop.comment.dto.CreateCommentResponse;
import com.scheduledevelop.comment.dto.GetCommentResponse;
import com.scheduledevelop.comment.service.CommentService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 생성
    @PostMapping
    public ResponseEntity<CreateCommentResponse> createComment(
            @Valid @RequestBody CreateCommentRequest request,
            HttpSession session
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.create(request,session));
    }

    // 일정별 댓글 전체 조회
    @GetMapping("/schedule/{scheduleId}")
    public ResponseEntity<List<GetCommentResponse>> getCommentsBySchedule(
            @PathVariable Long scheduleId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getAll(scheduleId));
    }


    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(
            @PathVariable Long commentId,
            HttpSession session
    ) {
        commentService.delete(commentId, session);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
