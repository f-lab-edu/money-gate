package com.joonhee.moneygate.newsfeed.dto.response;

import com.joonhee.moneygate.newsfeed.dto.NewsFeedDetail;

import java.time.LocalDateTime;
import java.util.UUID;

public record NewsFeedResponse(
    String key,
    String mentorEmail,
    String body,
    LocalDateTime createdAt
) {
    public static NewsFeedResponse of(NewsFeedDetail newsFeedDetail) {
        return new NewsFeedResponse(
            newsFeedDetail.key(),
            newsFeedDetail.mentorEmail(),
            newsFeedDetail.body(),
            newsFeedDetail.createdAt()
        );
    }
}
