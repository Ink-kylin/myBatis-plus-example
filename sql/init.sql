CREATE TABLE user_info
(
    user_id BIGINT AUTO_INCREMENT COMMENT '编号'
        PRIMARY KEY,
    name    VARCHAR(20) NULL COMMENT '用户名称',
    age     INT         NULL COMMENT '年龄',
    grade   INT         NULL COMMENT '学历',
    CONSTRAINT user_user_id_index
        UNIQUE (user_id)
);

