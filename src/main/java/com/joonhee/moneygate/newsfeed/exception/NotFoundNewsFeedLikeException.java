package com.joonhee.moneygate.newsfeed.exception;

public class NotFoundNewsFeedLikeException extends IllegalArgumentException {
    public NotFoundNewsFeedLikeException(Long userId, Long newsFeedId) {
        super("Like is not found | userId: " + userId + ", newsFeedId: " + newsFeedId);
    }
}
