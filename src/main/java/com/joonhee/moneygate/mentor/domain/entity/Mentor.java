package com.joonhee.moneygate.mentor.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Mentor {
    @Id
    @Column("mentor_id")
    private Long id;
    private String email;
    private String nickName;
    private String profileImage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Mentor(String nickName, String email, String profileImage) {
        validateEmail(email);
        this.email = email;
        this.nickName = nickName;
        this.profileImage = profileImage;
        this.createdAt = LocalDateTime.now();
    }

    private void validateEmail(String email) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("이메일이 비어있습니다.");
        }

        if (!email.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
        }
    }
}
