package com.joonhee.moneygate.account.domain.repository;

import com.joonhee.moneygate.account.domain.entity.Mentor;

public interface MentorRepository {
    Mentor save(Mentor mentor);
    Mentor findById(Long id);
}
