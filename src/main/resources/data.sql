CREATE DATABASE `user_status` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE `user_status`;

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `usr_stat_record`;

CREATE TABLE `usr_stat_record`
(
    `id`          int(10) NOT NULL AUTO_INCREMENT,
    `user_name`   varchar(50) DEFAULT NULL,
    `status`      int(10) DEFAULT NULL,
    `create_time` timestamp NULL DEFAULT NULL,
    `update_time` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `usrname_status_idx` (`user_name`, `status`) USING BTREE,
    KEY           `createtime_idx` (`create_time`) USING BTREE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4
COLLATE=utf8mb4_unicode_ci
ROW_FORMAT=COMPACT;