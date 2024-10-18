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
@Table("news_feed_like")
public class Like {
    @Id
    @Column("like_id")
    private Long id;
    private Long userId;
    private Long newsFeedId;
    private LikeStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;

    @Builder
    private Like(Long id, Long userId, Long newsFeedId, LikeStatus status, LocalDateTime createdAt, LocalDateTime deletedAt) {
        this.id = id;
        this.userId = userId;
        this.newsFeedId = newsFeedId;
        this.status = status;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
    }

    public static Like createLike(Long userId, Long newsFeedId) {
        return Like.builder()
            .userId(userId)
            .newsFeedId(newsFeedId)
            .status(LikeStatus.CREATED)
            .createdAt(LocalDateTime.now())
            .build();
    }

    public Like doOrUndo() {
        if (this.status == LikeStatus.ACTIVE) {
            delete();
            return this;
        }
        this.status = LikeStatus.ACTIVE;
        this.deletedAt = null;
        return this;
    }

    private void delete() {
        this.deletedAt = LocalDateTime.now();
        this.status = LikeStatus.DELETED;
    }

}
