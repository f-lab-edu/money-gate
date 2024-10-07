package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class QueryNewsFeedService {
    private final NewsFeedRepository newsFeedRepository;

    public QueryNewsFeedService(NewsFeedRepository newsFeedRepository) {
        this.newsFeedRepository = newsFeedRepository;
    }

    public List<NewsFeed> findAllNewsFeeds() {
        return newsFeedRepository.findAll();
    }

    public NewsFeed getNewsFeed(UUID key) {
        return newsFeedRepository.findByKey(key);
    }
}
