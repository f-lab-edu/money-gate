CREATE TABLE news_feed_comment
(
    comment_id   BIGINT AUTO_INCREMENT COMMENT '인덱싱 컬럼',
    user_id      BIGINT      NOT NULL COMMENT '유저 식별자',
    news_feed_id BIGINT      NOT NULL COMMENT '뉴스피드 식별자',
    body         TEXT        NOT NULL COMMENT '뉴스피드 댓글 내용',
    status       VARCHAR(16) NOT NULL COMMENT '뉴스피드 댓글 상태: PUBLIC, DELETED, DRAFT',
    created_at   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    updated_at   TIMESTAMP   NULL COMMENT '수정일',
    deleted_at   TIMESTAMP   NULL COMMENT '삭제일',
    PRIMARY KEY (comment_id)
) COLLATE = UTF8MB4_UNICODE_CI;