package com.joonhee.moneygate.jdbcconverter.account.roles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joonhee.moneygate.account.domain.dto.RolesDto;
import com.joonhee.moneygate.account.domain.entity.Roles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@Slf4j
@ReadingConverter
public class JsonToRolesReadingConverter implements Converter<String, Roles> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public Roles convert(String source) {
        try {
            RolesDto roles = objectMapper.readValue(source, RolesDto.class);
            return roles.toEntity();
        } catch (JsonProcessingException e) {
            log.error("Failed to convert json to Roles", e);
            throw new RuntimeException(e);
        }
    }
}
