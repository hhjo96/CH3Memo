package com.example.ch3memo.service;

import com.example.ch3memo.dto.CommentCreateRequest;
import com.example.ch3memo.dto.CommentCreateResponse;

import com.example.ch3memo.dto.CommentGetResponse;
import com.example.ch3memo.dto.MemoCommentGetResponse;
import com.example.ch3memo.entity.Comment;
import com.example.ch3memo.entity.Memo;
import com.example.ch3memo.repository.CommentsRepository;
import com.example.ch3memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    //댓글 전체조회
    @Transactional(readOnly = true)
    public List<CommentGetResponse> findAllByMemoId(Long memoId){
        Memo memo = memoRepository.findById(memoId).orElseThrow(() -> new IllegalStateException("메모가 없습니다."));
        List<Comment> comments = memo.getComments();
        List<CommentGetResponse> commentGetResponses = new ArrayList<>();

        for(Comment comment : comments) {
            CommentGetResponse commentResponse =
                    new CommentGetResponse(comment.getId(), comment.getBody(), comment.getUserId(), comment.getPassword());
            commentGetResponses.add(commentResponse);
        }

        return commentGetResponses;
    }
}
