package com.joonhee.moneygate.newsfeed.domain.entity;

public enum CommentStatus {
    PUBLIC("공개"),
    DELETED("삭제"),
    DRAFT("작성중");
    private String description;

    CommentStatus(String description) {
        this.description = description;
    }
}
