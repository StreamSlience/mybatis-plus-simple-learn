/*
Navicat MySQL Data Transfer

Source Server         : taozhu
Source Server Version : 50626
Source Host           : 192.168.1.151:3316
Source Database       : dev_dely

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2019-12-09 11:37:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for xx_address_info
-- ----------------------------
DROP TABLE IF EXISTS `xx_address_info`;
CREATE TABLE `xx_address_info` (
  `address_id` varchar(32) NOT NULL,
  `address` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xx_address_info
-- ----------------------------
INSERT INTO `xx_address_info` VALUES ('9080b4b071854f92a5f64329a23ec388', '我是一个修改地址');
