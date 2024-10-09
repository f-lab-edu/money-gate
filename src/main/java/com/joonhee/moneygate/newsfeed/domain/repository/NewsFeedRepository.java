package com.joonhee.moneygate.newsfeed.domain.repository;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;

import java.util.List;
import java.util.UUID;

public interface NewsFeedRepository {
    NewsFeed save(NewsFeed newsFeed);

    NewsFeed findByKey(UUID newsFeedKey) throws IllegalArgumentException;

    List<NewsFeed> findAllPublic();

    List<NewsFeed> findAll();
}
