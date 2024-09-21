package com.joonhee.moneygate.newsfeed.service;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.domain.vo.NewsFeedId;
import com.joonhee.moneygate.newsfeed.usecase.QueryNewsFeedUseCase;

import java.util.List;

public class QueryNewsFeedProcessor implements QueryNewsFeedUseCase {
    private final NewsFeedRepository newsFeedRepository;
    public QueryNewsFeedProcessor(NewsFeedRepository newsFeedRepository) {
        this.newsFeedRepository = newsFeedRepository;
    }

    @Override
    public List<NewsFeed> getNewsFeeds() {
        return null;
    }

    @Override
    public NewsFeed getNewsFeed(NewsFeedId id) {
        return null;
    }
}
