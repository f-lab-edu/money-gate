package com.joonhee.moneygate.newsfeed.controller;

import com.joonhee.moneygate.common.httpresponse.HttpApiResponse;
import com.joonhee.moneygate.common.SliceContent;
import com.joonhee.moneygate.newsfeed.domain.service.QueryNewsFeedService;
import com.joonhee.moneygate.newsfeed.dto.response.NewsFeedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QueryNewsFeedController {
    private final QueryNewsFeedService queryNewsFeedService;

    @GetMapping("/newsfeed")
    public HttpApiResponse<SliceContent<NewsFeedResponse>> findAllPublicNewsFeeds(
        @RequestParam(value = "size", required = false, defaultValue = "10") int size,
        @RequestParam(value = "nextCursor", required = false) String nextCursor
    ) {
        return HttpApiResponse.of(NewsFeedResponse.of(queryNewsFeedService.findAllPublicSlice(size, nextCursor)));
    }
}
