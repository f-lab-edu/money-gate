package com.joonhee.moneygate.healthcheck.application.controller;

import com.joonhee.moneygate.newsfeed.domain.service.CommandCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthCheckController {
    private final CommandCommentService commandCommentService;

    @GetMapping("/")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok("ok");
    }

}
