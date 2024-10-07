package com.joonhee.moneygate.account.domain.service;

import com.joonhee.moneygate.account.domain.entity.Mentor;
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
    private CreateMentorService createMentorService;
    @Autowired
    private QueryMentorService queryMentorService;

    @Test
    @DisplayName("멘토 조회")
    void findById() {
        // Arrange
        String nickName = "joonheeTest";
        String email = "jonnheeTest@abc.com";
        String profileImage = "https://joonhee.com";
        Mentor mentor = createMentorService.createMentor(nickName, email, profileImage);
        Long id = mentor.getId();

        // Action
        Mentor foundMentor = queryMentorService.findById(id);

        // Assert
        assertThat(mentor.getId()).isEqualTo(foundMentor.getId());
    }


}