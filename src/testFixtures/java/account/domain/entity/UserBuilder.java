package account.domain.entity;

import com.joonhee.moneygate.account.domain.entity.User;

public class UserBuilder {
    public static User createDummyUser() {
        return User.createUser(
            "joonheeuser",
            "joonheeuser@abc.com",
            "https://joonheeuser.com"
        );
    }
}
