package com.joonhee.moneygate.newsfeed.dto;

import com.joonhee.moneygate.newsfeed.domain.entity.ContentOpenStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;

import java.time.LocalDateTime;

public record NewsFeedDetail(
    Long id,
    String key,
    Long mentorId,
    String mentorEmail,
    String body,
    ContentOpenStatus status,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    LocalDateTime deletedAt
) {
    public static NewsFeedDetail of(NewsFeed newsFeed, String mentorEmail) {
        return new NewsFeedDetail(
            newsFeed.getId(),
            newsFeed.getKey(),
            newsFeed.getMentorId(),
            mentorEmail,
            newsFeed.getBody(),
            newsFeed.getStatus(),
            newsFeed.getCreatedAt(),
            newsFeed.getUpdatedAt(),
            newsFeed.getDeletedAt()
        );
    }
}
