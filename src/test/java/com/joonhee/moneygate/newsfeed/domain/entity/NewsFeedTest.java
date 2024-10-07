package com.joonhee.moneygate.newsfeed.domain.entity;

import com.joonhee.moneygate.account.domain.entity.Mentor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class NewsFeedTest {
    @Test
    @DisplayName("뉴스피드에 작성하기")
    void create() {
        // Arrange
        Mentor mentor = new Mentor("이준희", "joonhee@google.com", "https://avatars.githubusercontent.com/u/77449822?v=4");
        // Action
        NewsFeed newsFeed = new NewsFeed(mentor.getId(), "오늘은 무엇을 할까요?", ContentStatus.PUBLIC);
        // Assert
        assertThat(newsFeed).isNotNull();
    }

}