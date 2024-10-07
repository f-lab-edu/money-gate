package com.joonhee.moneygate.newsfeed.application;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CrudNewsFeedRepository extends CrudRepository<NewsFeed, Long> {
    Optional<NewsFeed> findByKey(UUID key);
    List<NewsFeed> findAllByStatusOrderByCreatedAtDesc(String status);
    List<NewsFeed> findAll(Sort sort);

}
