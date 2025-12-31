package com.example.ch3memo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "memoId", nullable = false)
    private Memo memo;
    @Size(max = 100) @Column(length = 100, nullable = false)
    private String body;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;

    public Comment(Memo memo, String body, String userName, String password) {
        this.memo = memo;
        this.body = body;
        this.userName = userName;
        this.password = password;
    }
}
