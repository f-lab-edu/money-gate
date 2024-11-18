package com.joonhee.moneygate.configure;

import com.joonhee.moneygate.common.httpresponse.HttpApiResponse;
import com.joonhee.moneygate.exception.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler({ApplicationException.class})
    public ResponseEntity handleApplicationException(ApplicationException e) {
        e.printStackTrace();
        return ResponseEntity.status(400).body(
            HttpApiResponse.fromExceptionMessage(e.getMessage(), e.getData())
        );
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleSystemException(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(500).body(
            HttpApiResponse.fromExceptionMessage(e.toString())
        );
    }
}
