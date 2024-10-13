package com.joonhee.moneygate.newsfeed.domain.service;

import account.domain.repository.MentorRepositoryHelper;
import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;
import com.joonhee.moneygate.newsfeed.domain.entity.ContentOpenStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import org.junit.jupiter.api.BeforeEach;
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
    private NewsFeedRepository newsFeedRepository;
    @Autowired
    private UserRepository mentorRepository;

    private MentorRepositoryHelper mentorRepositoryHelper;

    @BeforeEach
    void setUp() {
        this.mentorRepositoryHelper = new MentorRepositoryHelper(
            mentorRepository
        );
    }

    @Test
    @DisplayName("멘토가 뉴스피드(Public) 생성")
    void createNewsFeed() {
        // Arrange
        User mentor = mentorRepositoryHelper.createDummyMentor();
        // Action
        NewsFeed newsFeed = commandNewsFeedService.createNewsFeedByPublic(mentor.getId(), "뉴스피드 내용");
        // Assert
        NewsFeed createdNewsFeed = newsFeedRepository.findByKey(newsFeed.getKey());
        assertThat(newsFeed.getId()).isEqualTo(createdNewsFeed.getId());
    }

    @Test
    @DisplayName("멘토가 뉴스피드(Draft) 생성")
    void test() {
        // Arrange,
        User mentor = mentorRepositoryHelper.createDummyMentor();
        // Action
        NewsFeed draftNewsFeed = commandNewsFeedService.createNewsFeedByDraft(mentor.getId(), "뉴스피드 내용");
        // Assert
        NewsFeed createdDraftNewsFeed = newsFeedRepository.findByKey(draftNewsFeed.getKey());
        assertThat(createdDraftNewsFeed.getId()).isEqualTo(draftNewsFeed.getId());
        assertThat(createdDraftNewsFeed.getStatus()).isEqualTo(ContentOpenStatus.DRAFT);
    }

    @Test
    @DisplayName("뉴스피드 내용 수정")
    void updateNewsFeed() {
        // Arrange
        User mentor = mentorRepositoryHelper.createDummyMentor();
        NewsFeed newsFeed = commandNewsFeedService.createNewsFeedByPublic(mentor.getId(), "뉴스피드 내용");
        String updatedNewsfeedText = "수정된 뉴스피드 내용";
        // Action
        NewsFeed updatedNewsFeed = commandNewsFeedService.updateNewsFeed(newsFeed.getKey(), updatedNewsfeedText);
        // Assert
        assertThat(updatedNewsFeed.getBody()).isEqualTo(updatedNewsfeedText);
    }

    @Test
    @DisplayName("뉴스피드 삭제")
    void deleteNewsFeed() {
        // Arrange
        User mentor = mentorRepositoryHelper.createDummyMentor();
        NewsFeed newsFeed = commandNewsFeedService.createNewsFeedByPublic(mentor.getId(), "뉴스피드 내용");
        // Action
        NewsFeed deletedNewsFeed = commandNewsFeedService.deleteNewsFeed(newsFeed.getKey());
        // Assert
        assertThat(deletedNewsFeed.isDeleted()).isTrue();
    }

}
