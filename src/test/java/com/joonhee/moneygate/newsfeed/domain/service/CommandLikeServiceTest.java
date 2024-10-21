package com.joonhee.moneygate.newsfeed.domain.service;

import account.domain.entity.UserBuilder;
import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;
import com.joonhee.moneygate.account.repository.MemoryUserRepository;
import com.joonhee.moneygate.newsfeed.domain.entity.Like;
import com.joonhee.moneygate.newsfeed.domain.entity.LikeStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.LikeRepository;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.repository.MemoryLikeRepository;
import com.joonhee.moneygate.newsfeed.repository.MemoryNewsFeedRepository;
import newsfeed.domain.entity.NewsFeedBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CommandLikeServiceTest {

    private NewsFeedRepository newsFeedRepository;
    private UserRepository userRepository;
    private LikeRepository likeRepository;
    private CommandLikeService commandLikeService;

    @BeforeEach
    void setUp() {
        this.newsFeedRepository = new MemoryNewsFeedRepository();
        this.userRepository = new MemoryUserRepository();
        this.likeRepository = new MemoryLikeRepository();
        this.commandLikeService = new CommandLikeService(
            this.newsFeedRepository,
            this.likeRepository
        );
    }

    @Test
    @DisplayName("일반유저가 뉴스피드에 좋아요 누르기")
    void addLike() {
        // Arrange
        User mentor = UserBuilder.createDummyMentor();
        mentor = userRepository.save(mentor);

        User userIdWhoClickLike = UserBuilder.createDummyUser();
        userIdWhoClickLike = userRepository.save(userIdWhoClickLike);

        NewsFeed createdNewsFeed = NewsFeedBuilder.createDummyPublicNewsFeed(mentor.getId());
        createdNewsFeed = newsFeedRepository.save(createdNewsFeed);

        // Action
        Like didLike = this.commandLikeService.doLike(userIdWhoClickLike.getId(), createdNewsFeed.getKey());

        // Assert
        assertThat(didLike.getStatus()).isEqualTo(LikeStatus.ACTIVE);
    }

    @Test
    @DisplayName("일반유저가 뉴스피드에 좋아요 취소하기")
    void subtractLike() {
        // Arrange
        User mentor = UserBuilder.createDummyMentor();
        mentor = userRepository.save(mentor);

        NewsFeed createdNewsFeed = NewsFeedBuilder.createDummyPublicNewsFeed(mentor.getId());
        createdNewsFeed = newsFeedRepository.save(createdNewsFeed);

        User userIdWhoClickLike = UserBuilder.createDummyUser();
        userIdWhoClickLike = userRepository.save(userIdWhoClickLike);

        Like didLike = this.commandLikeService.doLike(userIdWhoClickLike.getId(), createdNewsFeed.getKey());
        createdNewsFeed = newsFeedRepository.save(createdNewsFeed);


        // Action
        Like revokeLike = this.commandLikeService.undoLike(userIdWhoClickLike.getId(), createdNewsFeed.getKey());

        // Assert
        assertThat(revokeLike.getStatus()).isEqualTo(LikeStatus.DELETED);
    }
}