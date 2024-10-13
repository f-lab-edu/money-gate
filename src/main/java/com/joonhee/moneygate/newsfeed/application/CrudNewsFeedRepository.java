package com.joonhee.moneygate.newsfeed.application;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudNewsFeedRepository extends CrudRepository<NewsFeed, Long> {
    Optional<NewsFeed> findByKey(String key);
    @Query("SELECT * FROM news_feed WHERE status = :status ORDER BY news_feed_id DESC LIMIT :size")
    List<NewsFeed> findAllByStatusOrderIdDesc(String status, int size);
    @Query("SELECT * FROM news_feed WHERE status = :status AND news_feed_id < :id ORDER BY news_feed_id DESC LIMIT :size")
    List<NewsFeed> findAllByStatusOrderIdDesc(String status, Long id, int size);
    List<NewsFeed> findAll(Sort sort);
}
