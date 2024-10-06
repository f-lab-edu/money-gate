package com.joonhee.moneygate.mentor.application;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;
import com.joonhee.moneygate.mentor.domain.repository.MentorRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MentorRepositoryImpl implements MentorRepository {

    private final CrudMentorRepository crudMentorRepository;

    public MentorRepositoryImpl(CrudMentorRepository crudMentorRepository) {
        this.crudMentorRepository = crudMentorRepository;
    }

    @Override
    public Mentor save(Mentor mentor) {
        return crudMentorRepository.save(mentor);
    }

    @Override
    public Mentor findById(Long id) {
        return crudMentorRepository.findById(id).orElse(null);
    }
}
