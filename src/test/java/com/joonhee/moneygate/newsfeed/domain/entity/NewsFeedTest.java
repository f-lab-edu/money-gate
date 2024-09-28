package com.joonhee.moneygate.newsfeed.domain.entity;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class NewsFeedTest {
    @Test
    void 뉴스피드에_작성하기() {
        // Arrange
        Mentor mentor = new Mentor("이준희", "joonhee@google.com", "https://avatars.githubusercontent.com/u/77449822?v=4");
        // Action
        NewsFeed newsFeed = new NewsFeed(mentor, "오늘은 무엇을 할까요?");
        // Assert
        assertThat(newsFeed).isNotNull();
    }

}