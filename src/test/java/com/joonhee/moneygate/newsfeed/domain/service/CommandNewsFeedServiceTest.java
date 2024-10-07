package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.account.domain.entity.Mentor;
import com.joonhee.moneygate.account.domain.repository.MentorRepository;
import com.joonhee.moneygate.account.repository.MemoryMentorRepository;
import com.joonhee.moneygate.newsfeed.domain.entity.ContentStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.repository.MemoryNewsFeedRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("뉴스피드 생성하기(Public)")
    void create() {
        // Arrange, Action
        NewsFeed createdNewsFeed = createDummyPublicNewsFeed();

        // Assert
        assertThat(createdNewsFeed.getId()).isEqualTo(createdNewsFeed.getId());
        assertThat(createdNewsFeed.getBody()).isEqualTo(createdNewsFeed.getBody());
    }

    @Test
    @DisplayName("뉴스피드 생성하기(Draft)")
    void test() {
        // Arrange, Action
        NewsFeed createdDraftNewsFeed = createDummyDraftNewsFeed();
        // Assert
        assertThat(createdDraftNewsFeed.getId()).isEqualTo(createdDraftNewsFeed.getId());
        assertThat(createdDraftNewsFeed.getBody()).isEqualTo(createdDraftNewsFeed.getBody());
        assertThat(createdDraftNewsFeed.getStatus()).isEqualTo(ContentStatus.DRAFT);
    }

    @Test
    @DisplayName("뉴스피드 수정하기")
    void update() {
        // Arrange
        NewsFeed createdNewsFeed = createDummyPublicNewsFeed();
        String changedBody = "내용을 변경합니다";

        // Action
        this.commandNewsFeedUseCase.updateNewsFeed(createdNewsFeed.getKey(), changedBody);
        // Assert
        NewsFeed updatedNewsFeed = newsFeedRepository.findByKey(createdNewsFeed.getKey());
        assertThat(updatedNewsFeed.getBody()).isEqualTo(changedBody);
    }

    @Test
    @DisplayName("뉴스피드 삭제하기")
    void delete() {
        // Arrange
        NewsFeed createdNewsFeed = createDummyPublicNewsFeed();
        // Action
        NewsFeed deletedNewsFeed = this.commandNewsFeedUseCase.deleteNewsFeed(createdNewsFeed.getKey());
        // Assert
        assertThat(deletedNewsFeed.isDeleted()).isTrue();
    }

    private NewsFeed createDummyPublicNewsFeed() {
        Mentor mentor = mentorRepository.save(createDummyMentorEntity());
        return this.commandNewsFeedUseCase.createNewsFeedByPublic(mentor.getId(), null);
    }

    private NewsFeed createDummyDraftNewsFeed() {

        Mentor mentor = mentorRepository.save(
            createDummyMentorEntity());
        return this.commandNewsFeedUseCase.createNewsFeedByDraft(mentor.getId(), null);
    }

    private Mentor createDummyMentorEntity() {
        return mentorRepository.save(
            new Mentor(
                "이준희",
                "joobhee@google.com",
                "https://avatars.githubusercontent.com/u/77449822?v=4"));
    }
}