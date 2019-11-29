/*
Navicat MySQL Data Transfer

Source Server         : StreamSlience
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : mybatispuls

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2019-11-29 14:35:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for xx_logical_delete
-- ----------------------------
DROP TABLE IF EXISTS `xx_logical_delete`;
CREATE TABLE `xx_logical_delete` (
  `logical_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `deleted` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`logical_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of xx_logical_delete
-- ----------------------------
INSERT INTO `xx_logical_delete` VALUES ('1200284902791925762', null, '2019-11-29 05:26:35', 'D');
INSERT INTO `xx_logical_delete` VALUES ('1200302236155711489', null, '2019-11-29 06:35:27', 'A');
