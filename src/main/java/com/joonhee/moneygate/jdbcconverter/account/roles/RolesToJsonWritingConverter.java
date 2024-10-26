package com.joonhee.moneygate.jdbcconverter.account.roles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.joonhee.moneygate.account.domain.entity.Roles;
import com.joonhee.moneygate.configure.jsonmapper.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@Slf4j
@WritingConverter
@Component
public class RolesToJsonWritingConverter implements Converter<Roles, String> {

    private JsonMapper jsonMapper;

    @Autowired
    public void setJsonMapper(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @Override
    public String convert(Roles source) {
        try {
            return jsonMapper.writeValueAsString(source.toDto());
        } catch (JsonProcessingException e) {
            log.error("Failed to convert Roles to json", e);
            throw new RuntimeException(e);
        }
    }
}
