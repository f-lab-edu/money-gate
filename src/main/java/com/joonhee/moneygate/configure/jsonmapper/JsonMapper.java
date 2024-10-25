package com.joonhee.moneygate.configure.jsonmapper;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface JsonMapper {
    <T> T readValue(String content, Class<T> valueType) throws JsonProcessingException;
    String writeValueAsString(Object value) throws JsonProcessingException;
}
