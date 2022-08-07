/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.146.129
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : 192.168.146.129:3306
 Source Schema         : actual-combat

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 05/12/2019 22:59:44
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          varchar(32)  NOT NULL COMMENT 'id',
    `deletion`    int(1) NOT NULL DEFAULT '0' COMMENT '删除标注，0：未删除，1：已删除',
    `create_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `user_name`   varchar(255) NOT NULL COMMENT '用户名',
    `password`    varchar(255) NOT NULL COMMENT '密码',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

SET
FOREIGN_KEY_CHECKS = 1;
