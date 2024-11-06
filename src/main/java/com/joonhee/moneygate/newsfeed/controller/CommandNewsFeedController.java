package com.joonhee.moneygate.newsfeed.controller;

import com.joonhee.moneygate.common.httpresponse.HttpApiResponse;
import com.joonhee.moneygate.newsfeed.domain.service.CommandNewsFeedService;
import com.joonhee.moneygate.newsfeed.dto.request.CreateNewsFeedRequest;
import com.joonhee.moneygate.newsfeed.dto.request.UpdateNewsFeedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommandNewsFeedController {
    private final CommandNewsFeedService commandNewsFeedService;

    @PostMapping("/newsfeed")
    public HttpApiResponse<String> createNewsFeed(@RequestBody CreateNewsFeedRequest request) {
        return HttpApiResponse.of(commandNewsFeedService.createNewsFeedByPublic(request.mentorId(), request.body()).getKey());
    }

    @PutMapping("/newsfeed/{newsFeedKey}")
    public HttpApiResponse<String> updateNewsFeed(
        @PathVariable String newsFeedKey,
        @RequestBody UpdateNewsFeedRequest request
    ) {
        return HttpApiResponse.of(commandNewsFeedService.updateNewsFeed(newsFeedKey, request.body()).getKey());
    }

    @DeleteMapping("/newsfeed/{newsFeedKey}")
    public HttpApiResponse<String> deleteNewsFeed(@PathVariable String newsFeedKey) {
        return HttpApiResponse.of(commandNewsFeedService.deleteNewsFeed(newsFeedKey).getKey());
    }
}
