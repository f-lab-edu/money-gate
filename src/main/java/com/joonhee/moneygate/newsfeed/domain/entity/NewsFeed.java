package com.joonhee.moneygate.newsfeed.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;
import java.util.List;
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
    private Likes likes;
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
        Likes likes,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt
    ) {
        this.id = id;
        this.key = key;
        this.mentorId = mentorId;
        this.body = body;
        this.status = status;
        this.likes = likes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static NewsFeed createNewsFeedByPublic(Long mentorId, String body) {
        return NewsFeed.builder()
            .key(UUID.randomUUID().toString())
            .mentorId(mentorId)
            .body(body)
            .likes(new Likes())
            .status(ContentOpenStatus.PUBLIC)
            .createdAt(LocalDateTime.now())
            .build();
    }

    public static NewsFeed createNewsFeedByDraft(Long mentorId, String body) {
        return NewsFeed.builder()
            .key(UUID.randomUUID().toString())
            .mentorId(mentorId)
            .body(body)
            .likes(new Likes())
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

    public List<Long> addOrSubtractLike(Like like) {
        return this.likes.addOrSubtract(like);
    }
}