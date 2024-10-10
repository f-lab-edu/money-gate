package com.joonhee.moneygate.account.domain.repository;

import com.joonhee.moneygate.account.domain.entity.User;

public interface UserRepository {
    User save(User mentor);
    User findById(Long id) throws IllegalArgumentException;
}
