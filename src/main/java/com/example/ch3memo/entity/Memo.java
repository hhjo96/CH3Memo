package com.example.ch3memo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "memos")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Memo extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Size(max = 30) @Column(length = 100, nullable = false) // 한글 30글자가 db length 30보다 클 수 있다고 하여 수정
    private String title;
    @Size(max = 200) @Column(length = 700)
    private String body;
    @Column(nullable = false)
    private Long userId;
    private String password;
    @OneToMany(mappedBy = "memo")
    private List<Comments> comments = new ArrayList<>();

    public Memo(String title, String body, Long userId, String password) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.password = password;
    }

    public void update(String title, Long userId) {
        this.title = title;
        this.userId = userId;
    }
}
