package com.joonhee.moneygate.newsfeed.domain.repository;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.vo.NewsFeedId;

public interface NewsFeedRepository {
    NewsFeed save(NewsFeed newsFeed);
    NewsFeed findById(NewsFeedId id);
    NewsFeed update(NewsFeedId newsFeedId, String body);
    NewsFeed delete(NewsFeedId id);
}
