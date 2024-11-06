package com.joonhee.moneygate.validator;

import com.joonhee.moneygate.account.domain.entity.Role;
import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;
import com.joonhee.moneygate.exception.ApplicationException;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MentorValidator {
    private final UserRepository userRepository;

    public MentorValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateMentor(Long mentorId) {
        User user = userRepository.findById(mentorId);
        if (!user.isMentor()) {
            throw new ApplicationException(
                "사용자 권한이 유효하지 않습니다.",
                Map.of(
                    "hasRole", user.getRoles().toString(),
                    "requiredRole", Role.NEWS_FEED_WRITER.name())
            );
        }
    }
}
