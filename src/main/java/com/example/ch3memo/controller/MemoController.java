package com.example.ch3memo.controller;

import com.example.ch3memo.dto.*;
import com.example.ch3memo.service.CommentService;
import com.example.ch3memo.service.MemoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;
    private final CommentService commentService;

    //c
    @PostMapping("/memos")
    public ResponseEntity<MemoCreateResponse> create(@Valid @RequestBody MemoCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(memoService.save(request));
    }

    //전체조회
    @GetMapping("/memos")
    public ResponseEntity<List<MemoGetResponse>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(memoService.findAll());
    }
    //사용자아이디로조회
    @GetMapping("/users/{userId}/memos")
    public ResponseEntity<List<MemoGetResponse>> findByUserId(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(memoService.findByUserId(userId));
    }

    //일정만단건조회
    @GetMapping("/memos/{memoId}")
    public ResponseEntity<MemoGetResponse> findOne(@PathVariable Long memoId){
        return ResponseEntity.status(HttpStatus.OK).body(memoService.findByMemoId(memoId));
    }

    //일정 단건과 댓글도 같이 조회
    @GetMapping("/memos/{memoId}/comments")
    public ResponseEntity<MemoCommentGetResponse> findByMemoId(@PathVariable Long memoId){
        return ResponseEntity.status(HttpStatus.OK).body(memoService.findByMemoIdAndComments(memoId));
    }


    //u
    @PutMapping("/memos/{memoId}")
    public ResponseEntity<MemoUpdateResponse>  update(@PathVariable Long memoId, @Valid @RequestBody MemoUpdateRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(memoService.update(memoId, request));
    }

    //d
    @DeleteMapping("/memos/{memoId}")
    public ResponseEntity<Void> delete(@PathVariable Long memoId){
        memoService.delete(memoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
