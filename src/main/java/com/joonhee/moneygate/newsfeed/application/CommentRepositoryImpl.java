package com.joonhee.moneygate.newsfeed.application;

import com.joonhee.moneygate.newsfeed.domain.entity.Comment;
import com.joonhee.moneygate.newsfeed.domain.repository.CommentRepository;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
    private final CrudCommentRepository crudCommentRepository;

    public CommentRepositoryImpl(CrudCommentRepository crudCommentRepository) {
        this.crudCommentRepository = crudCommentRepository;
    }

    @Override
    public Comment save(Comment comment) {
        return crudCommentRepository.save(comment);
    }

    @Override
    public Comment findById(Long commentId) {
        return crudCommentRepository.findById(commentId).orElseThrow(() -> new NoSuchElementException(
            "존재하지 않는 댓글입니다. " + "commentId: " + commentId)
        );
    }
}
