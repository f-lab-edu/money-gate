package com.joonhee.moneygate.newsfeed.domain.repository;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;

import java.util.List;
import java.util.UUID;

public interface NewsFeedRepository {
    NewsFeed save(NewsFeed newsFeed);

    NewsFeed findById(UUID id);

    NewsFeed update(UUID newsFeedId, String body);

    NewsFeed delete(UUID id);

    List<NewsFeed> findAll();
}
