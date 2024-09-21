package com.joonhee.moneygate.newsfeed.domain.vo;

import java.util.UUID;

public class NewsFeedId {
    private final UUID id;

    public NewsFeedId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
