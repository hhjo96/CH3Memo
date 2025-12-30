package com.example.ch3memo.controller;

import com.example.ch3memo.dto.MemoCreateRequest;
import com.example.ch3memo.dto.MemoCreateResponse;
import com.example.ch3memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @PostMapping("/memos")
    public ResponseEntity<MemoCreateResponse> create(@RequestBody MemoCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(memoService.save(request));
    }

}
