package com.joonhee.moneygate.newsfeed.application;

import com.joonhee.moneygate.newsfeed.domain.entity.Like;
import com.joonhee.moneygate.newsfeed.domain.repository.LikeRepository;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

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
            () -> new NoSuchElementException(
                "유저 userId: " + userId + "가 소유한" + "newsFeedId: " + newsFeedId + "가 존재하지 않습니다.")
        );
    }
}
