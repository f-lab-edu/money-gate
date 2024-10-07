package com.joonhee.moneygate.account.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table("user")
public class Mentor extends User {
    public Mentor(String nickName, String email, String profileImage) {
        super.validateEmail(email);
        super.email = email;
        super.nickName = nickName;
        super.profileImage = profileImage;
        super.createdAt = LocalDateTime.now();
    }
}
