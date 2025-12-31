package com.example.ch3memo.dto;

import com.example.ch3memo.entity.Memo;
import lombok.Getter;

@Getter
public class CommentCreateRequest {
    private String body;
    private String userName;
    private String password;

}
