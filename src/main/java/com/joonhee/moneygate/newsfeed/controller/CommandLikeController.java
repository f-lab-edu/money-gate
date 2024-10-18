package com.joonhee.moneygate.newsfeed.controller;

import com.joonhee.moneygate.newsfeed.application.dto.LikeResponse;
import com.joonhee.moneygate.newsfeed.domain.service.CommandLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommandLikeController {
    private final CommandLikeService commandLikeService;

    @PostMapping("/newsfeed/{newsFeedKey}/like")
    public LikeResponse addOrSubtractLike(
        @PathVariable String newsFeedKey,
        @RequestParam Long userId
    ) {
        commandLikeService.addOrSubtract(userId, newsFeedKey);
        return LikeResponse.ok();
    }
}
