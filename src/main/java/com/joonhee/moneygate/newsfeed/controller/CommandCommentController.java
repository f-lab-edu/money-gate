package com.joonhee.moneygate.newsfeed.controller;

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
    public Long createCommentByPublic(@PathVariable String newsFeedKey, @RequestBody CreateCommentRequest request) {
        return commandCommentService.createCommentByPublic(request.userId(), newsFeedKey, request.body()).getId();
    }

    @PutMapping("/comment/{commentId}")
    public Long updateComment(@PathVariable Long commentId, @RequestBody UpdateCommentRequest request) {
        return commandCommentService.update(commentId, request.body()).getId();
    }

    @DeleteMapping("/comment/{commentId}")
    public Long deleteComment(@PathVariable Long commentId) {
        return commandCommentService.delete(commentId).getId();
    }
}
