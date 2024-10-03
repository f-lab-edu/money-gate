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

    public Long createMentor(String nickName, String email, String profileImage) {
        Mentor mentor = new Mentor(nickName, email, profileImage);
        mentorRepository.save(mentor);
        return mentor.getId();
    }

    public Mentor findById(Long id) {
        return mentorRepository.findById(id);
    }
}
