package com.joonhee.moneygate.newsfeed.domain.service;

import account.domain.repository.MentorRepositoryHelper;
import account.domain.repository.UserRepositoryHelper;
import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;
import com.joonhee.moneygate.account.exception.InvalidUserPermission;
import com.joonhee.moneygate.account.repository.MemoryUserRepository;
import com.joonhee.moneygate.newsfeed.domain.entity.ContentOpenStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.LikeRepository;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.repository.MemoryLikeRepository;
import com.joonhee.moneygate.newsfeed.repository.MemoryNewsFeedRepository;
import com.joonhee.moneygate.validator.MentorValidator;
import newsfeed.domain.repository.NewsFeedRepositoryHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandNewsFeedServiceTest {
    private CommandNewsFeedService commandNewsFeedService;
    private UserRepository mentorRepository;
    private NewsFeedRepository newsFeedRepository;
    private LikeRepository likeRepository;
    private MentorValidator mentorValidator;
    private NewsFeedRepositoryHelper newsFeedRepositoryHelper;
    private MentorRepositoryHelper mentorRepositoryHelper;
    private UserRepositoryHelper userRepositoryHelper;

    @BeforeEach
    void setUp() {
        this.mentorRepository = new MemoryUserRepository();
        this.newsFeedRepository = new MemoryNewsFeedRepository();
        this.likeRepository = new MemoryLikeRepository();
        this.mentorValidator = new MentorValidator(mentorRepository);

        this.commandNewsFeedService = new CommandNewsFeedService(
            this.mentorRepository,
            this.newsFeedRepository,
            this.likeRepository,
            this.mentorValidator
        );

        this.newsFeedRepositoryHelper = new NewsFeedRepositoryHelper(
            newsFeedRepository,
            mentorRepository
        );

        this.mentorRepositoryHelper = new MentorRepositoryHelper(
            mentorRepository
        );

        this.userRepositoryHelper = new UserRepositoryHelper(
            mentorRepository
        );
    }

    @Test
    @DisplayName("뉴스피드 생성하기(Public)")
    void create() {
        // Arrange, Action
        NewsFeed createdNewsFeed = newsFeedRepositoryHelper.createDummyPublicNewsFeed();

        // Assert
        assertThat(createdNewsFeed.getId()).isEqualTo(createdNewsFeed.getId());
        assertThat(createdNewsFeed.getBody()).isEqualTo(createdNewsFeed.getBody());
    }

    @Test
    @DisplayName("뉴스피드 생성하기(Draft)")
    void test() {
        // Arrange, Action
        NewsFeed createdDraftNewsFeed = newsFeedRepositoryHelper.createDummyDraftNewsFeed();
        // Assert
        assertThat(createdDraftNewsFeed.getId()).isEqualTo(createdDraftNewsFeed.getId());
        assertThat(createdDraftNewsFeed.getBody()).isEqualTo(createdDraftNewsFeed.getBody());
        assertThat(createdDraftNewsFeed.getStatus()).isEqualTo(ContentOpenStatus.DRAFT);
    }

    @Test
    @DisplayName("뉴스피드 수정하기")
    void update() {
        // Arrange
        NewsFeed createdNewsFeed = newsFeedRepositoryHelper.createDummyPublicNewsFeed();
        String changedBody = "내용을 변경합니다";

        // Action
        this.commandNewsFeedService.updateNewsFeed(createdNewsFeed.getKey(), changedBody);
        // Assert
        NewsFeed updatedNewsFeed = newsFeedRepository.findByKey(createdNewsFeed.getKey());
        assertThat(updatedNewsFeed.getBody()).isEqualTo(changedBody);
    }

    @Test
    @DisplayName("뉴스피드 삭제하기")
    void delete() {
        // Arrange
        NewsFeed createdNewsFeed = newsFeedRepositoryHelper.createDummyPublicNewsFeed();
        // Action
        NewsFeed deletedNewsFeed = this.commandNewsFeedService.deleteNewsFeed(createdNewsFeed.getKey());
        // Assert
        assertThat(deletedNewsFeed.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("권한없는 멘토가 뉴스피드 생성시 예외처리")
    void unauthorizedUserCreateNewsFeedException() {
        // Arrange
        User user = userRepositoryHelper.createDummyUser();
        // Action, Assert
        assertThatThrownBy(() -> this.commandNewsFeedService.createNewsFeedByPublic(user.getId(), null))
            .isInstanceOf(InvalidUserPermission.class);
    }
}