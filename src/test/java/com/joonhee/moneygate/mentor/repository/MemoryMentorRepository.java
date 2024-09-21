package com.joonhee.moneygate.mentor.repository;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;
import com.joonhee.moneygate.mentor.domain.repository.MentorRepository;
import com.joonhee.moneygate.mentor.domain.vo.MentorId;

import java.util.HashMap;

public class MemoryMentorRepository implements MentorRepository {
    HashMap<MentorId, Mentor> mentors = new HashMap<>();

    @Override
    public Mentor save(Mentor mentor) {
        mentors.put(mentor.getMentorId(), mentor);
        return mentor;
    }

    @Override
    public Mentor findById(MentorId id) {
        return mentors.get(id);
    }
}
