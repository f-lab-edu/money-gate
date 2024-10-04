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
    @DisplayName("멘토 생성 테스트")
    void createMentor() {
        // given
        String nickName = "joonhee11";
        String email = "joonhee@abc11.com";
        String profileImage = "https://joonhee.com";

        // when
        Mentor mentor = createMentorService.createMentor(nickName, email, profileImage);
        assertThat(mentor.getId()).isNotNull();

    }
}