package com.example.ch3memo.service;

import com.example.ch3memo.dto.*;
import com.example.ch3memo.entity.Memo;
import com.example.ch3memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;
    private final CommentService commentService;

    //메모 생성자 title body userid password

    //생성
    @Transactional
    public MemoCreateResponse save(MemoCreateRequest request) {
        Memo memo = new Memo(request.getTitle(), request.getBody(), request.getUserName(), request.getPassword());
        Memo savedMemo = memoRepository.save(memo);
        return new MemoCreateResponse(savedMemo.getId(), savedMemo.getTitle(), savedMemo.getBody(),
                savedMemo.getUserName(), savedMemo.getCreatedAt(), savedMemo.getModifiedAt());
    }


    //사용자아이디로검색 - 아이디가 있을수도, 없을수도 있다 조회
    @Transactional(readOnly = true)
    public List<MemoGetResponse> findByUserName(String userName) {
        //유저네임이 없는 경우 전체조회
        if(userName == null || userName.isEmpty()){
            List<Memo> memos = memoRepository.findAllByOrderByModifiedAtDesc();
            return memos.stream().map(memo -> new MemoGetResponse(memo.getId(), memo.getTitle(), memo.getBody(),
                    memo.getUserName(), memo.getCreatedAt(), memo.getModifiedAt())).toList();
        }
        //유저네임이 있는 경우 그것만 조회
        List<Memo> memos = memoRepository.findAllByUserNameOrderByModifiedAtDesc(userName);
        return memos.stream().map(memo -> new MemoGetResponse(memo.getId(), memo.getTitle(), memo.getBody(),
                memo.getUserName(), memo.getCreatedAt(), memo.getModifiedAt())).toList();
    }

    //메모단건조회
    @Transactional(readOnly = true)
    public MemoGetResponse findByMemoId(Long memoId){
        Memo memo = memoRepository.findById(memoId).orElseThrow(() -> new IllegalStateException("메모가 없습니다."));
        return new MemoGetResponse(memo.getId(), memo.getTitle(), memo.getBody(), memo.getUserName(), memo.getCreatedAt(), memo.getModifiedAt());
    }

    //메모와댓글같이조회
    public MemoCommentGetResponse findByMemoIdAndComments(Long memoId) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(() -> new IllegalStateException("메모가 없습니다."));
        List<CommentGetResponse> commentGetResponses = commentService.findAllByMemoId(memoId);
        return new MemoCommentGetResponse(memo.getId(), memo.getTitle(), memo.getBody(), memo.getUserName(), memo.getCreatedAt(), memo.getModifiedAt(), commentGetResponses);
    }


    //u
    @Transactional
    public MemoUpdateResponse update(Long memoId, MemoUpdateRequest request ){
        Memo memo = memoRepository.findById(memoId).orElseThrow(() -> new IllegalStateException("메모가 없습니다."));
        if(!request.getPassword().equals(memo.getPassword())){
            throw new IllegalStateException("비밀번호가 틀립니다.");
        }
        memo.update(request.getTitle(), request.getUserName());
        return new MemoUpdateResponse(memo.getId(), memo.getTitle(), memo.getBody(), memo.getUserName(), memo.getCreatedAt(), memo.getModifiedAt());
    }

    //d
    @Transactional
    public void delete(Long memoId, MemoDeleteRequest request){
        //메모가 있는지 검사 후 비밀번호 검사
        Memo memo = memoRepository.findById(memoId).orElseThrow(() -> new IllegalStateException("메모가 없습니다."));
        if(!request.getPassword().equals(memo.getPassword())){
            throw new IllegalStateException("비밀번호가 틀립니다.");
        }
        memoRepository.deleteById(memoId);
    }
}
