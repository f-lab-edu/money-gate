package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.account.domain.entity.Mentor;
import com.joonhee.moneygate.account.domain.service.CreateMentorService;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class QueryNewsFeedServiceIntegrationTest {
    @Autowired
    private CreateMentorService createMentorService;
    @Autowired
    private CommandNewsFeedService commandNewsFeedService;
    @Autowired
    private QueryNewsFeedService queryNewsFeedService;

    @Test
    @DisplayName("모든 뉴스피드 조회")
    void findAll() {
        // Arrange
        Mentor mentor = createDummyMentor();
        commandNewsFeedService.createNewsFeedByPublic(mentor.getId(), "오늘은 무엇을 할까요?");
        commandNewsFeedService.createNewsFeedByPublic(mentor.getId(), "내일은 무엇을 할까요?");
        // Action
        List<NewsFeed> newsFeeds = queryNewsFeedService.findAllNewsFeeds();
        // Assert
        assertThat(newsFeeds.size()).isEqualTo(2);
    }

    private Mentor createDummyMentor() {
        return createMentorService.createMentor("이준희",
            "joobhee@google.com",
            "https://avatars.githubusercontent.com/u/77449822?v=4");
    }

}
