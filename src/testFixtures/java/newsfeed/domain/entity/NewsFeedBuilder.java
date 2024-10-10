package newsfeed.domain.entity;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;

public class NewsFeedBuilder {
    public static NewsFeed createDummyPublicNewsFeed(Long mentorId) {
        return NewsFeed.createNewsFeedByPublic(
            mentorId,
            "내용"
        );
    }

    public static NewsFeed createDummyDraftNewsFeed(Long mentorId) {
        return NewsFeed.createNewsFeedByDraft(
            mentorId,
            "내용"
        );
    }
}
