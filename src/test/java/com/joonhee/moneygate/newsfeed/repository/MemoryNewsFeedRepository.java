package com.joonhee.moneygate.newsfeed.repository;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.domain.vo.NewsFeedId;

import java.util.HashMap;

public class MemoryNewsFeedRepository implements NewsFeedRepository {
    HashMap<NewsFeedId, NewsFeed> newsFeeds = new HashMap<>();

    @Override
    public NewsFeed save(NewsFeed newsFeed) {
        newsFeeds.put(newsFeed.getId(), newsFeed);
        return newsFeed;
    }

    @Override
    public NewsFeed findById(NewsFeedId id) {
        return newsFeeds.get(id);
    }

    @Override
    public NewsFeed update(NewsFeedId newsFeedId, String body) {
        NewsFeed newsFeed = newsFeeds.get(newsFeedId);
        return newsFeed.updateBody(body);
    }

    @Override
    public NewsFeed delete(NewsFeedId id) {
        NewsFeed newsFeed = newsFeeds.get(id);
        return newsFeed.delete();
    }
}
