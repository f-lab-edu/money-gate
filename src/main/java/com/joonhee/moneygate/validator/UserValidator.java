package com.joonhee.moneygate.validator;

import com.joonhee.moneygate.account.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {
    private final UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateUser(Long userId) {
        userRepository.findById(userId);
    }
}

