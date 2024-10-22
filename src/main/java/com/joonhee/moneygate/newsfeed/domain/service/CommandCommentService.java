package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.newsfeed.domain.entity.Comment;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.CommentRepository;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.validator.NewsFeedValidator;
import com.joonhee.moneygate.validator.UserValidator;
import org.springframework.stereotype.Service;

@Service
public class CommandCommentService {
    private final CommentRepository commentRepository;
    private final NewsFeedRepository newsFeedRepository;
    private final UserValidator userValidator;
    private final NewsFeedValidator newsFeedValidator;

    public CommandCommentService(
        CommentRepository commentRepository,
        NewsFeedRepository newsFeedRepository,
        UserValidator userValidator,
        NewsFeedValidator newsFeedValidator
    ) {
        this.commentRepository = commentRepository;
        this.newsFeedRepository = newsFeedRepository;
        this.userValidator = userValidator;
        this.newsFeedValidator = newsFeedValidator;
    }

    public Comment createCommentByPublic(Long userId, String newsFeedKey, String body) {
        NewsFeed newsFeed = getNewsFeed(newsFeedKey);
        userValidator.validateUser(userId);
        return commentRepository.save(Comment.createCommentByPublic(userId, newsFeed.getId(), body));
    }

    public Comment createCommentByDraft(Long userId, String newsFeedKey, String body) {
        NewsFeed newsFeed = getNewsFeed(newsFeedKey);
        userValidator.validateUser(userId);
        return commentRepository.save(Comment.createCommentByDraft(userId, newsFeed.getId(), body));
    }

    public Comment delete(Long commentId) {
        Comment comment = commentRepository.findById(commentId);
        userValidator.validateUser(comment.getUserId());
        comment.delete();
        return commentRepository.save(comment);
    }

    public Comment update(Long commentId, String body) {
        Comment comment = commentRepository.findById(commentId);
        userValidator.validateUser(comment.getUserId());
        comment.updateBody(body);
        return commentRepository.save(comment);
    }

    private NewsFeed getNewsFeed(String newsFeedKey) {
        newsFeedValidator.validateNewsFeed(newsFeedKey);
        return newsFeedRepository.findByKey(newsFeedKey);
    }
}
