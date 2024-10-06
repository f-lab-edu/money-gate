package com.joonhee.moneygate.mentor.domain.service;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;
import com.joonhee.moneygate.mentor.domain.repository.MentorRepository;
import org.springframework.stereotype.Service;

@Service
public class QueryMentorService {
    private final MentorRepository mentorRepository;

    public QueryMentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public Mentor findById(Long id) {
        return mentorRepository.findById(id);
    }
}
