/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50547
Source Host           : 127.0.0.1:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2019-01-07 21:00:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for addressbook
-- ----------------------------
DROP TABLE IF EXISTS `addressbook`;
CREATE TABLE `addressbook` (
  `abId` int(10) unsigned NOT NULL,
  `abName` varchar(64) NOT NULL,
  `abMobile` char(13) NOT NULL,
  PRIMARY KEY (`abId`),
  UNIQUE KEY `abName` (`abName`,`abMobile`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bakcuprecord
-- ----------------------------
DROP TABLE IF EXISTS `bakcuprecord`;
CREATE TABLE `bakcuprecord` (
  `brId` int(10) unsigned NOT NULL,
  `abId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`brId`,`abId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(16) NOT NULL,
  `user_pwd` char(32) NOT NULL,
  `user_safe` char(32) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user` (`user_name`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userset
-- ----------------------------
DROP TABLE IF EXISTS `userset`;
CREATE TABLE `userset` (
  `userId` int(10) unsigned NOT NULL,
  `usBackupAuto` tinyint(4) NOT NULL,
  `usUpdataAuto` int(11) NOT NULL,
  `usAutoInterval` tinyint(4) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
