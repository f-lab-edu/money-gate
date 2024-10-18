package com.joonhee.moneygate.common;

import com.fasterxml.jackson.databind.ObjectMapper;

public enum ObjectMapperFactory {
    INSTANCE;

    private static ObjectMapper objectMapper;

    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }
}
