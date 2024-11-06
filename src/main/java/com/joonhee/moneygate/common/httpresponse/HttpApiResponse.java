package com.joonhee.moneygate.common.httpresponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Builder
@Getter
public class HttpApiResponse<T>{
    CodeEnum code;
    String message;
    T data;

    public static <T> HttpApiResponse of(T data) {
        return HttpApiResponse.builder()
            .code(CodeEnum.SUCCESS)
            .data(data)
            .message("")
            .build();
    }

    public static HttpApiResponse fromExceptionMessage(String message) {
        return HttpApiResponse.builder()
            .code(CodeEnum.FAIL)
            .data(null)
            .message(message)
            .build();
    }

    public static HttpApiResponse fromExceptionMessage(String message, Map<String, Object> data) {
        return HttpApiResponse.builder()
            .code(CodeEnum.FAIL)
            .data(data)
            .message(message)
            .build();
    }
}
