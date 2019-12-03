/*
Navicat MySQL Data Transfer

Source Server         : StreamSlience
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : mybatispuls

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2019-12-03 13:55:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for xx_goods
-- ----------------------------
DROP TABLE IF EXISTS `xx_goods`;
CREATE TABLE `xx_goods` (
  `goods_id` varchar(32) NOT NULL DEFAULT '' COMMENT '物料主键',
  `warehouse_id` varchar(32) DEFAULT NULL COMMENT '仓库主键',
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
INSERT INTO `xx_goods` VALUES ('06460e75efb2c4842604551a8d3aa91f', null, '物料10', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('0a60e7871abe5735b1912e6961cafcdb', null, '物料5', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('0bcfa9a05a18ce57e42bd682bee320f9', null, '物料4', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('17a755170e625084d863474f1df220ea', null, '物料1', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('192c4e6c66ca9adaeda9ac8803c83dcf', null, '物料9', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('227b2b07d85a1a48c698988d759b98bd', null, '物料9', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('299a636ee922176603910be1fb8c9342', null, '物料2', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('325dd32691b2a67a00127cf51f34a90f', null, '物料0', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('33e4ae6f1493fa0ddf934f878aa44eb9', null, '物料5', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('3dcd644082b333968118c09ef284c938', null, '物料13', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('4464352ec944a54347707f5fc76d6efe', null, '物料3', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('5664360a1a567442e921d35a3cde21f1', null, '物料12', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('5cd5bf2ca010703b37994e35d2d03012', null, '物料17', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('5dc8cfdeec6630821f60331064ac836d', null, '物料19', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('63e1bb07472a540bff8e26b5dff77113', null, '物料1', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('66caf2e2e5bf08205e900e758897f5d0', null, '物料8', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('8016a2451adc0a1637de5fee96cff519', null, '物料17', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('86777c9597bcdd3478d64655d2225ef8', null, '物料12', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('87cedb9c1e3003081eef97419febb63b', null, '物料10', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('90e810fda8dbc381fde0f2a941f0d9a9', null, '物料14', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('91a49d61af6c580de4889419bbeafdc5', null, '物料0', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('925278e445c0bcde6e90df31b91a15ce', null, '物料3', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('934964617b689c98a48a69609f68a7f4', null, '物料2', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('93535f667ea0fe48590531128cdd2cbb', null, '物料14', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('960ab397f1c1d1743bba94cc9e1348d1', null, '物料11', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('9afe1d346e92dd7874f88dfe5edb58bc', null, '物料8', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('af48c7853d693aa47b07db8d3b3ecdf1', null, '物料6', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('b543d16917adb71e188d7600e833f71f', null, '物料15', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('be8b2819c1175bc6abd7c387ae7b8b11', null, '物料15', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('c8e27482028876df578f25f8a614fc17', null, '物料7', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('c96fcd469a065230546143be468c42e1', null, '物料16', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('cac61243129a01a5475e79aa2eb1b508', null, '物料11', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('d0278366a0991239bda356495291664a', null, '物料18', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('d2c5315258338aa0e6e5ea47fe38435f', null, '物料13', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('d2f1eae5190a39f52b25db27846ee4ac', null, '物料4', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('d33ec84fd8200cfbd8112ee23e911d1f', null, '物料16', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('dc71c6d5cfe8042852e7904124348158', null, '物料18', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('de4abb0deb706a038e2311e2623b0f40', null, '物料7', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('e66b871e421aef1b69c4c7f997167451', null, '物料19', null, null, null, null, 'D');
INSERT INTO `xx_goods` VALUES ('e9a7da0aa3e358f5c9890dcc8172b42d', null, '物料6', null, null, null, null, 'D');
