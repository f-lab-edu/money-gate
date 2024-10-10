package com.joonhee.moneygate.validator;

import com.joonhee.moneygate.account.domain.entity.Role;
import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;
import com.joonhee.moneygate.account.exception.InvalidUserPermission;
import org.springframework.stereotype.Component;

@Component
public class MentorValidator {
    private final UserRepository userRepository;

    public MentorValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateMentor(Long mentorId) {
        User user = userRepository.findById(mentorId);
        if(!user.isMentor()) {
            throw new InvalidUserPermission(user.getRoles(), Role.NEWS_FEED_WRITER);
        }
    }
}
