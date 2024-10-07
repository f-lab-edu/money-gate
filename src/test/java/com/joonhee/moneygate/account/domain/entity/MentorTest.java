package com.joonhee.moneygate.account.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MentorTest {

    @Test
    @DisplayName("멘토 생성")
    void createMentor() {
        // Arrange
        String nickName = "joonheeTest";
        String email = "joonheeTest@abc.com";
        String profileImage = "https://joonhee.com";

        // Action
        Mentor mentor = new Mentor(nickName, email, profileImage);
        // Assert
        assertThat(mentor.getNickName()).isEqualTo(nickName);
        assertThat(mentor.getEmail()).isEqualTo(email);
        assertThat(mentor.getProfileImage()).isEqualTo(profileImage);
    }

    @Test
    @DisplayName("이메일 검증")
    void validateEmail() {
        // Arrange
        String nickName = "joonheeTest";
        String email = "";
        String profileImage = "https://joonhee.com";

        // Action & Assert
        assertThatThrownBy(() -> new Mentor(nickName, email, profileImage))
            .isInstanceOf(IllegalArgumentException.class);
    }
}