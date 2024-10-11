package com.joonhee.moneygate.newsfeed.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsFeed {
    @Id
    @Column("news_feed_id")
    private Long id;
    @Column("news_feed_key")
    private String key;
    @Column("user_id")
    private Long mentorId;
    private String body;
    private ContentOpenStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private NewsFeed(
        Long mentorId,
        String body,
        ContentOpenStatus status
    ) {
        this.key = UUID.randomUUID().toString();
        this.mentorId = mentorId;
        this.body = body;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }

    public static NewsFeed createNewsFeedByPublic(Long mentorId, String body) {
        return new NewsFeed(mentorId, body, ContentOpenStatus.PUBLIC);
    }

    public static NewsFeed createNewsFeedByDraft(Long mentorId, String body) {
        return new NewsFeed(mentorId, body, ContentOpenStatus.DRAFT);
    }

    public Boolean isDeleted() {
        return this.status == ContentOpenStatus.DELETED;
    }


    public NewsFeed updateBody(String body) {
        this.body = body;
        this.updatedAt = LocalDateTime.now();
        return this;
    }

    public NewsFeed delete() {
        this.deletedAt = LocalDateTime.now();
        this.status = ContentOpenStatus.DELETED;
        return this;
    }
}