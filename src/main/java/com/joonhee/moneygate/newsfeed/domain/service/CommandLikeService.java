package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.newsfeed.domain.entity.Like;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.LikeRepository;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.exception.NotFoundNewsFeedLikeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    public Like addOrSubtract(Long userId, String newsFeedKey) {
        NewsFeed newsFeed = newsFeedRepository.findByKey(newsFeedKey);
        Like like = doOrUndoLikeNewsFeed(userId, newsFeed);
        like = newsFeed.doOrUndoLike(like);
        like = likeRepository.save(like);
        newsFeedRepository.save(newsFeed);
        return like;
    }

    private Like doOrUndoLikeNewsFeed(Long userId, NewsFeed newsFeed){
        try {
            return likeRepository.findByUserIdAndNewsFeedId(userId, newsFeed.getId());
        } catch (NotFoundNewsFeedLikeException e) {
            return  Like.createLike(userId, newsFeed.getId());
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
            throw e;
        }
    }
}
