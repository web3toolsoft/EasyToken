/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80029 (8.0.29)
 Source Host           : localhost:3306
 Source Schema         : mybatis_sample

 Target Server Type    : MySQL
 Target Server Version : 80029 (8.0.29)
 File Encoding         : 65001

 Date: 07/05/2023 15:21:01
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

CREATE
DATABASE `mybatis_sample` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ;

USE
`mybatis_sample`;

-- ----------------------------
-- Table structure for test_user
-- ----------------------------
DROP TABLE IF EXISTS `test_user`;
CREATE TABLE `test_user`
(
    `id`           int                                     NOT NULL AUTO_INCREMENT COMMENT '系统用户标识',
    `roles`        varchar(500) COLLATE utf8mb4_general_ci NOT NULL COMMENT '系统用户所属角色集合(role_id以英文逗号分隔)',
    `account`      varchar(64) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '系统用户账号',
    `password`     varchar(64) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '系统用户密码',
    `salt`         varchar(50) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '加盐',
    `name`         varchar(50) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '系统用户姓名',
    `email`        varchar(64) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '系统用户电子邮箱',
    `telephone`    varchar(36) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '系统用户用户电话号码,多个用英文逗号分开',
    `status`       tinyint                                 NOT NULL DEFAULT '1' COMMENT '系统用户的状态,1表示启用,0表示禁用,默认为1,其他保留',
    `comment`      varchar(50) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '系统用户备注',
    `gmt_created`  timestamp                               NOT NULL DEFAULT '2014-01-01 01:01:01' COMMENT '系统用户记录创建时间',
    `gmt_modified` timestamp                               NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统用户记录更新时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `test_user_01`;
CREATE TABLE `test_user_01`
(
    `id`           int                                     NOT NULL AUTO_INCREMENT COMMENT '系统用户标识',
    `roles`        varchar(500) COLLATE utf8mb4_general_ci NOT NULL COMMENT '系统用户所属角色集合(role_id以英文逗号分隔)',
    `account`      varchar(64) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '系统用户账号',
    `password`     varchar(64) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '系统用户密码',
    `salt`         varchar(50) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '加盐',
    `name`         varchar(50) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '系统用户姓名',
    `email`        varchar(64) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '系统用户电子邮箱',
    `telephone`    varchar(36) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '系统用户用户电话号码,多个用英文逗号分开',
    `status`       tinyint                                 NOT NULL DEFAULT '1' COMMENT '系统用户的状态,1表示启用,0表示禁用,默认为1,其他保留',
    `comment`      varchar(50) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '系统用户备注',
    `gmt_created`  timestamp                               NOT NULL DEFAULT '2014-01-01 01:01:01' COMMENT '系统用户记录创建时间',
    `gmt_modified` timestamp                               NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统用户记录更新时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

SET
FOREIGN_KEY_CHECKS = 1;
