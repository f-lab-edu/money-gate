package newsfeed.domain.entity;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;

public class NewsFeedStub {
    public static NewsFeed createDummyPublicNewsFeed(Long mentorId) {
        NewsFeed newsFeed = NewsFeed.createNewsFeedByPublic(
            mentorId,
            "내용"
        );
        return NewsFeed.builder()
            .key(newsFeed.getKey())
            .mentorId(newsFeed.getMentorId())
            .body(newsFeed.getBody())
            .status(newsFeed.getStatus())
            .likes(newsFeed.getLikes())
            .createdAt(newsFeed.getCreatedAt())
            .updatedAt(newsFeed.getUpdatedAt())
            .deletedAt(newsFeed.getDeletedAt())
            .build();
    }

    public static NewsFeed createDummyDraftNewsFeed(Long mentorId) {
        NewsFeed newsFeed = NewsFeed.createNewsFeedByDraft(
            mentorId,
            "내용"
        );
        return NewsFeed.builder()
            .key(newsFeed.getKey())
            .mentorId(newsFeed.getMentorId())
            .body(newsFeed.getBody())
            .status(newsFeed.getStatus())
            .likes(newsFeed.getLikes())
            .createdAt(newsFeed.getCreatedAt())
            .updatedAt(newsFeed.getUpdatedAt())
            .deletedAt(newsFeed.getDeletedAt())
            .build();
    }
}
