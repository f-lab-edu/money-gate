package com.joonhee.moneygate.account.application;

import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;
import com.joonhee.moneygate.account.exception.NotFoundMentorException;
import org.springframework.stereotype.Repository;

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
        return crudMentorRepository.findById(id).orElseThrow(() -> new NotFoundMentorException(id));
    }
}
