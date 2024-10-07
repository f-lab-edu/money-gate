package com.joonhee.moneygate.account.domain.service;

import com.joonhee.moneygate.account.domain.entity.Mentor;
import com.joonhee.moneygate.account.domain.repository.MentorRepository;
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
