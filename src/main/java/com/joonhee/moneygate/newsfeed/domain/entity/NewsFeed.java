package com.joonhee.moneygate.newsfeed.domain.entity;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;
import com.joonhee.moneygate.mentor.domain.vo.MentorId;
import com.joonhee.moneygate.newsfeed.domain.vo.NewsFeedId;

import java.time.ZonedDateTime;
import java.util.UUID;

public class NewsFeed {
    private final NewsFeedId id;
    private final Mentor mentor;
    private String body;
    private ZonedDateTime deletedAt;

    public NewsFeedId getId() {
        return id;
    }

    public MentorId getMentorId() {
        return mentor.getMentorId();
    }

    public String getBody() {
        return body;
    }

    public Boolean isDeleted() {
        return deletedAt != null;
    }

    public NewsFeed(
            Mentor mentor,
            String body
    ) {
        this.id = new NewsFeedId(UUID.randomUUID());
        this.mentor = mentor;
        this.body = body;
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
