package com.joonhee.moneygate.mentor.domain.service;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;
import com.joonhee.moneygate.mentor.domain.repository.MentorRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateMentorService {
    private final MentorRepository mentorRepository;

    public CreateMentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public Mentor createMentor(String nickName, String email, String profileImage) {
        Mentor mentor = new Mentor(nickName, email, profileImage);
        mentor = mentorRepository.save(mentor);
        return mentor;
    }
}
