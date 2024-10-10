package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.MentorRepository;
import com.joonhee.moneygate.account.repository.MemoryMentorRepository;
import com.joonhee.moneygate.newsfeed.domain.entity.ContentOpenStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.dto.NewsFeedDetail;
import com.joonhee.moneygate.newsfeed.repository.MemoryNewsFeedRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QueryNewsFeedServiceTest {
    private QueryNewsFeedService queryNewsFeedService;
    private NewsFeedRepository newsFeedRepository;
    private MentorRepository mentorRepository;

    @BeforeEach
    void setUp() {
        this.newsFeedRepository = new MemoryNewsFeedRepository();
        this.mentorRepository = new MemoryMentorRepository();
        this.queryNewsFeedService = new QueryNewsFeedService(newsFeedRepository, mentorRepository);
    }

    @Test
    @DisplayName("모든 뉴스피드 조회하기")
    void findAll() {
        // Arrange
        createDummyNewsFeed();
        // Action
        List<NewsFeedDetail> newsFeeds = queryNewsFeedService.findAllPublic();
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
        String nickName = "joonheeTest";
        String email = "joonhee@google.com";
        String profileImage = "https://joonhee.com";
        User mentor = User.createMentor(nickName, email, profileImage);
        mentorRepository.save(mentor);
        NewsFeed newsFeed = new NewsFeed(mentor.getId(), "오늘은 무엇을 할까요?", ContentOpenStatus.PUBLIC);

        return newsFeedRepository.save(newsFeed);
    }
}