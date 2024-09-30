package com.joonhee.moneygate.mentor.domain.entity;

public class Mentor {
    private final Long id = 1L;
    private final String email;
    private final String nickName;
    private final String profileImage;

    public Mentor(String nickName, String email,String profileImage) {
        this.email = email;
        this.nickName = nickName;
        this.profileImage = profileImage;
    }

    public Long getMentorId() {
        return id;
    }
}
