package com.example.ch3memo.dto;

import com.example.ch3memo.entity.Memo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentCreateResponse {
    private final Long id;
    private final String body;
    private final String userName;
    private final Long memoId;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentCreateResponse(Long id, String body, String userName, Long memoId,LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.body = body;
        this.userName = userName;
        this.memoId = memoId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}
