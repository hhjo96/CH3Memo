package com.example.ch3memo.controller;

import com.example.ch3memo.dto.MemoCreateRequest;
import com.example.ch3memo.dto.MemoCreateResponse;
import com.example.ch3memo.dto.MemoGetResponse;
import com.example.ch3memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    //c
    @PostMapping("/memos")
    public ResponseEntity<MemoCreateResponse> create(@RequestBody MemoCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(memoService.save(request));
    }

    //전체조회
    @GetMapping("/memos")
    public ResponseEntity<List<MemoGetResponse>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(memoService.findAll());
    }
    //사용자아이디로조회
    @GetMapping("/memos/{userId}")
    public ResponseEntity<List<MemoGetResponse>> findByUserId(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(memoService.findByUserId(userId));
    }


}
