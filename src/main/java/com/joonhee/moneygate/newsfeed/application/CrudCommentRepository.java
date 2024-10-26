package com.joonhee.moneygate.newsfeed.application;

import com.joonhee.moneygate.newsfeed.domain.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CrudCommentRepository extends CrudRepository<Comment, Long> {
}
