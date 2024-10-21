package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.newsfeed.domain.entity.Comment;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.CommentRepository;
import com.joonhee.moneygate.validator.NewsFeedValidator;
import org.springframework.stereotype.Service;

@Service
public class CommandCommentService {
    private final CommentRepository commentRepository;
    private final NewsFeedValidator newsFeedValidator;

    public CommandCommentService(
        CommentRepository commentRepository,
        NewsFeedValidator newsFeedValidator
    ) {
        this.commentRepository = commentRepository;
        this.newsFeedValidator = newsFeedValidator;
    }

    public Comment createCommentByPublic(Long userId, String newsFeedKey, String body) {
        NewsFeed newsFeed = newsFeedValidator.validateNewsFeed(newsFeedKey);
        return commentRepository.save(Comment.createCommentByPublic(userId, newsFeed.getId(), body));
    }

    public Comment createCommentByDraft(Long userId, String newsFeedKey, String body) {
        NewsFeed newsFeed = newsFeedValidator.validateNewsFeed(newsFeedKey);
        return commentRepository.save(Comment.createCommentByDraft(userId, newsFeed.getId(), body));
    }

    public Comment delete(Long commentId) {
        Comment comment = commentRepository.findById(commentId);
        comment.delete();
        return commentRepository.save(comment);
    }

    public Comment update(Long commentId, String body) {
        Comment comment = commentRepository.findById(commentId);
        comment.updateBody(body);
        return commentRepository.save(comment);
    }
}
