package com.joonhee.moneygate.newsfeed.domain.entity;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;

import java.time.ZonedDateTime;
import java.util.UUID;

public class NewsFeed {
    private final Long id = 1L;     // AUTO_INCREMENT
    private final UUID key;
    private final Mentor mentor;
    private String body;
    private ZonedDateTime deletedAt;

    public NewsFeed(
        Mentor mentor,
        String body
    ) {
        this.key = UUID.randomUUID();
        this.mentor = mentor;
        this.body = body;
    }

    public UUID getKey() {
        return key;
    }

    public Long getMentorId() {
        return mentor.getMentorId();
    }

    public String getBody() {
        return body;
    }

    public Boolean isDeleted() {
        return deletedAt != null;
    }


    public NewsFeed updateBody(String body) {
        this.body = body;
        return this;
    }

    public NewsFeed delete() {
        this.deletedAt = ZonedDateTime.now();
        return this;
    }
}
