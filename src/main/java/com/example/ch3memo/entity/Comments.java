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
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "memoId", nullable = false)
    private Memo memo;
    @Size(max = 200) @Column(length = 700)
    private String body;
    @Column(nullable = false)
    private Long userId;
    @Column
    private String password;

    public Comments(Memo memo, String body, Long userId, String password) {
        this.memo = memo;
        this.body = body;
        this.userId = userId;
        this.password = password;
    }
}
