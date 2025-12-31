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
    @NotBlank @Size(max = 30) @Column(length = 30, nullable = false)
    private String title;
    @Size(max = 200) @Column(length = 200, nullable = false)
    private String body;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "memo")
    private List<Comment> comments = new ArrayList<>();

    public Memo(String title, String body, String userName, String password) {
        this.title = title;
        this.body = body;
        this.userName = userName;
        this.password = password;
    }

    public void update(String title, String userName) {
        this.title = title;
        this.userName = userName;
    }
}
