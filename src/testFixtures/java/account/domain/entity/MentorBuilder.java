package account.domain.entity;

import com.joonhee.moneygate.account.domain.entity.User;

public class MentorBuilder {

    public static User createDummyMentor() {
        return User.createMentor(
            "joonheetest",
            "joonheeTest@abc.com",
            "https://joonhee.com"
        );
    }
}
