package com.joonhee.moneygate.jdbcconverter.account.roles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.joonhee.moneygate.account.domain.dto.RolesDto;
import com.joonhee.moneygate.account.domain.entity.Roles;
import com.joonhee.moneygate.configure.jsonmapper.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@Slf4j
@ReadingConverter
@Component
public class JsonToRolesReadingConverter implements Converter<String, Roles> {
    private JsonMapper jsonMapper;

    @Autowired
    public void setJsonMapper(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @Override
    public Roles convert(String source) {
        try {
            RolesDto roles = jsonMapper.readValue(source, RolesDto.class);
            return roles.toEntity();
        } catch (JsonProcessingException e) {
            log.error("Failed to convert json to Roles", e);
            throw new RuntimeException(e);
        }
    }
}
