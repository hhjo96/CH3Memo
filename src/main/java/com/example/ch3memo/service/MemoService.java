package com.example.ch3memo.service;

import com.example.ch3memo.dto.MemoCreateRequest;
import com.example.ch3memo.dto.MemoCreateResponse;
import com.example.ch3memo.dto.MemoGetResponse;
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

    //메모 생성자 title body userid password

    //생성
    @Transactional
    public MemoCreateResponse save(MemoCreateRequest request) {
        Memo memo = new Memo(request.getTitle(), request.getBody(), request.getUserId(), request.getPassword());
        Memo savedMemo = memoRepository.save(memo);
        return new MemoCreateResponse(savedMemo.getId(), savedMemo.getTitle(), savedMemo.getBody(),
                savedMemo.getUserId(), savedMemo.getCreatedAt(), savedMemo.getModifiedAt());
    }

    //전체조회
    @Transactional(readOnly = true)
    public List<MemoGetResponse> findAll() {
        List<Memo> memos = memoRepository.findAllByOrderByModifiedAtDesc();
        return memos.stream().map(memo -> new MemoGetResponse(memo.getId(), memo.getTitle(), memo.getBody(),
                memo.getUserId(), memo.getCreatedAt(), memo.getModifiedAt())).toList();
    }

    //사용자아이디로검색 조회
    @Transactional(readOnly = true)
    public List<MemoGetResponse> findByUserId(Long userId) {
        List<Memo> memos = memoRepository.findAllByUserIdOrderByModifiedAtDesc(userId);
        return memos.stream().map(memo -> new MemoGetResponse(memo.getId(), memo.getTitle(), memo.getBody(),
                memo.getUserId(), memo.getCreatedAt(), memo.getModifiedAt())).toList();
    }

    //단건조회
    @Transactional(readOnly = true)
    public MemoGetResponse findByMemoId(Long memoId){
        Memo memo = memoRepository.findById(memoId).orElseThrow(() -> new IllegalStateException("메모가 없습니다."));
        return new MemoGetResponse(memo.getId(), memo.getTitle(), memo.getBody(), memo.getUserId(), memo.getCreatedAt(), memo.getModifiedAt());
    }
}
