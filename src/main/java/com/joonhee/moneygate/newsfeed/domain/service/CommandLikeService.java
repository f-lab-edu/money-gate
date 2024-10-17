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

    public NewsFeed addOrSubtract(Long userId, String newsFeedKey) {
        NewsFeed newsFeed = newsFeedRepository.findByKey(newsFeedKey);
        Like like = doOrUndoLike(userId, newsFeed.getId());
        like = likeRepository.save(like);
        newsFeed.addOrSubtractLike(like);
        return newsFeedRepository.save(newsFeed);
    }

    private Like doOrUndoLike(Long userId, Long newsFeedId){
        try {
            Like like = likeRepository.findByUserIdAndNewsFeedId(userId, newsFeedId);
            return like.doOrUndo();
        } catch (NotFoundNewsFeedLikeException e) {
            return  Like.createLike(userId, newsFeedId);
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
            throw e;
        }
    }
}
