/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : omiphane

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2016-05-25 15:24:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `device`
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(11) NOT NULL auto_increment,
  `device_id` varchar(64) default NULL,
  `device_type` int(10) default NULL,
  `device_sn` varchar(128) default NULL,
  `device_name` varchar(255) default NULL,
  `parent_node_id` int(11) default NULL COMMENT '关联的节点id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------

-- ----------------------------
-- Table structure for `device_data`
-- ----------------------------
DROP TABLE IF EXISTS `device_data`;
CREATE TABLE `device_data` (
  `id` int(11) NOT NULL auto_increment,
  `device_id` int(11) default NULL,
  `prop_enum` int(11) default NULL COMMENT '属性名定义在 enum_define 表',
  `prop_data` varchar(511) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_data
-- ----------------------------

-- ----------------------------
-- Table structure for `enum_define`
-- ----------------------------
DROP TABLE IF EXISTS `enum_define`;
CREATE TABLE `enum_define` (
  `id` int(11) NOT NULL auto_increment,
  `enum_value` int(11) default NULL,
  `enum_name` varchar(255) default NULL,
  `memo` varchar(128) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enum_define
-- ----------------------------

-- ----------------------------
-- Table structure for `node`
-- ----------------------------
DROP TABLE IF EXISTS `node`;
CREATE TABLE `node` (
  `id` int(11) NOT NULL auto_increment,
  `parent_id` int(11) default NULL,
  `text` varchar(128) default NULL,
  `leaf` varchar(10) default NULL COMMENT '是否是子节点',
  `cls` int(11) default NULL,
  `icon_cls` varchar(64) default NULL COMMENT '图片路径',
  `checked` varchar(10) default NULL,
  `page` varchar(64) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of node
-- ----------------------------
INSERT INTO `node` VALUES ('1', '0', 'aaaa', '0', '1', '', 'false', '1');
INSERT INTO `node` VALUES ('100', '1', 'bbbb', '221', '12', null, 'true', '1');
INSERT INTO `node` VALUES ('101', '100', 'cccc', '1', '2', null, 'false', '1,100');
INSERT INTO `node` VALUES ('102', '0', 'ddd', '0', '1', '', 'false', null);
INSERT INTO `node` VALUES ('103', '102', 'deeee', '1', '11', null, 'false', null);

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL auto_increment,
  `role_name` varchar(64) default NULL,
  `permission_name` varchar(64) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `user_name` varchar(64) NOT NULL,
  `login_name` varchar(64) default NULL,
  `password` varchar(64) default NULL,
  `address` varchar(128) default NULL,
  `tel_number` varchar(64) default NULL,
  `valid_date` datetime default NULL,
  `created_date` datetime default NULL,
  `modify_date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xulq', 'xulq', '123456', 'xulq', '12344411122', '2016-05-08 17:34:37', null, null);

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `role_name` varchar(64) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
