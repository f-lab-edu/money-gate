package com.joonhee.moneygate.newsfeed.domain.repository;

import com.joonhee.moneygate.newsfeed.domain.entity.Like;

public interface LikeRepository{
    Like save(Like like);
    Like findByUserIdAndNewsFeedId(Long userId, Long newsFeedId);
}
