package com.example.ch3memo.controller;

import com.example.ch3memo.dto.CommentCreateRequest;
import com.example.ch3memo.dto.CommentCreateResponse;

import com.example.ch3memo.dto.MemoCommentGetResponse;
import com.example.ch3memo.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //c
    @PostMapping("/memos/{memoId}/comments")
    public ResponseEntity<CommentCreateResponse> create(@Valid @PathVariable Long memoId, @RequestBody CommentCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.save(memoId, request));
    }

}
