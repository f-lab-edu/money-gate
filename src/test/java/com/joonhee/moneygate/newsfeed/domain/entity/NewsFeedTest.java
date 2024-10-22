package com.joonhee.moneygate.newsfeed.domain.entity;

import account.domain.entity.UserBuilder;
import com.joonhee.moneygate.account.domain.entity.User;
import newsfeed.domain.entity.LikeBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class NewsFeedTest {
    @Test
    @DisplayName("뉴스피드에 작성하기")
    void create() {
        // Arrange
        User mentor = UserBuilder.createDummyMentor();
        // Action
        NewsFeed newsFeed = NewsFeed.createNewsFeedByPublic(mentor.getId(), "오늘은 무엇을 할까요?");
        // Assert
        assertThat(newsFeed).isNotNull();
    }

    @Test
    @DisplayName("일반 유저가 뉴스피드에 좋아요 누르기")
    void addLike() {
        // Arrange
        Long mentorId = 1L;
        NewsFeed newsFeed = NewsFeed.createNewsFeedByPublic(mentorId, "오늘은 무엇을 할까요?");
        Like like = LikeBuilder.createWillBeDeletedDummyLike();
        // Action
        Like didLike = newsFeed.doOrUndoLike(like);

        // Assert
        assertThat(didLike.getStatus()).isEqualTo(LikeStatus.ACTIVE);
    }

    @Test
    @DisplayName("일반 유저가 뉴스피드에 좋아요 취소하기")
    void subtractLike() {
        // Arrange
        Long mentorId = 1L;
        NewsFeed newsFeed = NewsFeed.createNewsFeedByPublic(mentorId, "오늘은 무엇을 할까요?");
        Like like = LikeBuilder.createWillBeDeletedDummyLike();
        newsFeed.doOrUndoLike(like);
        // Action
        Like revokeLike = newsFeed.doOrUndoLike(like);

        // Assert
        assertThat(revokeLike.getStatus()).isEqualTo(LikeStatus.DELETED);
    }
}