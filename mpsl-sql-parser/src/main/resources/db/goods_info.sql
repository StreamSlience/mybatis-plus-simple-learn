/*
Navicat MySQL Data Transfer

Source Server         : StreamSlience
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : mybatispuls

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2019-12-09 21:04:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info` (
  `goods_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goods_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
