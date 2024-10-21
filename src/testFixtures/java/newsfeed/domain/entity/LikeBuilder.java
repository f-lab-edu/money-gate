package newsfeed.domain.entity;

import com.joonhee.moneygate.newsfeed.domain.entity.Like;
import com.joonhee.moneygate.newsfeed.domain.entity.LikeStatus;

public class LikeBuilder {
    public static Like createWillBeDeletedDummyLike() {
        Like like = Like.createLike(
            1L,
            1L
        );
        return Like.builder()
            .id(1L)
            .userId(like.getUserId())
            .newsFeedId(like.getNewsFeedId())
            .status(LikeStatus.DELETED)
            .createdAt(like.getCreatedAt())
            .build();
    }
}
