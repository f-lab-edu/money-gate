package com.joonhee.moneygate.newsfeed.domain.repository;

import com.joonhee.moneygate.common.SliceContent;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;

import java.util.List;

public interface NewsFeedRepository {
    NewsFeed save(NewsFeed newsFeed);

    NewsFeed findByKey(String newsFeedKey) throws IllegalArgumentException;

    SliceContent<NewsFeed> findAllPublicSlice(int size, String nextCursor);

    List<NewsFeed> findAll();
}
