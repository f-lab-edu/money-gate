package com.joonhee.moneygate.account.domain.repository;

import com.joonhee.moneygate.account.domain.entity.User;

import java.util.List;

public interface UserRepository {
    User save(User mentor);
    User findById(Long id) throws IllegalArgumentException;
    List<User> findByIds(List<Long> ids);
}
