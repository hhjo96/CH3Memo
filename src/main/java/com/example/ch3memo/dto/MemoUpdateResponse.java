package com.example.ch3memo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemoUpdateResponse {
    private final Long id;
    private final String title;
    private final String body;
    private final String userName;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public MemoUpdateResponse(Long id, String title, String body, String userName, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userName = userName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
