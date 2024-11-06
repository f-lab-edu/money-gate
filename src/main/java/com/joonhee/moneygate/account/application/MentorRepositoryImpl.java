package com.joonhee.moneygate.account.application;

import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class MentorRepositoryImpl implements UserRepository {

    private final CrudMentorRepository crudMentorRepository;

    public MentorRepositoryImpl(CrudMentorRepository crudMentorRepository) {
        this.crudMentorRepository = crudMentorRepository;
    }

    @Override
    public User save(User mentor) {
        return crudMentorRepository.save(mentor);
    }

    @Override
    public User findById(Long id) throws IllegalArgumentException {
        return crudMentorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("userId: " + id));
    }

    @Override
    public List<User> findByIds(List<Long> ids) {
        return crudMentorRepository.findByIds(ids);
    }
}
