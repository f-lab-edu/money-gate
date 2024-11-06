package com.joonhee.moneygate.newsfeed.controller;

import com.joonhee.moneygate.common.HttpApiResponse;
import com.joonhee.moneygate.newsfeed.domain.service.CommandCommentService;
import com.joonhee.moneygate.newsfeed.dto.request.CreateCommentRequest;
import com.joonhee.moneygate.newsfeed.dto.request.UpdateCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommandCommentController {
    private final CommandCommentService commandCommentService;

    @PostMapping("/newsfeed/{newsFeedKey}/comment")
    public HttpApiResponse<Long> createCommentByPublic(@PathVariable String newsFeedKey, @RequestBody CreateCommentRequest request) {
        return HttpApiResponse.of(commandCommentService.createCommentByPublic(request.userId(), newsFeedKey, request.body()).getId());
    }

    @PutMapping("/comment/{commentId}")
    public HttpApiResponse<Long> updateComment(@PathVariable Long commentId, @RequestBody UpdateCommentRequest request) {
        return HttpApiResponse.of(commandCommentService.update(commentId, request.body()).getId());
    }

    @DeleteMapping("/comment/{commentId}")
    public HttpApiResponse<Long> deleteComment(@PathVariable Long commentId) {
        return HttpApiResponse.of(commandCommentService.delete(commentId).getId());
    }
}
