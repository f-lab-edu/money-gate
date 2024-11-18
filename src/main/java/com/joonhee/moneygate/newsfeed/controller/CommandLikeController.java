package com.joonhee.moneygate.newsfeed.controller;

import com.joonhee.moneygate.common.httpresponse.HttpApiResponse;
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
    public HttpApiResponse<LikeResponse> addOrSubtractLike(
        @PathVariable String newsFeedKey,
        @RequestParam Long userId
    ) {
        commandLikeService.doLike(userId, newsFeedKey);
        return HttpApiResponse.of(LikeResponse.ok());
    }

    @PostMapping("/newsfeed/{newsFeedKey}/undo-like")
    public HttpApiResponse<LikeResponse> undoLike(
        @PathVariable String newsFeedKey,
        @RequestParam Long userId
    ) {
        commandLikeService.undoLike(userId, newsFeedKey);
        return HttpApiResponse.of(LikeResponse.ok());
    }
}
