/*
Navicat MySQL Data Transfer

Source Server         : StreamSlience
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : mybatispuls

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2019-11-28 22:01:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for xx_user_info
-- ----------------------------
DROP TABLE IF EXISTS `xx_user_info`;
CREATE TABLE `xx_user_info` (
  `user_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `user_age` int(10) DEFAULT NULL,
  `user_duty` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '职务',
  `user_email` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_gender` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '性别',
  `manager_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modified_user_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `deleted` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '逻辑删除标识',
  `user_nationality` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户国籍',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of xx_user_info
-- ----------------------------
INSERT INTO `xx_user_info` VALUES ('1', '王清芬(测试)', '20', null, 'wangqingfeng@qq.com', 'M', null, '2019-10-08 21:30:23', '2019-11-28 21:51:54', null, null, 'D', 'JAPAN');
INSERT INTO `xx_user_info` VALUES ('2', '张小泉', '18', 'DIRVER', 'zhangxaioquan@qq.com', 'M', '1', '2019-10-08 21:30:50', '2019-11-28 21:50:55', null, null, 'A', 'CHINA');
INSERT INTO `xx_user_info` VALUES ('3', '王二破', '20', null, 'wangerpou@qq.com', 'F', '1', '2019-10-09 12:59:05', '2019-11-28 21:51:59', null, null, 'A', 'CHINA');
INSERT INTO `xx_user_info` VALUES ('4', '沈泽庆', '24', null, 'shenzeqing@qq.com', 'F', '2', '2019-10-15 16:39:48', '2019-11-28 21:52:01', null, null, 'A', 'CHINA');
INSERT INTO `xx_user_info` VALUES ('5', '彭宇来', '27', null, 'pengyulai@qq.com', 'M', '2', '2019-10-15 16:40:33', '2019-11-28 21:52:03', null, null, 'A', 'CHINA');
INSERT INTO `xx_user_info` VALUES ('6', '孙金超', '18', null, 'sunjingchao@qq.com', 'M', '2', '2019-10-15 16:41:17', '2019-11-28 21:52:04', null, null, 'A', 'CHINA');
INSERT INTO `xx_user_info` VALUES ('7', '吴郭炎', '27', null, 'wuguopyan@qq.com', 'F', '2', '2019-10-21 13:07:03', '2019-11-28 21:52:06', null, null, 'A', 'JAPAN');
INSERT INTO `xx_user_info` VALUES ('8', '章子怡', '40', null, 'zahngziyi@qq.com', 'F', null, '2019-10-21 13:08:25', '2019-11-28 21:52:08', null, null, 'A', 'MONGOLIA');
INSERT INTO `xx_user_info` VALUES ('9', '张议', '35', null, 'zhangyi@qq.com', 'F', null, '2019-10-21 13:09:08', '2019-11-28 21:52:11', null, null, 'A', 'JAPAN');
