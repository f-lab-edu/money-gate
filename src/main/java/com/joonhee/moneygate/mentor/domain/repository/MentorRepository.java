package com.joonhee.moneygate.mentor.domain.repository;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;

public interface MentorRepository {
    Mentor save(Mentor mentor);
    Mentor findById(Long id);
}
