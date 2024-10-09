package com.joonhee.moneygate.account.exception;

public class NotFoundMentorException extends IllegalArgumentException {
    public NotFoundMentorException(Long mentorId) {
        super("Mentor is not found | id: " + mentorId);
    }
}
