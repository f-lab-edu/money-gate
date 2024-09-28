package com.joonhee.moneygate.newsfeed.repository;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MemoryNewsFeedRepository implements NewsFeedRepository {
    private final HashMap<UUID, NewsFeed> newsFeeds = new HashMap<>();

    @Override
    public NewsFeed save(NewsFeed newsFeed) {
        newsFeeds.put(newsFeed.getKey(), newsFeed);
        return newsFeed;
    }

    @Override
    public NewsFeed findById(UUID id) {
        return newsFeeds.get(id);
    }

    @Override
    public NewsFeed update(UUID newsFeedId, String body) {
        NewsFeed newsFeed = newsFeeds.get(newsFeedId);
        return newsFeed.updateBody(body);
    }

    @Override
    public NewsFeed delete(UUID id) {
        NewsFeed newsFeed = newsFeeds.get(id);
        return newsFeed.delete();
    }

    @Override
    public List<NewsFeed> findAll() {
        return List.copyOf(newsFeeds.values());
    }
}
