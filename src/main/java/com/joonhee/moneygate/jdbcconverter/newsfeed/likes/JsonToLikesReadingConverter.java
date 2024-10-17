package com.joonhee.moneygate.jdbcconverter.newsfeed.likes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joonhee.moneygate.newsfeed.domain.dto.LikesDto;
import com.joonhee.moneygate.newsfeed.domain.entity.Likes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class JsonToLikesReadingConverter implements Converter<String, Likes> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Likes convert(String source) {
        try {
            LikesDto likes = objectMapper.readValue(source, LikesDto.class);
            return likes.toEntity();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
