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
    @Column("roles")
    private String rolesString;
    @Transient
    private Roles roles;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private User(String nickName, String email, String profileImage) {
        validateEmail(email);
        this.email = email;
        this.nickName = nickName;
        this.profileImage = profileImage;
        this.createdAt = LocalDateTime.now();
    }

    public static User createMentor(String nickName, String email, String profileImage) {
        User user = new User(nickName, email, profileImage);
        user.roles = new Roles(Arrays.asList(Role.USER, Role.NEWS_FEED_WRITER));
        user.rolesString = user.roles.listAsString();
        return user;
    }

    public static User createUser(String nickName, String email, String profileImage) {
        User user = new User(nickName, email, profileImage);
        user.roles = new Roles(Arrays.asList(Role.USER));
        user.rolesString = user.roles.listAsString();
        return user;
    }

    public boolean isMentor() {
        if(roles == null) {
            roles = Roles.fromString(rolesString);
        }
        return roles.contains(Role.NEWS_FEED_WRITER);
    }

    void validateEmail(String email) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("이메일이 비어있습니다.");
        }

        if (!email.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
        }
    }
}
