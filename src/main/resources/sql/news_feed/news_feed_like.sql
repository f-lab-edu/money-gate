CREATE TABLE news_feed_like
(
    like_id      BIGINT AUTO_INCREMENT NOT NULL COMMENT '인덱싱 컬럼',
    user_id      BIGINT                NOT NULL COMMENT '좋아요한 유저 식별자',
    news_feed_id BIGINT                NOT NULL COMMENT '뉴스피드 식별자',
    status       ENUM ('CREATED','ACTIVE', 'DELETED') DEFAULT 'ACTIVE' COMMENT '상태',
    created_at   DATETIME              NOT NULL COMMENT '생성일',
    deleted_at   DATETIME              NULL COMMENT '삭제일',
    PRIMARY KEY (like_id),
    CONSTRAINT uc_like_user_id_news_feed_id UNIQUE KEY (user_id, news_feed_id)
)
    COMMENT '뉴스피드 좋아요'
    COLLATE = UTF8MB4_UNICODE_CI;
