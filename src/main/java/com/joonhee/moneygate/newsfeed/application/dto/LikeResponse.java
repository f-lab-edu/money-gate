package com.joonhee.moneygate.newsfeed.application.dto;

public record LikeResponse(String status) {
    public static LikeResponse ok() {
        return new LikeResponse("ok");
    }
}
