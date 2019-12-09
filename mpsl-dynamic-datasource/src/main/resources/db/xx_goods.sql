/*
Navicat MySQL Data Transfer

Source Server         : StreamSlience
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : mybatispuls

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2019-12-09 11:38:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for xx_goods
-- ----------------------------
DROP TABLE IF EXISTS `xx_goods`;
CREATE TABLE `xx_goods` (
  `goods_id` varchar(32) NOT NULL DEFAULT '' COMMENT '物料主键',
  `goods_name` varchar(32) NOT NULL COMMENT '物料名称',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物料信息表';

-- ----------------------------
-- Records of xx_goods
-- ----------------------------
INSERT INTO `xx_goods` VALUES ('07dae73fdabd4f55d937310421433445', '还是一块煤炭');
INSERT INTO `xx_goods` VALUES ('1be9c8076afed53b99f4d1165e66aa11', '还是一块煤炭');
INSERT INTO `xx_goods` VALUES ('9130ce4bdb8844e416dd0186bf1e6dac', '还是一块煤炭');
