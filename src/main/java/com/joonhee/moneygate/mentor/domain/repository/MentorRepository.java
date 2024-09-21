package com.joonhee.moneygate.mentor.domain.repository;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;
import com.joonhee.moneygate.mentor.domain.vo.MentorId;

public interface MentorRepository {
    Mentor save(Mentor mentor);
    Mentor findById(MentorId id);
}
