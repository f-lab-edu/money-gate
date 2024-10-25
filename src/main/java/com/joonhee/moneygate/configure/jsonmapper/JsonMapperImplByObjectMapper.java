package com.joonhee.moneygate.configure.jsonmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonMapperImplByObjectMapper implements JsonMapper {
    private final ObjectMapper objectMapper;

    public JsonMapperImplByObjectMapper() {
        this.objectMapper = new ObjectMapper();
        setSerializationConfig(this.objectMapper);
    }

    @Override
    public <T> T readValue(String content, Class<T> valueType) throws JsonProcessingException {
        return this.objectMapper.readValue(content, valueType);
    }

    @Override
    public String writeValueAsString(Object value) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(value);
    }

    private ObjectMapper setSerializationConfig(ObjectMapper objectMapper) {
        return objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
