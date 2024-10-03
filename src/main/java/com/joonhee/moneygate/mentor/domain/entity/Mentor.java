package com.joonhee.moneygate.mentor.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
public class Mentor {
    @Setter
    private Long id;
    private final String email;
    private final String nickName;
    private final String profileImage;
    private final ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public Mentor(String nickName, String email, String profileImage) {
        this.email = email;
        this.nickName = nickName;
        this.profileImage = profileImage;
        this.createdAt = ZonedDateTime.now();
    }

    public Mentor(Long id, String nickName, String email, String profileImage, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.profileImage = profileImage;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
