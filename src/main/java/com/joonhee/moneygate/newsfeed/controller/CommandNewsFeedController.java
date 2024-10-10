package com.joonhee.moneygate.newsfeed.controller;

import com.joonhee.moneygate.newsfeed.domain.service.CommandNewsFeedService;
import com.joonhee.moneygate.newsfeed.dto.request.CreateNewsFeedRequest;
import com.joonhee.moneygate.newsfeed.dto.request.UpdateNewsFeedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CommandNewsFeedController {
    private final CommandNewsFeedService commandNewsFeedService;

    @PostMapping("/newsfeed")
    public String createNewsFeed(@RequestBody CreateNewsFeedRequest request) {
        return commandNewsFeedService.createNewsFeedByPublic(request.mentorId(), request.body()).getKey();
    }

    @PutMapping("/newsfeed/{newsFeedKey}")
    public String updateNewsFeed(
        @PathVariable String newsFeedKey,
        @RequestBody UpdateNewsFeedRequest request
    ) {
        return commandNewsFeedService.updateNewsFeed(newsFeedKey, request.body()).getKey();
    }

    @DeleteMapping("/newsfeed/{newsFeedKey}")
    public String deleteNewsFeed(@PathVariable String newsFeedKey) {
        return commandNewsFeedService.deleteNewsFeed(newsFeedKey).getKey();
    }
}
