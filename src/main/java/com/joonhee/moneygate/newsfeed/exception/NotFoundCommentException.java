package com.joonhee.moneygate.newsfeed.exception;

public class NotFoundCommentException extends IllegalArgumentException {
    public NotFoundCommentException(Long commentId) {
        super("Comment is not found | id: " + commentId);
    }
}
