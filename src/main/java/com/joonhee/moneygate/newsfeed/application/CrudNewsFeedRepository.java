package com.joonhee.moneygate.newsfeed.application;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CrudNewsFeedRepository extends CrudRepository<NewsFeed, Long> {
    Optional<NewsFeed> findByKey(UUID key);
}
