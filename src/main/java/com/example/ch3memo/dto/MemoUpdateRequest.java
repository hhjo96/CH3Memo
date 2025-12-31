package com.example.ch3memo.dto;

import lombok.Getter;

@Getter
public class MemoUpdateRequest {
    private String title;
    private String userName;
    private String password;
}
