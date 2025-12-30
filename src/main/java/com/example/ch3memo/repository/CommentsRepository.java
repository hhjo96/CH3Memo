package com.example.ch3memo.repository;

import com.example.ch3memo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
    long countByMemoId(Long memoId);
}
