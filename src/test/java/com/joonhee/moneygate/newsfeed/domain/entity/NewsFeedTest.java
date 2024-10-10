package com.joonhee.moneygate.newsfeed.domain.entity;

import com.joonhee.moneygate.account.domain.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class NewsFeedTest {
    @Test
    @DisplayName("뉴스피드에 작성하기")
    void create() {
        // Arrange
        String nickName = "joonheeTest";
        String email = "joonhee@google.com";
        String profileImage = "https://avatars.githubusercontent.com/u/77449822?v=4";
        User mentor = User.createMentor(nickName, email, profileImage);
        // Action
        NewsFeed newsFeed = NewsFeed.createNewsFeedByPublic(mentor.getId(), "오늘은 무엇을 할까요?");
        // Assert
        assertThat(newsFeed).isNotNull();
    }

}