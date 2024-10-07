package com.joonhee.moneygate.newsfeed.application;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class NewsFeedRepositoryImpl implements NewsFeedRepository {
    private final CrudNewsFeedRepository crudNewsFeedRepository;

    public NewsFeedRepositoryImpl(CrudNewsFeedRepository crudNewsFeedRepository) {
        this.crudNewsFeedRepository = crudNewsFeedRepository;
    }

    @Override
    public NewsFeed save(NewsFeed newsFeed) {
        return crudNewsFeedRepository.save(newsFeed);
    }

    @Override
    public NewsFeed findByKey(UUID newsFeedKey) {
        return crudNewsFeedRepository.findByKey(newsFeedKey).orElse(null);
    }

    @Override
    public List<NewsFeed> findAll() {
        return StreamSupport.stream(crudNewsFeedRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
