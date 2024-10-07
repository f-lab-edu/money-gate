package com.joonhee.moneygate.newsfeed.controller;

import com.joonhee.moneygate.newsfeed.domain.service.QueryNewsFeedService;
import com.joonhee.moneygate.newsfeed.dto.response.NewsFeedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class QueryNewsFeedController {
    private final QueryNewsFeedService queryNewsFeedService;

    @GetMapping("/newsfeed")
    public List<NewsFeedResponse> findAllPublicNewsFeed() {
        return queryNewsFeedService.findAllPublic().stream().map(
                newsFeedDetail -> NewsFeedResponse.of(newsFeedDetail))
            .collect(Collectors.toList());
    }
}
