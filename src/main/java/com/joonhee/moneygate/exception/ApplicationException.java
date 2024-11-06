package com.joonhee.moneygate.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class ApplicationException extends RuntimeException {
    Map<String, Object> data;
    public ApplicationException(String message, Map<String, Object> data) {
        super(message);
        this.data = data;
    }
}