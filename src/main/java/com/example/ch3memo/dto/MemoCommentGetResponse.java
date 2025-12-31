package com.example.ch3memo.dto;

import com.example.ch3memo.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class MemoCommentGetResponse {
    private final Long id;
    private final String title;
    private final String body;
    private final Long userId;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final List<CommentGetResponse> commentResponses;

    public MemoCommentGetResponse(Long id, String title, String body, Long userId, LocalDateTime createdAt, LocalDateTime modifiedAt, List<CommentGetResponse> comments) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.commentResponses = comments;
    }
}
