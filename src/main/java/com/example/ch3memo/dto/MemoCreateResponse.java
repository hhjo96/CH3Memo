package com.example.ch3memo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemoCreateResponse {
    private final Long id;
    private final String title;
    private final String body;
    private final Long userId;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public MemoCreateResponse(Long id, String title, String body, Long userId, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
