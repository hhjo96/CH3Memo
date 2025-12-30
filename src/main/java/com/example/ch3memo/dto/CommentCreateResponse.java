package com.example.ch3memo.dto;

import com.example.ch3memo.entity.Memo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentCreateResponse {
    private final Long id;
    private final String body;
    private final Long userId;
    private final Long memoId;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentCreateResponse(Long id, String body, Long userId, Long memoId,LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.body = body;
        this.userId = userId;
        this.memoId = memoId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}
