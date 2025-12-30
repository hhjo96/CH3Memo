package com.example.ch3memo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comments extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long memoId;
    @Size(max = 200) @Column(length = 700)
    private String body;
    @Column(nullable = false)
    private Long userId;
    @Column
    private String password;

    public Comments(Long memoId, String body, Long userId, String password) {
        this.memoId = memoId;
        this.body = body;
        this.userId = userId;
        this.password = password;
    }
}
