package com.joonhee.moneygate.newsfeed.usecase;

import com.joonhee.moneygate.mentor.domain.vo.MentorId;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.vo.NewsFeedId;

public interface CommandNewsFeedUseCase {
    NewsFeed createNewsFeed(MentorId id, String body);
    NewsFeed deleteNewsFeed(NewsFeedId id);
    NewsFeed updateNewsFeed(NewsFeedId id, String body);

}
