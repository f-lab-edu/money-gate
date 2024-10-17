package com.joonhee.moneygate.newsfeed.repository;

import com.joonhee.moneygate.newsfeed.domain.entity.Like;
import com.joonhee.moneygate.newsfeed.domain.entity.LikeStatus;
import com.joonhee.moneygate.newsfeed.domain.repository.LikeRepository;
import com.joonhee.moneygate.newsfeed.exception.NotFoundNewsFeedLikeException;

import java.util.HashMap;

public class MemoryLikeRepository implements LikeRepository {
    private final HashMap<Long, Like> likes = new HashMap<>();
    private Long id = 0L;
    @Override
    public Like save(Like like) {
        Like likeWithId = Like.builder()
            .id(generateId())
            .userId(like.getUserId())
            .newsFeedId(like.getNewsFeedId())
            .status(like.getStatus())
            .createdAt(like.getCreatedAt())
            .deletedAt(like.getDeletedAt())
            .build();
        likes.put(likeWithId.getId(), likeWithId);
        return likeWithId;
    }

    @Override
    public Like findByUserIdAndNewsFeedId(Long userId, Long newsFeedId) {
        return likes.values().stream()
            .filter(like -> like.getUserId().equals(userId) && like.getNewsFeedId().equals(newsFeedId) && like.getStatus().equals(LikeStatus.ACTIVE))
            .findFirst()
            .orElseThrow(() -> new NotFoundNewsFeedLikeException(userId, newsFeedId));
    }

    private Long generateId() {
        return id++;
    }
}
