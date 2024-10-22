package com.joonhee.moneygate.validator;

import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.exception.NotFoundNewsFeedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NewsFeedValidator {
    private final NewsFeedRepository newsFeedRepository;
    public NewsFeedValidator(NewsFeedRepository newsFeedRepository) {
        this.newsFeedRepository = newsFeedRepository;
    }

    public void validateNewsFeed(String newsFeedKey) {
        try{
            newsFeedRepository.findByKey(newsFeedKey);
        }catch (NotFoundNewsFeedException e) {
            throw e;
        }
    }
}
