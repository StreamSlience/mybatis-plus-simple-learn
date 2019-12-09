/*
Navicat MySQL Data Transfer

Source Server         : StreamSlience
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : mybatispuls

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2019-12-09 21:04:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address_info
-- ----------------------------
DROP TABLE IF EXISTS `address_info`;
CREATE TABLE `address_info` (
  `address_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
