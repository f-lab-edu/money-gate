package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;
import com.joonhee.moneygate.newsfeed.domain.entity.ContentStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.repository.MemoryNewsFeedRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QueryNewsFeedServiceTest {
    QueryNewsFeedService queryNewsFeedService;
    NewsFeedRepository newsFeedRepository;

    @BeforeEach
    void setUp() {
        this.newsFeedRepository = new MemoryNewsFeedRepository();
        this.queryNewsFeedService = new QueryNewsFeedService(newsFeedRepository);
    }

    @Test
    @DisplayName("모든 뉴스피드 조회하기")
    void findAll() {
        // Arrange
        createDummyNewsFeed();
        // Action
        List<NewsFeed> newsFeeds = queryNewsFeedService.getAllNewsFeeds();
        // Assert
        assertThat(newsFeeds.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("특정 뉴스피드 조회하기")
    void getSpecificItem() {
        // Arrange
        NewsFeed createdNewsFeed = createDummyNewsFeed();
        // Action
        NewsFeed newsFeed = queryNewsFeedService.getNewsFeed(createdNewsFeed.getKey());
        // Assert
        assertThat(newsFeed.getKey()).isEqualTo(createdNewsFeed.getKey());
    }

    NewsFeed createDummyNewsFeed() {
        Mentor mentor = new Mentor("이준희", "joonhee@google.com", "https://avatars.githubusercontent.com/u/77449822?v=4");
        NewsFeed newsFeed = new NewsFeed(mentor, "오늘은 무엇을 할까요?", ContentStatus.ACTIVE);

        return newsFeedRepository.save(newsFeed);
    }
}