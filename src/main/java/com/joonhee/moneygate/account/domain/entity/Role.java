package com.joonhee.moneygate.account.domain.entity;

public enum Role {
    USER("사용자"),
    NEWS_FEED_WRITER("뉴스피드 작성자");
    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
}
