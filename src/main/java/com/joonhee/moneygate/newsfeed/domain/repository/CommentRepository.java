package com.joonhee.moneygate.newsfeed.domain.repository;

import com.joonhee.moneygate.newsfeed.domain.entity.Comment;

public interface CommentRepository {
    Comment save(Comment comment);

    Comment findById(Long id);
}
