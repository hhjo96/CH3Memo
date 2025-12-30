package com.example.ch3memo.dto;

import lombok.Getter;

@Getter
public class MemoCreateRequest {
    private String title;
    private String body;
    private Long userId;
    private String password;
}
