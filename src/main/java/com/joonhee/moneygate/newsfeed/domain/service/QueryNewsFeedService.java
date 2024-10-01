package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;

import java.util.List;
import java.util.UUID;

/**
 * TODO:뉴스피드 조회하는 비지니스 로직으로 페이지네이션이 추가 돼야합니다. Command 코드 리뷰를 받은 후 추가 작업예정입니다.
 */
public class QueryNewsFeedService {
    private final NewsFeedRepository newsFeedRepository;

    public QueryNewsFeedService(NewsFeedRepository newsFeedRepository) {
        this.newsFeedRepository = newsFeedRepository;
    }

    public List<NewsFeed> getAllNewsFeeds() {
        return newsFeedRepository.findAll();
    }

    public NewsFeed getNewsFeed(UUID id) {
        return newsFeedRepository.findById(id);
    }
}
