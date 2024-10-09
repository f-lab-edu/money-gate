package com.joonhee.moneygate.account.repository;

import com.joonhee.moneygate.account.domain.entity.Mentor;
import com.joonhee.moneygate.account.domain.repository.MentorRepository;
import com.joonhee.moneygate.account.exception.NotFoundMentorException;

import java.util.HashMap;

public class MemoryMentorRepository implements MentorRepository {
    private final HashMap<Long, Mentor> mentors = new HashMap<>();

    @Override
    public Mentor save(Mentor mentor) {
        mentors.put(mentor.getId(), mentor);
        return mentor;
    }

    @Override
    public Mentor findById(Long id) throws IllegalArgumentException {
        Mentor mentor = mentors.get(id);
        if (mentor == null) {
            throw new NotFoundMentorException(id);
        }
        return mentor;
    }
}
