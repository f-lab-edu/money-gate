package com.joonhee.moneygate.mentor.application;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CrudMentorRepository extends CrudRepository<Mentor, Long> {
    Optional<Mentor> findById(Long id);
}
