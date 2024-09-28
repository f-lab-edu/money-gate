package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;
import com.joonhee.moneygate.mentor.domain.repository.MentorRepository;
import com.joonhee.moneygate.mentor.repository.MemoryMentorRepository;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.repository.MemoryNewsFeedRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CommandNewsFeedServiceTest {
    CommandNewsFeedService commandNewsFeedUseCase;
    MentorRepository mentorRepository;
    NewsFeedRepository newsFeedRepository;

    @BeforeEach
    void setUp() {
        this.mentorRepository = new MemoryMentorRepository();
        this.newsFeedRepository = new MemoryNewsFeedRepository();

        this.commandNewsFeedUseCase = new CommandNewsFeedService(
            this.mentorRepository,
            this.newsFeedRepository
        );
    }

    @Test
    void 뉴스피드_생성하기() {
        // Arrange, Action
        NewsFeed createdNewsFeed = createDummyNewsFeed();

        // Assert
        assertThat(createdNewsFeed.getMentorId()).isEqualTo(createdNewsFeed.getMentorId());
        assertThat(createdNewsFeed.getBody()).isEqualTo(createdNewsFeed.getBody());

    }

    @Test
    void 뉴스피드_수정하기() {
        // Arrange
        NewsFeed createdNewsFeed = createDummyNewsFeed();
        String changedBody = "내용을 변경합니다";

        // Action
        this.commandNewsFeedUseCase.updateNewsFeed(createdNewsFeed.getKey(), changedBody);
        // Assert
        NewsFeed updatedNewsFeed = newsFeedRepository.findById(createdNewsFeed.getKey());
        assertThat(updatedNewsFeed.getBody()).isEqualTo(changedBody);
    }

    @Test
    void 뉴스피드_삭제하기() {
        // Arrange
        NewsFeed createdNewsFeed = createDummyNewsFeed();
        // Action
        NewsFeed deletedNewsFeed = this.commandNewsFeedUseCase.deleteNewsFeed(createdNewsFeed.getKey());
        // Assert
        assertThat(deletedNewsFeed.isDeleted()).isTrue();
    }

    private NewsFeed createDummyNewsFeed() {
        Mentor mentor = mentorRepository.save(
            new Mentor(
                "이준희",
                "joobhee@google.com",
                "https://avatars.githubusercontent.com/u/77449822?v=4")
        );
        return this.commandNewsFeedUseCase.createNewsFeed(mentor.getMentorId(), null);
    }

}