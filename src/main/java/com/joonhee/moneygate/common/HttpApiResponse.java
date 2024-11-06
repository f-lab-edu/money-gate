package com.joonhee.moneygate.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Builder
@Getter
public class HttpApiResponse<T>{
    String message;
    T data;

    public static <T> HttpApiResponse of(T data) {
        return HttpApiResponse.builder()
            .data(data)
            .message("")
            .build();
    }

    public static HttpApiResponse fromExceptionMessage(String message) {
        return HttpApiResponse.builder()
            .data(null)
            .message(message)
            .build();
    }

    public static HttpApiResponse fromExceptionMessage(String message, Map<String, Object> data) {
        return HttpApiResponse.builder()
            .data(data)
            .message(message)
            .build();
    }
}
