package com.joonhee.moneygate.newsfeed.application;

import com.joonhee.moneygate.newsfeed.domain.entity.ContentStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.exception.NotFoundNewsFeedException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

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
        return crudNewsFeedRepository.findByKey(newsFeedKey).orElseThrow(() -> new NotFoundNewsFeedException(newsFeedKey.toString()));
    }

    @Override
    public List<NewsFeed> findAllPublic() {
        return crudNewsFeedRepository.findAllByStatusOrderByCreatedAtDesc(ContentStatus.PUBLIC.name());
    }

    @Override
    public List<NewsFeed> findAll() {
        Sort sort = Sort.by(Sort.Order.desc("createdAt"));
        return crudNewsFeedRepository.findAll(sort);
    }
}
