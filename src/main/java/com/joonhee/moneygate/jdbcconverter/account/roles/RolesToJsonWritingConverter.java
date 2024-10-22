package com.joonhee.moneygate.jdbcconverter.account.roles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joonhee.moneygate.account.domain.entity.Roles;
import com.joonhee.moneygate.common.ObjectMapperFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@Slf4j
@WritingConverter
public class RolesToJsonWritingConverter implements Converter<Roles, String> {
    private final ObjectMapper objectMapper = ObjectMapperFactory.INSTANCE.getObjectMapper();
    @Override
    public String convert(Roles source) {
        try {
            return objectMapper.writeValueAsString(source.toDto());
        } catch (JsonProcessingException e) {
            log.error("Failed to convert Roles to json", e);
            throw new RuntimeException(e);
        }
    }
}
