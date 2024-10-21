package com.joonhee.moneygate.account.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;
import java.util.Arrays;

@Getter
@NoArgsConstructor
public class User {
    @Id
    @Column("user_id")
    private Long id;
    private String email;
    private String nickName;
    private String profileImage;
    private Roles roles;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    private User(
        Long id,
        String email,
        String nickName,
        String profileImage,
        Roles roles,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
    ) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.profileImage = profileImage;
        this.roles = roles;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static User createMentor(String nickName, String email, String profileImage) {
        return User.builder()
            .email(email)
            .nickName(nickName)
            .profileImage(profileImage)
            .roles(new Roles(Arrays.asList(Role.USER, Role.NEWS_FEED_WRITER)))
            .createdAt(LocalDateTime.now())
            .build();
    }

    public static User createUser(String nickName, String email, String profileImage) {
        return User.builder()
            .email(email)
            .nickName(nickName)
            .profileImage(profileImage)
            .roles(new Roles(Arrays.asList(Role.USER)))
            .createdAt(LocalDateTime.now())
            .build();
    }

    public boolean isMentor() {
        return roles.contains(Role.NEWS_FEED_WRITER);
    }
}
