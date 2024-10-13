package account.domain.repository;

import account.domain.entity.MentorBuilder;
import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;

public class MentorRepositoryHelper {
    private final UserRepository mentorRepository;

    public MentorRepositoryHelper(UserRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public User createDummyMentor() {
        return mentorRepository.save(MentorBuilder.createDummyMentor());
    }
}
