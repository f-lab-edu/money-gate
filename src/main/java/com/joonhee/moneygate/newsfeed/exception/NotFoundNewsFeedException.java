package com.joonhee.moneygate.newsfeed.exception;

public class NotFoundNewsFeedException extends IllegalArgumentException {
    public NotFoundNewsFeedException(String newsFeedKey) {
        super("NewsFeed is not found | key: " + newsFeedKey);
    }
}
