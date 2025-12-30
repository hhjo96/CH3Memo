package com.example.ch3memo.repository;

import com.example.ch3memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    //userId 것만 조회-수정일기준
    List<Memo> findAllByUserIdOrderByModifiedAtDesc(Long userId);

    //전체조회-수정일기준
    List<Memo> findAllByOrderByModifiedAtDesc();
}

