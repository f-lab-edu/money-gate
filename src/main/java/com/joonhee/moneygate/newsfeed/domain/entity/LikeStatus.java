package com.joonhee.moneygate.newsfeed.domain.entity;

public enum LikeStatus {
    CREATED("생성"),
    ACTIVE("활성"),
    DELETED("삭제");

    private String description;

    LikeStatus(String description) {
        this.description = description;
    }
}
