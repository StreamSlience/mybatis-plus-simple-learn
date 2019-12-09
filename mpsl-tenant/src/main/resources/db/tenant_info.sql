/*
Navicat MySQL Data Transfer

Source Server         : StreamSlience
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : mybatispuls

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2019-12-09 16:13:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info` (
  `tenant_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `tenant_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tenant_info` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
INSERT INTO `tenant_info` VALUES ('3fc8438674904e61a32ff1a2e2ceebc9', '我是一个租户', null);
INSERT INTO `tenant_info` VALUES ('70b7bb35916f4396aa34f36d43ede38e', '我是一个租户', null);
