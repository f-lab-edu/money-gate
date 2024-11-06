package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.newsfeed.domain.entity.Like;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.LikeRepository;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Slf4j
@Service
public class CommandLikeService {
    private final NewsFeedRepository newsFeedRepository;
    private final LikeRepository likeRepository;

    public CommandLikeService(
        NewsFeedRepository newsFeedRepository,
        LikeRepository likeRepository
    ) {
        this.newsFeedRepository = newsFeedRepository;
        this.likeRepository = likeRepository;
    }

    public Like doLike(Long userId, String newsFeedKey) {
        NewsFeed newsFeed = newsFeedRepository.findByKey(newsFeedKey);
        Like like = getLike(userId, newsFeed);
        like = newsFeed.doLike(like);
        like = likeRepository.save(like);
        newsFeedRepository.save(newsFeed);
        return like;
    }

    public Like undoLike(Long userId, String newsFeedKey) {
        NewsFeed newsFeed = newsFeedRepository.findByKey(newsFeedKey);
        Like like = getLike(userId, newsFeed);
        like = newsFeed.undoLike(like);
        like = likeRepository.save(like);
        newsFeedRepository.save(newsFeed);
        return like;
    }

    private Like getLike(Long userId, NewsFeed newsFeed) {
        try {
            return likeRepository.findByUserIdAndNewsFeedId(userId, newsFeed.getId());
        } catch (NoSuchElementException e) {
            return Like.createLike(userId, newsFeed.getId());
        }
    }
}
