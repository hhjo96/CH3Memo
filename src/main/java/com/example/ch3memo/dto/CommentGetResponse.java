package com.example.ch3memo.dto;

import com.example.ch3memo.entity.Memo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CommentGetResponse {

    private final Long id;
    private final String body;
    private final Long userId;
    private final String password;

    public CommentGetResponse(Long id, String body, Long userId, String password) {
        this.id = id;
        this.body = body;
        this.userId = userId;
        this.password = password;
    }


}
