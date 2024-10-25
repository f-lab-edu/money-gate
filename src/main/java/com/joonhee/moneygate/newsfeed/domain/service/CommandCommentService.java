package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.account.domain.repository.UserRepository;
import com.joonhee.moneygate.newsfeed.domain.entity.Comment;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.CommentRepository;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import org.springframework.stereotype.Service;

@Service
public class CommandCommentService {
    private final CommentRepository commentRepository;
    private final NewsFeedRepository newsFeedRepository;
    private final UserRepository userRepository;

    public CommandCommentService(
        CommentRepository commentRepository,
        NewsFeedRepository newsFeedRepository,
        UserRepository userRepository
    ) {
        this.commentRepository = commentRepository;
        this.newsFeedRepository = newsFeedRepository;
        this.userRepository = userRepository;
    }

    public Comment createCommentByPublic(Long userId, String newsFeedKey, String body) {
        NewsFeed newsFeed = newsFeedRepository.findByKey(newsFeedKey);
        userRepository.findById(userId);
        return commentRepository.save(Comment.createCommentByPublic(userId, newsFeed.getId(), body));
    }

    public Comment createCommentByDraft(Long userId, String newsFeedKey, String body) {
        NewsFeed newsFeed = newsFeedRepository.findByKey(newsFeedKey);
        userRepository.findById(userId);
        return commentRepository.save(Comment.createCommentByDraft(userId, newsFeed.getId(), body));
    }

    public Comment delete(Long commentId) {
        Comment comment = commentRepository.findById(commentId);
        userRepository.findById(comment.getUserId());
        comment.delete();
        return commentRepository.save(comment);
    }

    public Comment update(Long commentId, String body) {
        Comment comment = commentRepository.findById(commentId);
        userRepository.findById(comment.getUserId());
        comment.updateBody(body);
        return commentRepository.save(comment);
    }

    private NewsFeed getNewsFeed(String newsFeedKey) {
        newsFeedRepository.findByKey(newsFeedKey);
        return newsFeedRepository.findByKey(newsFeedKey);
    }
}
