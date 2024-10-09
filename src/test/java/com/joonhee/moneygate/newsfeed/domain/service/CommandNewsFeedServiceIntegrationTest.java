package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.service.CreateMentorService;
import com.joonhee.moneygate.newsfeed.domain.entity.ContentStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class CommandNewsFeedServiceIntegrationTest {
    @Autowired
    private CommandNewsFeedService commandNewsFeedService;
    @Autowired
    private QueryNewsFeedService queryNewsFeedService;
    @Autowired
    private CreateMentorService createMentorService;

    @Test
    @DisplayName("멘토가 뉴스피드(Public) 생성")
    void createNewsFeed() {
        // Arrange
        User mentor = createMentor();
        // Action
        NewsFeed newsFeed = commandNewsFeedService.createNewsFeedByPublic(mentor.getId(), "뉴스피드 내용");
        // Assert
        NewsFeed createdNewsFeed = queryNewsFeedService.getNewsFeed(newsFeed.getKey());
        assertThat(newsFeed.getId()).isEqualTo(createdNewsFeed.getId());
    }

    private User createMentor() {
        String nickName = "joonheeTest";
        String email = "joonheeTest@abc.com";
        String profileImage = "https://joonhee.com";
        return createMentorService.createMentor(nickName, email, profileImage);
    }

    @Test
    @DisplayName("멘토가 뉴스피드(Draft) 생성")
    void test() {
        // Arrange,
        User mentor = createMentor();
        // Action
        NewsFeed draftNewsFeed = commandNewsFeedService.createNewsFeedByDraft(mentor.getId(), "뉴스피드 내용");
        // Assert
        NewsFeed createdDraftNewsFeed = queryNewsFeedService.getNewsFeed(draftNewsFeed.getKey());
        assertThat(createdDraftNewsFeed.getId()).isEqualTo(draftNewsFeed.getId());
        assertThat(createdDraftNewsFeed.getStatus()).isEqualTo(ContentStatus.DRAFT);
    }

    @Test
    @DisplayName("뉴스피드 내용 수정")
    void updateNewsFeed(){
        // Arrange
        User mentor = createMentor();
        NewsFeed newsFeed = commandNewsFeedService.createNewsFeedByPublic(mentor.getId(), "뉴스피드 내용");
        String updatedNewsfeedText = "수정된 뉴스피드 내용";
        // Action
        NewsFeed updatedNewsFeed = commandNewsFeedService.updateNewsFeed(newsFeed.getKey(), updatedNewsfeedText);
        // Assert
        assertThat(updatedNewsFeed.getBody()).isEqualTo(updatedNewsfeedText);
    }

    @Test
    @DisplayName("뉴스피드 삭제")
    void deleteNewsFeed(){
        // Arrange
        User mentor = createMentor();
        NewsFeed newsFeed = commandNewsFeedService.createNewsFeedByPublic(mentor.getId(), "뉴스피드 내용");
        // Action
        NewsFeed deletedNewsFeed = commandNewsFeedService.deleteNewsFeed(newsFeed.getKey());
        // Assert
        assertThat(deletedNewsFeed.isDeleted()).isTrue();
    }

}
