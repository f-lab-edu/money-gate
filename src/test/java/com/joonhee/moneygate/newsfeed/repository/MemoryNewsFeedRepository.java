package com.joonhee.moneygate.newsfeed.repository;

import com.joonhee.moneygate.newsfeed.domain.entity.ContentStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.exception.NotFoundNewsFeedException;

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
    public NewsFeed findByKey(UUID newsFeedKey) {
        NewsFeed newsFeed = newsFeeds.get(newsFeedKey);
        if (newsFeed == null) {
            throw new NotFoundNewsFeedException(newsFeedKey.toString());
        }
        return newsFeed;
    }

    @Override
    public List<NewsFeed> findAllPublic() {

        return newsFeeds.values().stream()
            .filter(newsFeed -> newsFeed.getStatus().equals(ContentStatus.PUBLIC))
            .toList();
    }

    @Override
    public List<NewsFeed> findAll() {
        return List.copyOf(newsFeeds.values());
    }
}
