/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : jumper

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 21/04/2020 16:06:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for url_mapper
-- ----------------------------
DROP TABLE IF EXISTS `url_mapper`;
CREATE TABLE `url_mapper` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(2048) NOT NULL,
  `encoded` varchar(8) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_view_time` datetime DEFAULT NULL,
  `view_count` int(11) NOT NULL DEFAULT '0',
  `has_password` tinyint(1) NOT NULL,
  `password` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `encoded` (`encoded`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
