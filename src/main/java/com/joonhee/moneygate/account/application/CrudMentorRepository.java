package com.joonhee.moneygate.account.application;

import com.joonhee.moneygate.account.domain.entity.Mentor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudMentorRepository extends CrudRepository<Mentor, Long> {
}
