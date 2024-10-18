package com.joonhee.moneygate.newsfeed.application;

import com.joonhee.moneygate.newsfeed.domain.entity.Like;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CrudLikeRepository extends CrudRepository<Like, Long> {
    Optional<Like> findByUserIdAndNewsFeedId(Long userId, Long newsFeedId);
}