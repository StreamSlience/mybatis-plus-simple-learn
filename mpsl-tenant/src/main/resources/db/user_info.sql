/*
Navicat MySQL Data Transfer

Source Server         : StreamSlience
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : mybatispuls

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2019-12-09 16:13:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tenant_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('981b7d75f4f63a4954774a176d8f0ead', '呵呵', '86c6c58b4c3941b2a2a75d0f8aff59e5');
INSERT INTO `user_info` VALUES ('b16a0ed52303507c4f501612bf72a95c', '呵呵', '4315bb8ade2a45629b5698dd11678206');
INSERT INTO `user_info` VALUES ('ba189a2626a3187019a68aaf990d10b6', '呵呵', '74e127594a7c40228a69101c261c9039');
INSERT INTO `user_info` VALUES ('b7982f7fe378750c90cab64d6204401b', '呵呵', '13a3d42366a54b0d91575d3d0355998d');
INSERT INTO `user_info` VALUES ('beb6fe23dc9afbbd53eebd68184e3e43', '呵呵', 'fc0c4a2fdbab4c25aeefef9766becddc');
INSERT INTO `user_info` VALUES ('a8822c2e498b697c60fab1d0077d75ba', '呵呵', '1ecb468d1a104c1b904ba91770bf4113');
