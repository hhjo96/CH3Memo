package com.example.ch3memo.service;

import com.example.ch3memo.dto.MemoCreateRequest;
import com.example.ch3memo.dto.MemoCreateResponse;
import com.example.ch3memo.entity.Memo;
import com.example.ch3memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    //메모 생성자 title body userid password

    @Transactional
    public MemoCreateResponse save(MemoCreateRequest request) {
        Memo memo = new Memo(request.getTitle(), request.getBody(), request.getUserId(), request.getPassword());
        Memo savedMemo = memoRepository.save(memo);
        return new MemoCreateResponse(savedMemo.getId(), savedMemo.getTitle(), savedMemo.getBody(), savedMemo.getUserId(), savedMemo.getCreatedAt(), savedMemo.getModifiedAt());

    }
}
