package com.joonhee.moneygate.newsfeed.dto;

import com.joonhee.moneygate.newsfeed.domain.entity.ContentStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;

import java.time.LocalDateTime;
import java.util.UUID;

public record NewsFeedDetail(
    Long id,
    UUID key,
    Long mentorId,
    String mentorEmail,
    String body,
    ContentStatus status,
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
