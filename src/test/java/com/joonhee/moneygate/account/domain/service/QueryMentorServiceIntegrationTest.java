package com.joonhee.moneygate.account.domain.service;

import account.domain.repository.MentorRepositoryHelper;
import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class QueryMentorServiceIntegrationTest {
    @Autowired
    private QueryMentorService queryMentorService;
    @Autowired
    private UserRepository mentorRepository;
    private MentorRepositoryHelper mentorRepositoryHelper;

    @BeforeEach
    void setUp() {
        this.mentorRepositoryHelper = new MentorRepositoryHelper(
            mentorRepository
        );
    }

    @Test
    @DisplayName("멘토 조회")
    void findById() {
        // Arrange
        User mentor = mentorRepositoryHelper.createDummyMentor();
        Long id = mentor.getId();

        // Action
        User foundMentor = queryMentorService.findById(id);

        // Assert
        assertThat(mentor.getId()).isEqualTo(foundMentor.getId());
    }


}