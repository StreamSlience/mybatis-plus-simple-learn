/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : mybatislearn

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2019-12-01 00:52:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for xx_goods
-- ----------------------------
DROP TABLE IF EXISTS `xx_goods`;
CREATE TABLE `xx_goods` (
  `goods_id` varchar(32) NOT NULL DEFAULT '' COMMENT '物料主键',
  `goods_name` varchar(32) NOT NULL COMMENT '物料名称',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者主键',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改者主键',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` varchar(1) DEFAULT NULL COMMENT '逻辑删除标识',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物料信息表';

-- ----------------------------
-- Records of xx_goods
-- ----------------------------
INSERT INTO `xx_goods` VALUES ('fa5254eac06c80bb221e6cf70c2e470a', '我是一个物料修改', null, '2019-11-30 16:51:04', null, '2019-11-30 16:51:32', 'D');
