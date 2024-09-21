package com.joonhee.moneygate.mentor.domain.entity;

import com.joonhee.moneygate.mentor.domain.vo.MentorId;

import java.util.UUID;

public class Mentor {
    private MentorId id;
    private final String nickName;
    private final String profileImage;

    public MentorId getMentorId() {
        return id;
    }

    public Mentor(String nickName, String profileImage) {
        this.id = new MentorId(UUID.randomUUID());
        this.nickName = nickName;
        this.profileImage = profileImage;
    }
}
