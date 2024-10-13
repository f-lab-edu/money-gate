CREATE TABLE news_feed
(
    news_feed_id  BIGINT AUTO_INCREMENT NOT NULL COMMENT '인덱싱 컬럼',
    news_feed_key VARCHAR(36)           NOT NULL COMMENT '뉴스피드 식별자',
    user_id       BIGINT                NOT NULL COMMENT '유저 식별자(멘토인 유저)',
    body          TEXT                  NOT NULL COMMENT '뉴스피드 내용',
    status        varchar(16)           NOT NULL COMMENT '뉴스피드 상태: PUBLIC, DELETED, DRAFT',
    created_at    DATETIME              NOT NULL COMMENT '생성일',
    updated_at    DATETIME              NULL COMMENT '수정일',
    deleted_at    DATETIME              NULL COMMENT '삭제일',
    PRIMARY KEY (news_feed_id),
    CONSTRAINT uc_news_feed_key UNIQUE KEY (news_feed_key)
)
    COLLATE = UTF8MB4_UNICODE_CI;
