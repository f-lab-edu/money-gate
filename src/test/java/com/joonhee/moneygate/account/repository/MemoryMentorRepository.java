package com.joonhee.moneygate.account.repository;

import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;
import com.joonhee.moneygate.account.exception.NotFoundMentorException;

import java.util.HashMap;
import java.util.List;

public class MemoryMentorRepository implements UserRepository {
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

    @Override
    public List<User> findByIds(List<Long> ids) {
        return mentors.values().stream()
                .filter(mentor -> ids.contains(mentor.getId()))
                .toList();
    }
}
