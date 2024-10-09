package com.joonhee.moneygate.account.domain.entity;

public enum Role {
    NEWS_FEED_WRITER("뉴스피드 작성자");
    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }
}
