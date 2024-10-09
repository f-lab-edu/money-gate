package com.joonhee.moneygate.account.repository;

import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.MentorRepository;
import com.joonhee.moneygate.account.exception.NotFoundMentorException;

import java.util.HashMap;

public class MemoryMentorRepository implements MentorRepository {
    private final HashMap<Long, User> mentors = new HashMap<>();

    @Override
    public User save(User mentor) {
        mentors.put(mentor.getId(), mentor);
        return mentor;
    }

    @Override
    public User findById(Long id) throws IllegalArgumentException {
        User mentor = mentors.get(id);
        if (mentor == null) {
            throw new NotFoundMentorException(id);
        }
        return mentor;
    }
}
