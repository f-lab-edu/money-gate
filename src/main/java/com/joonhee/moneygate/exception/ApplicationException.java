package com.joonhee.moneygate.exception;

import com.joonhee.moneygate.common.httpresponse.CodeEnum;
import lombok.Getter;

import java.util.Map;

@Getter
public class ApplicationException extends RuntimeException {
    private CodeEnum code;
    private Map<String, Object> data;
    public ApplicationException(CodeEnum code, String message, Map<String, Object> data) {
        super(message);
        this.code = code;
        this.data = data;
    }
}