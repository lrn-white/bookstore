/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-11-19 12:26:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` varchar(32) DEFAULT NULL,
  `rowid` int(32) NOT NULL AUTO_INCREMENT,
  `bname` varchar(100) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `author` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`rowid`),
  KEY `bname` (`bname`)
) ENGINE=InnoDB AUTO_INCREMENT=3063514 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bookshelf
-- ----------------------------
DROP TABLE IF EXISTS `bookshelf`;
CREATE TABLE `bookshelf` (
  `id` varchar(32) DEFAULT NULL,
  `rowid` int(32) NOT NULL AUTO_INCREMENT,
  `userid` varchar(32) DEFAULT NULL,
  `bookid` varchar(32) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `uname` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`rowid`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `id` varchar(32) DEFAULT NULL,
  `rowid` int(32) NOT NULL AUTO_INCREMENT,
  `bookid` varchar(32) DEFAULT NULL,
  `cname` varchar(100) DEFAULT NULL,
  `cprice` double DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`rowid`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for org_user
-- ----------------------------
DROP TABLE IF EXISTS `org_user`;
CREATE TABLE `org_user` (
  `id` varchar(32) DEFAULT NULL,
  `rowid` int(32) NOT NULL AUTO_INCREMENT,
  `uname` varchar(16) DEFAULT NULL,
  `upassword` varchar(100) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isadmin` int(1) DEFAULT '0',
  PRIMARY KEY (`rowid`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for readrecord
-- ----------------------------
DROP TABLE IF EXISTS `readrecord`;
CREATE TABLE `readrecord` (
  `id` varchar(32) DEFAULT NULL,
  `rowid` int(32) NOT NULL AUTO_INCREMENT,
  `userid` varchar(32) DEFAULT NULL,
  `bookid` varchar(32) DEFAULT NULL,
  `chapterid` varchar(32) DEFAULT NULL,
  `pageNum` int(32) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`rowid`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
