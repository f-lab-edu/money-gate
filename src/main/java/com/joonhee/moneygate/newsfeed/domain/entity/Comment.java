package com.joonhee.moneygate.newsfeed.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Builder
@Table("news_feed_comment")
public class Comment {
    @Id
    @Column("comment_id")
    private Long id;
    @Column("user_id")
    private Long userId;
    @Column("news_feed_id")
    private Long newsFeedId;
    private String body;
    private CommentStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public Comment(
        Long id,
        Long userId,
        Long newsFeedId,
        String body,
        CommentStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt
    ) {
        this.id = id;
        this.userId = userId;
        this.newsFeedId = newsFeedId;
        this.body = body;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    private Comment(
        Long userId,
        Long newsFeedId,
        String body,
        CommentStatus status
    ) {
        this.userId = userId;
        this.newsFeedId = newsFeedId;
        this.body = body;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }

    public static Comment createCommentByPublic(Long userId, Long newsFeedId, String body) {
        return new Comment(userId, newsFeedId, body, CommentStatus.PUBLIC);
    }

    public static Comment createCommentByDraft(Long userId, Long newsFeedId, String body) {
        return new Comment(userId, newsFeedId, body, CommentStatus.DRAFT);
    }

    public Comment updateBody(String body) {
        this.body = body;
        this.updatedAt = LocalDateTime.now();
        return this;
    }

    public Comment delete() {
        this.deletedAt = LocalDateTime.now();
        this.status = CommentStatus.DELETED;
        return this;
    }
}
