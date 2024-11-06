package com.joonhee.moneygate.newsfeed.repository;

import com.joonhee.moneygate.newsfeed.domain.entity.Comment;
import com.joonhee.moneygate.newsfeed.domain.repository.CommentRepository;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class MemoryCommentRepository implements CommentRepository {
    private static Long sequence = 0L;
    private final HashMap<Long, Comment> comments = new HashMap<>();

    @Override
    public Comment save(Comment comment) {
        Long commentId = getCommentId(comment.getId());
        Comment commentWithId = comment.builder()
            .id(commentId)
            .userId(comment.getUserId())
            .newsFeedId(comment.getNewsFeedId())
            .body(comment.getBody())
            .status(comment.getStatus())
            .createdAt(comment.getCreatedAt())
            .updatedAt(comment.getUpdatedAt())
            .deletedAt(comment.getDeletedAt())
            .build();
        comments.put(commentId, commentWithId);
        return commentWithId;
    }

    @Override
    public Comment findById(Long commentId) {
        if (comments.containsKey(commentId)) {
            return comments.get(commentId);
        }
        throw new NoSuchElementException("존재하지 않는 댓글입니다. " + "commentId: " + commentId);
    }

    private Long getCommentId(Long commentId) {
        if (commentId != null) {
            return commentId;
        }
        return generateId();
    }

    private Long generateId() {
        return sequence++;
    }
}
