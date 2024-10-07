package com.joonhee.moneygate.account.repository;

import com.joonhee.moneygate.account.domain.entity.Mentor;
import com.joonhee.moneygate.account.domain.repository.MentorRepository;

import java.util.HashMap;

public class MemoryMentorRepository implements MentorRepository {
    private final HashMap<Long, Mentor> mentors = new HashMap<>();

    @Override
    public Mentor save(Mentor mentor) {
        mentors.put(mentor.getId(), mentor);
        return mentor;
    }

    @Override
    public Mentor findById(Long id) {
        return mentors.get(id);
    }
}
