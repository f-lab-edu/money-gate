package com.joonhee.moneygate.account.application;

import com.joonhee.moneygate.account.domain.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudMentorRepository extends CrudRepository<User, Long> {
    @Query("SELECT * FROM user WHERE user_id IN (:ids)")
    List<User> findByIds(List<Long> ids);
}
