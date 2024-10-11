package com.joonhee.moneygate.newsfeed.dto.response;

import com.joonhee.moneygate.common.SliceContent;
import com.joonhee.moneygate.newsfeed.dto.NewsFeedDetail;

import java.time.LocalDateTime;

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

    public static SliceContent<NewsFeedResponse> of(SliceContent<NewsFeedDetail> sliceContent) {
        return new SliceContent<>(
            sliceContent.content().stream().map(NewsFeedResponse::of).toList(),
            sliceContent.nextCursor()
        );
    }
}
