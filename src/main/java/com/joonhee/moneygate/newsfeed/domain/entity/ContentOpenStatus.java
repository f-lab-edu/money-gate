package com.joonhee.moneygate.newsfeed.domain.entity;

public enum ContentOpenStatus {
    PUBLIC("공개"),
    DELETED("삭제"),
    DRAFT("작성중");
    private String description;

    ContentOpenStatus(String description) {
        this.description = description;
    }

}