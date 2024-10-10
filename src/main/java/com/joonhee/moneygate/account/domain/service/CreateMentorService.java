package com.joonhee.moneygate.account.domain.service;

import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateMentorService {
    private final UserRepository mentorRepository;

    public CreateMentorService(UserRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public User createMentor(String nickName, String email, String profileImage) {
        User mentor = User.createMentor(nickName, email, profileImage);
        mentor = mentorRepository.save(mentor);
        return mentor;
    }
}
