package com.joonhee.moneygate.mentor.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MentorTest {
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