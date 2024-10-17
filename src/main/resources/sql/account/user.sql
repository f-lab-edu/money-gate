CREATE TABLE user
(
    user_id       BIGINT AUTO_INCREMENT NOT NULL COMMENT '인덱싱 컬럼',
    email         VARCHAR(100)          NOT NULL COMMENT '로그인 이메일',
    nick_name     VARCHAR(100)          NOT NULL COMMENT '멘토 이름',
    profile_image VARCHAR(255)          NOT NULL COMMENT '프로필 이미지',
    roles         VARCHAR(100)          NOT NULL COMMENT '권한 ex) [NEWS_FEED_WRITER]',
    created_at    DATETIME              NOT NULL COMMENT '생성일',
    updated_at    DATETIME              NULL COMMENT '수정일',
    PRIMARY KEY (user_id),
    CONSTRAINT uc_mentor_email UNIQUE KEY (email),
    CONSTRAINT uc_mentor_nick_name UNIQUE KEY (nick_name)
)
    COLLATE = UTF8MB4_UNICODE_CI;