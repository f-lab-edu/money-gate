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
        this.email = email;
        this.nickName = nickName;
        this.profileImage = profileImage;
        this.createdAt = LocalDateTime.now();
    }
}
