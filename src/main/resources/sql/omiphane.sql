/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50634
Source Host           : localhost:3306
Source Database       : omiphane

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2016-11-10 00:38:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for device_base
-- ----------------------------
DROP TABLE IF EXISTS `device_base`;
CREATE TABLE `device_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(64) DEFAULT NULL,
  `device_name` varchar(255) DEFAULT NULL,
  `device_typ` tinyint(4) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_base
-- ----------------------------
INSERT INTO `device_base` VALUES ('1', '100001', 'CLD-X-1000001', '1', 'CLD-X-1000001');
INSERT INTO `device_base` VALUES ('2', '100002', 'CLD-X-1000002', '1', 'CLD-X-1000002');

-- ----------------------------
-- Table structure for device_real
-- ----------------------------
DROP TABLE IF EXISTS `device_real`;
CREATE TABLE `device_real` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(64) DEFAULT NULL,
  `speed` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `latitude` double DEFAULT NULL COMMENT '维度',
  `longtitude` double DEFAULT NULL,
  `user_data` varchar(255) DEFAULT NULL,
  `parameter` varchar(1024) DEFAULT NULL COMMENT 'json 参数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_real
-- ----------------------------
INSERT INTO `device_real` VALUES ('1', '100001', '120', '12.3', '30.23652', '120.25656', null, null);
INSERT INTO `device_real` VALUES ('2', '100002', '123', '12.6', '30.99999', '120.4444', null, null);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) DEFAULT NULL,
  `permission_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) NOT NULL,
  `login_name` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `tel_number` varchar(64) DEFAULT NULL,
  `valid_date` datetime DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xulq', 'xulq', '123456', 'xulq', '12344411122', '2016-05-08 17:34:37', null, null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
