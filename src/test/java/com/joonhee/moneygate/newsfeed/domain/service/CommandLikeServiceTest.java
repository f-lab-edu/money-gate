package com.joonhee.moneygate.newsfeed.domain.service;

import account.domain.entity.UserStub;
import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;
import com.joonhee.moneygate.account.repository.MemoryUserRepository;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.LikeRepository;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.repository.MemoryLikeRepository;
import com.joonhee.moneygate.newsfeed.repository.MemoryNewsFeedRepository;
import newsfeed.domain.entity.NewsFeedStub;
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
        User mentor = UserStub.createDummyMentor();
        mentor = userRepository.save(mentor);

        User userIdWhoClickLike = UserStub.createDummyUser();
        userIdWhoClickLike = userRepository.save(userIdWhoClickLike);

        NewsFeed createdNewsFeed = NewsFeedStub.createDummyPublicNewsFeed(mentor.getId());
        createdNewsFeed = newsFeedRepository.save(createdNewsFeed);

        // Action
        NewsFeed likedNewsFeed = this.commandLikeService.addOrSubtract(userIdWhoClickLike.getId(), createdNewsFeed.getKey());

        // Assert
        assertThat(likedNewsFeed.getLikes().getUserIds().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("일반유저가 뉴스피드에 좋아요 취소하기")
    void subtractLike() {
        // Arrange
        User mentor = UserStub.createDummyMentor();
        mentor = userRepository.save(mentor);

        NewsFeed createdNewsFeed = NewsFeedStub.createDummyPublicNewsFeed(mentor.getId());
        createdNewsFeed = newsFeedRepository.save(createdNewsFeed);

        User userIdWhoClickLike = UserStub.createDummyUser();
        userIdWhoClickLike = userRepository.save(userIdWhoClickLike);

        NewsFeed likedNewsFeed = this.commandLikeService.addOrSubtract(userIdWhoClickLike.getId(), createdNewsFeed.getKey());
        likedNewsFeed = newsFeedRepository.save(likedNewsFeed);


        // Action
        NewsFeed unlikedNewsFeed = this.commandLikeService.addOrSubtract(userIdWhoClickLike.getId(), createdNewsFeed.getKey());

        // Assert
        assertThat(unlikedNewsFeed.getLikes().getUserIds().size()).isEqualTo(0);
    }

    @Test
    @DisplayName("이미 좋아요를 누른 뉴스피드에 좋아요 누르는 경우 무시하기")
    void addLikeToAlreadyLikedNewsFeed() {
        // Arrange
        User mentor = UserStub.createDummyMentor();
        mentor = userRepository.save(mentor);

        NewsFeed createdNewsFeed = NewsFeedStub.createDummyPublicNewsFeed(mentor.getId());
        createdNewsFeed = newsFeedRepository.save(createdNewsFeed);

        User userIdWhoClickLike = UserStub.createDummyUser();
        userIdWhoClickLike = userRepository.save(userIdWhoClickLike);

        NewsFeed likedNewsFeed = this.commandLikeService.addOrSubtract(userIdWhoClickLike.getId(), createdNewsFeed.getKey());
        createdNewsFeed = newsFeedRepository.save(likedNewsFeed);


        // Action
        NewsFeed likedNewsFeedAgain = this.commandLikeService.addOrSubtract(userIdWhoClickLike.getId(), createdNewsFeed.getKey());

        // Assert
        assertThat(likedNewsFeedAgain.getLikes().getUserIds().size()).isEqualTo(0);
    }
}