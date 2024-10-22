package com.joonhee.moneygate.account.exception;

public class NotFoundUserException extends IllegalArgumentException {
    public NotFoundUserException(Long userId) {
        super("User is not found | id: " + userId);
    }
}
