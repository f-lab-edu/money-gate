package com.joonhee.moneygate.mentor.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Getter
public class Mentor {
    @Id
    @Column("mentor_id")
    private Long id;
    private final String email;
    private final String nickName;
    private final String profileImage;
    private final LocalDateTime createdAt;

    public Mentor(String nickName, String email,String profileImage) {
        this.email = email;
        this.nickName = nickName;
        this.profileImage = profileImage;
        this.createdAt = LocalDateTime.now();
    }
    public Mentor(String nickName, String email,String profileImage, LocalDateTime createdAt) {
        this.email = email;
        this.nickName = nickName;
        this.profileImage = profileImage;
        this.createdAt = createdAt;
    }
}
