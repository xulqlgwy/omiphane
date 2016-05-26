/*
Navicat MySQL Data Transfer

Source Server         : 192.168.85.128-vm-mysql
Source Server Version : 50173
Source Host           : 192.168.85.128:3306
Source Database       : omiphane

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-05-27 00:30:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(64) DEFAULT NULL,
  `device_type` int(10) DEFAULT NULL,
  `device_sn` varchar(128) DEFAULT NULL,
  `device_name` varchar(255) DEFAULT NULL,
  `parent_node_id` int(11) DEFAULT NULL COMMENT '关联的节点id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('1', '1001', '1', 'ADD_QSS111', '车辆终端', null);

-- ----------------------------
-- Table structure for device_data
-- ----------------------------
DROP TABLE IF EXISTS `device_data`;
CREATE TABLE `device_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` int(11) DEFAULT NULL,
  `prop_enum` int(11) DEFAULT NULL COMMENT '属性名定义在 enum_define 表',
  `prop_data` varchar(511) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_data
-- ----------------------------
INSERT INTO `device_data` VALUES ('1', '1001', '1', 'jdjdj');

-- ----------------------------
-- Table structure for device_node_rel
-- ----------------------------
DROP TABLE IF EXISTS `device_node_rel`;
CREATE TABLE `device_node_rel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_node_rel
-- ----------------------------
INSERT INTO `device_node_rel` VALUES ('1', '1001', '101');

-- ----------------------------
-- Table structure for enum_define
-- ----------------------------
DROP TABLE IF EXISTS `enum_define`;
CREATE TABLE `enum_define` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enum_name` varchar(255) DEFAULT NULL,
  `enum_value` varchar(11) DEFAULT NULL,
  `memo` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enum_define
-- ----------------------------
INSERT INTO `enum_define` VALUES ('1', 'NODE_TYPE', 'DEV', '终端');
INSERT INTO `enum_define` VALUES ('2', 'NODE_TYPE', 'COM', '公司');
INSERT INTO `enum_define` VALUES ('3', 'NODE_TYPE', 'NODE', '节点');

-- ----------------------------
-- Table structure for node
-- ----------------------------
DROP TABLE IF EXISTS `node`;
CREATE TABLE `node` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `text` varchar(128) DEFAULT NULL,
  `leaf` varchar(10) DEFAULT NULL COMMENT '是否是子节点',
  `cls` int(11) DEFAULT NULL,
  `icon_cls` varchar(64) DEFAULT NULL COMMENT '图片路径',
  `checked` varchar(10) DEFAULT NULL,
  `page` varchar(64) DEFAULT NULL,
  `node_type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of node
-- ----------------------------
INSERT INTO `node` VALUES ('1', '0', 'aaaa', '0', '1', '', 'false', 'device', null);
INSERT INTO `node` VALUES ('100', '1', 'bbbb', '221', '12', null, 'true', 'device', null);
INSERT INTO `node` VALUES ('101', '100', 'cccc', '1', '2', null, 'false', 'company', null);
INSERT INTO `node` VALUES ('102', '0', 'ddd', '0', '1', '', 'false', null, 'node');
INSERT INTO `node` VALUES ('103', '102', 'deeee', '1', '11', null, 'false', null, 'node');

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
