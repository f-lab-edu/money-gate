package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.account.domain.repository.UserRepository;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.dto.NewsFeedDetail;
import newsfeed.domain.repository.NewsFeedRepositoryHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ComponentScan(basePackages = "com.joonhee.moneygate")
@Transactional
public class QueryNewsFeedServiceIntegrationTest {

    @Autowired
    private QueryNewsFeedService queryNewsFeedService;
    @Autowired
    private NewsFeedRepository newsFeedRepository;
    @Autowired
    private UserRepository mentorRepository;
    private NewsFeedRepositoryHelper newsFeedRepositoryHelper;

    @BeforeEach
    void setUp() {
        this.newsFeedRepositoryHelper = new NewsFeedRepositoryHelper(
            newsFeedRepository,
            mentorRepository
        );
    }

    @Test
    @DisplayName("모든 뉴스피드 조회")
    void findAll() {
        // Arrange
        newsFeedRepositoryHelper.createDummyPublicNewsFeeds();
        // Action
        List<NewsFeedDetail> afterNewsFeeds = queryNewsFeedService.findAll();
        // Assert
        assertThat(afterNewsFeeds.size()).isGreaterThan(0);
    }
}
