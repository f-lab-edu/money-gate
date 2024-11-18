package com.joonhee.moneygate.account.repository;

import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;
import com.joonhee.moneygate.common.httpresponse.CodeEnum;
import com.joonhee.moneygate.exception.ApplicationException;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class MemoryUserRepository implements UserRepository {
    private final HashMap<Long, User> mentors = new HashMap<>();
    private Long id = 0L;

    @Override
    public User save(User mentor) {
        Long userId = getUserId(mentor.getId());
        User mentorWithId = User.builder()
            .id(userId)
            .email(mentor.getEmail())
            .nickName(mentor.getNickName())
            .profileImage(mentor.getProfileImage())
            .roles(mentor.getRoles())
            .createdAt(mentor.getCreatedAt())
            .updatedAt(mentor.getUpdatedAt())
            .build();
        mentors.put(mentorWithId.getId(), mentorWithId);
        return mentorWithId;
    }

    private Long getUserId(Long userId) {
        if (userId != null) {
            return userId;
        }
        return generateId();
    }

    @Override
    public User findById(Long id) throws IllegalArgumentException {
        User mentor = mentors.get(id);
        if (mentor == null) {
            throw new ApplicationException(CodeEnum.FRS_003, "id" + id);
        }
        return mentor;
    }

    @Override
    public List<User> findByIds(List<Long> ids) {
        return mentors.values().stream()
            .filter(mentor -> ids.contains(mentor.getId()))
            .toList();
    }

    private Long generateId() {
        return id++;
    }
}
