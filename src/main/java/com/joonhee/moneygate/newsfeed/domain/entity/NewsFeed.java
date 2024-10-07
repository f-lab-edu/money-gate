package com.joonhee.moneygate.newsfeed.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class NewsFeed {
    @Id
    @Column("news_feed_id")
    private Long id;
    @Column("news_feed_key")
    private UUID key;
    @Column("user_id")
    private Long mentorId;
    private String body;
    private ContentStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public NewsFeed(
        Long mentorId,
        String body,
        ContentStatus status
    ) {
        this.key = UUID.randomUUID();
        this.mentorId = mentorId;
        this.body = body;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }

    public Boolean isDeleted() {
        return this.status == ContentStatus.DELETED;
    }


    public NewsFeed updateBody(String body) {
        this.body = body;
        this.updatedAt = LocalDateTime.now();
        return this;
    }

    public NewsFeed delete() {
        this.deletedAt = LocalDateTime.now();
        this.status = ContentStatus.DELETED;
        return this;
    }
}