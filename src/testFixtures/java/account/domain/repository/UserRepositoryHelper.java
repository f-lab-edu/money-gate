package account.domain.repository;

import account.domain.entity.UserBuilder;
import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;

public class UserRepositoryHelper {
    private final UserRepository mentorRepository;

    public UserRepositoryHelper(UserRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public User createDummyUser() {
        return mentorRepository.save(UserBuilder.createDummyUser());
    }
}
