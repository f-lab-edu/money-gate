package com.joonhee.moneygate.newsfeed.service;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.domain.vo.NewsFeedId;
import com.joonhee.moneygate.newsfeed.usecase.QueryNewsFeedUseCase;

import java.util.List;

/**
 * TODO:뉴스피드 조회하는 비지니스 로직으로 페이지네이션이 추가 돼야합니다. Command 코드 리뷰를 받은 후 추가 작업예정입니다.
 */
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
