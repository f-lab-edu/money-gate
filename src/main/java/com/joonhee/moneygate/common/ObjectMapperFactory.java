package com.joonhee.moneygate.common;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public enum ObjectMapperFactory {
    INSTANCE;

    private static ObjectMapper objectMapper;

    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            setSerializationConfig(objectMapper);
        }
        return objectMapper;
    }

    private static ObjectMapper setSerializationConfig(ObjectMapper objectMapper) {
        return objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
