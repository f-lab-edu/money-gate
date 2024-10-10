package com.joonhee.moneygate.account.domain.service;

import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class QueryMentorService {
    private final UserRepository mentorRepository;

    public QueryMentorService(UserRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public User findById(Long id) {
        return mentorRepository.findById(id);
    }
}
