package com.joonhee.moneygate.mentor.domain.service;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CreateMentorServiceIntegrationTest {

    @Autowired
    CreateMentorService createMentorService;
    @Autowired
    QueryMentorService queryMentorService;

    @Test
    @DisplayName("멘토 등록 테스트")
    void createMentor() {
        // Arrange, Action
        Long mentorId = createMentorService.createMentor("nickName10", "joonhee@abc10.com", "https://image.com");
        // Assert
        Mentor mentor = queryMentorService.findById(mentorId);
        assertThat(mentorId).isEqualTo(mentor.getId());
    }
}