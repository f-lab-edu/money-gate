package com.joonhee.moneygate.mentor.domain.service;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CreateMentorServiceIntegrationTest {

    @Autowired
    private CreateMentorService createMentorService;

    @Test
    @DisplayName("멘토 생성")
    void createMentor() {
        // Arrange
        String nickName = "joonheeTest";
        String email = "joonheeTest@abc.com";
        String profileImage = "https://joonhee.com";

        // Action
        Mentor mentor = createMentorService.createMentor(nickName, email, profileImage);

        // Assert
        assertThat(mentor.getId()).isNotNull();

    }
}