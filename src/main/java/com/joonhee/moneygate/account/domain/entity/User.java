package com.joonhee.moneygate.account.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class User {
    @Id
    @Column("user_id")
    private Long id;
    private String email;
    private String nickName;
    private String profileImage;
    private String roles;
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
        user.setRoles(Arrays.asList(Role.USER, Role.NEWS_FEED_WRITER));
        return user;
    }

    public static User createUser(String nickName, String email, String profileImage) {
        User user = new User(nickName, email, profileImage);
        user.setRoles(Arrays.asList(Role.USER));
        return user;
    }

    public boolean isMentor() {
        return getRoles().contains(Role.NEWS_FEED_WRITER);
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

    public List<Role> getRoles() {
        return Arrays.stream(roles.split(","))
            .map(Role::valueOf)
            .collect(Collectors.toList());
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles.stream()
            .map(Role::name)
            .collect(Collectors.joining(","));
    }
}
