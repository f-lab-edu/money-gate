package com.joonhee.moneygate.newsfeed.domain.dto;

import com.joonhee.moneygate.newsfeed.domain.entity.Likes;

import java.util.List;


public record LikesDto(
    List<Long> userIds
) {
    public Likes toEntity() {
        return new Likes(userIds);
    }
}
