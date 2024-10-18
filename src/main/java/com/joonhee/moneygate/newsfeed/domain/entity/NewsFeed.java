package com.joonhee.moneygate.newsfeed.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
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

    @Builder
    private NewsFeed(
        Long id,
        String key,
        Long mentorId,
        String body,
        ContentOpenStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt
    ) {
        this.id = id;
        this.key = key;
        this.mentorId = mentorId;
        this.body = body;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static NewsFeed createNewsFeedByPublic(Long mentorId, String body) {
        return NewsFeed.builder()
            .key(UUID.randomUUID().toString())
            .mentorId(mentorId)
            .body(body)
            .status(ContentOpenStatus.PUBLIC)
            .createdAt(LocalDateTime.now())
            .build();
    }

    public static NewsFeed createNewsFeedByDraft(Long mentorId, String body) {
        return NewsFeed.builder()
            .key(UUID.randomUUID().toString())
            .mentorId(mentorId)
            .body(body)
            .status(ContentOpenStatus.DRAFT)
            .createdAt(LocalDateTime.now())
            .build();
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

    public Like doOrUndoLike(Like like) {
        return like.doOrUndo();
    }
}