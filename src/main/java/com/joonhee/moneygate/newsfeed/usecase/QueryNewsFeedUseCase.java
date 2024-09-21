package com.joonhee.moneygate.newsfeed.usecase;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.vo.NewsFeedId;

import java.util.List;

public interface QueryNewsFeedUseCase {
    List<NewsFeed> getNewsFeeds();
    NewsFeed getNewsFeed(NewsFeedId id);
}
