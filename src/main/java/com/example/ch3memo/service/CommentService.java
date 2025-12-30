package com.example.ch3memo.service;

import com.example.ch3memo.dto.CommentCreateRequest;
import com.example.ch3memo.dto.CommentCreateResponse;

import com.example.ch3memo.entity.Comment;
import com.example.ch3memo.entity.Memo;
import com.example.ch3memo.repository.CommentsRepository;
import com.example.ch3memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final MemoRepository memoRepository;
    private final CommentsRepository commentsRepository;

    //생성
    @Transactional
    public CommentCreateResponse save(Long memoId, CommentCreateRequest request) {
        if(commentsRepository.countByMemoId(memoId) >= 10) { // 이미 10개인경우
            throw new IllegalStateException("댓글은 10개까지만 작성할 수 있습니다.");
        }
        Memo memo = memoRepository.findById(memoId).orElseThrow(() -> new IllegalStateException("메모가 없습니다."));
        Comment comment = new Comment(memo, request.getBody(), request.getUserId(), request.getPassword());
        Comment savedComment = commentsRepository.save(comment);
        return new CommentCreateResponse(savedComment.getId(), savedComment.getBody(), savedComment.getUserId(),
                savedComment.getMemo().getId(), savedComment.getCreatedAt(), savedComment.getModifiedAt());
    }

}
