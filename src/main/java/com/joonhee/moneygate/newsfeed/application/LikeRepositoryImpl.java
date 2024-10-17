package com.joonhee.moneygate.newsfeed.application;

import com.joonhee.moneygate.newsfeed.domain.entity.Like;
import com.joonhee.moneygate.newsfeed.domain.repository.LikeRepository;
import com.joonhee.moneygate.newsfeed.exception.NotFoundNewsFeedLikeException;
import org.springframework.stereotype.Repository;

@Repository
public class LikeRepositoryImpl implements LikeRepository {
    private final CrudLikeRepository crudLikeRepository;

    public LikeRepositoryImpl(CrudLikeRepository crudLikeRepository) {
        this.crudLikeRepository = crudLikeRepository;
    }

    @Override
    public Like save(Like like) {
        return crudLikeRepository.save(like);
    }

    @Override
    public Like findByUserIdAndNewsFeedId(Long userId, Long newsFeedId) {
        return crudLikeRepository.findByUserIdAndNewsFeedId(userId, newsFeedId).orElseThrow(
            () -> new NotFoundNewsFeedLikeException(userId, newsFeedId)
        );
    }
}
