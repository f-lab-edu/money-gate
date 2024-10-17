package com.joonhee.moneygate.jdbcconverter.newsfeed.likes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joonhee.moneygate.newsfeed.domain.entity.Likes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class LikesToJsonWritingConverter implements Converter<Likes, String> {
    private  final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convert(Likes source) {
        try{
            return objectMapper.writeValueAsString(source.toDto());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
