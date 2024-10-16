package com.joonhee.moneygate.account.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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

    private User(String nickName, String email, String profileImage) {
        this.email = email;
        this.nickName = nickName;
        this.profileImage = profileImage;
        this.createdAt = LocalDateTime.now();
    }

    public static User createMentor(String nickName, String email, String profileImage) {
        User user = new User(nickName, email, profileImage);
        user.roles = new Roles(Arrays.asList(Role.USER, Role.NEWS_FEED_WRITER));
        return user;
    }

    public static User createUser(String nickName, String email, String profileImage) {
        User user = new User(nickName, email, profileImage);
        user.roles = new Roles(Arrays.asList(Role.USER));
        return user;
    }

    public boolean isMentor() {
        return roles.contains(Role.NEWS_FEED_WRITER);
    }
}
