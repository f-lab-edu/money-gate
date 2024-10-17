package account.domain.entity;

import com.joonhee.moneygate.account.domain.entity.User;

public class UserStub {
    public static User createDummyUser() {
        User user = User.createUser(
            "joonheeuser",
            "joonheeuser@abc.com",
            "https://joonheeuser.com"
        );
        return User.builder()
            .nickName(user.getNickName())
            .email(user.getEmail())
            .profileImage(user.getProfileImage())
            .roles(user.getRoles())
            .createdAt(user.getCreatedAt())
            .updatedAt(user.getUpdatedAt())
            .build();
    }

    public static User createDummyMentor() {
        User mentor = User.createMentor(
            "joonheetest",
            "joonheeTest@abc.com",
            "https://joonhee.com"
        );
        return User.builder()
            .nickName(mentor.getNickName())
            .email(mentor.getEmail())
            .profileImage(mentor.getProfileImage())
            .roles(mentor.getRoles())
            .createdAt(mentor.getCreatedAt())
            .updatedAt(mentor.getUpdatedAt())
            .build();

    }
}
