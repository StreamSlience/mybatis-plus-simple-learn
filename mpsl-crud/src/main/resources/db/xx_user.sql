/*
Navicat MySQL Data Transfer

Source Server         : StreamSlience
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : mybatispuls

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2019-12-03 11:22:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for xx_user
-- ----------------------------
DROP TABLE IF EXISTS `xx_user`;
CREATE TABLE `xx_user` (
  `user_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '物料主键',
  `user_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL COMMENT '用户年龄',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of xx_user
-- ----------------------------
INSERT INTO `xx_user` VALUES ('003b4c7450d74eecb1df429f547aad32', '我是一个真用户', '999');
INSERT INTO `xx_user` VALUES ('0044910d6bd72b8d84a97a17c48cff29', '我是一个真用户', '999');
INSERT INTO `xx_user` VALUES ('0d40ab89efc62f58cdbe48185a4d3a25', '我是一个真用户', '999');
INSERT INTO `xx_user` VALUES ('11d3e440e4e5ff9176ee0a6021ee1387', '我是一个真用户', '999');
INSERT INTO `xx_user` VALUES ('4faef602c6b854c99ebacd225387f157', '我是一个真用户', '999');
INSERT INTO `xx_user` VALUES ('65877ac39e64a808037dbd8b3823e924', '我是一个真用户', '999');
INSERT INTO `xx_user` VALUES ('69b618b6bd709a6429f45ff306108e6d', '我是一个真用户', '999');
INSERT INTO `xx_user` VALUES ('771f30e202472e52821428a68d28297c', '我是一个真用户', '999');
INSERT INTO `xx_user` VALUES ('8d6b46e2c40d414d9bd1bcdab424c82d', '我是一个真用户', '999');
INSERT INTO `xx_user` VALUES ('95e4f40c8986d2cb6710cb4fce28d469', '我是一个真用户', '999');
INSERT INTO `xx_user` VALUES ('a2334fb7aa8d407fb5eb42b07ede32c1', '我是一个真用户', '999');
INSERT INTO `xx_user` VALUES ('a2e19c045b81e1435917b359a184622b', '我是一个真用户', '999');
INSERT INTO `xx_user` VALUES ('aa6fe42be25499fec4c4580f77fdaaa2', '我是一个真用户', '999');
INSERT INTO `xx_user` VALUES ('b0253d9a01fb4e48eff7857108f0d5d2', '我是一个真用户', '999');
INSERT INTO `xx_user` VALUES ('f475117f55b4911d0c27d2f46532235e', '我是一个真用户', '999');
