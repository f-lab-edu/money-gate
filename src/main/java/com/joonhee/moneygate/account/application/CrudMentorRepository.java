package com.joonhee.moneygate.account.application;

import com.joonhee.moneygate.account.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudMentorRepository extends CrudRepository<User, Long> {
}
