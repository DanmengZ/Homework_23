/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50736
Source Host           : localhost:3306
Source Database       : sys

Target Server Type    : MYSQL
Target Server Version : 50736
File Encoding         : 65001

Date: 2023-08-02 09:39:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `recordId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cart
-- ----------------------------
INSERT INTO `t_cart` VALUES ('15', '2', '11', '26', '3');
INSERT INTO `t_cart` VALUES ('16', '2', '1', '26', '4');
INSERT INTO `t_cart` VALUES ('17', '3', '3', '26', '4');
INSERT INTO `t_cart` VALUES ('18', '4', '5', '26', '4');
INSERT INTO `t_cart` VALUES ('19', '3', '3', '27', '5');
INSERT INTO `t_cart` VALUES ('20', '4', '1', '27', '5');
INSERT INTO `t_cart` VALUES ('21', '5', '6', '27', '5');
INSERT INTO `t_cart` VALUES ('22', '1', '1', '26', '6');
INSERT INTO `t_cart` VALUES ('24', '2', '1', '26', '6');

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userLevel` enum('金牌客户','银牌客户','铜牌客户') DEFAULT NULL,
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `totalConsumption` decimal(10,2) DEFAULT NULL,
  `phoneNumber` varchar(15) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('10', '铜牌客户', '2023-07-31 16:23:14', '41.50', '123', '123', '26');
INSERT INTO `t_customer` VALUES ('11', '铜牌客户', '2023-08-02 08:41:03', '0.00', '333', '333@qq.com', '27');

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(255) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `productionDate` date DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `purchasePrice` decimal(10,2) DEFAULT NULL,
  `retailPrice` decimal(10,2) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('1', '旺旺雪饼', '旺旺', '2023-08-01', 'WW', '3.50', '6.00', '1');
INSERT INTO `t_product` VALUES ('2', '寿司', '日料', '2023-08-01', 'RL', '10.00', '35.50', '51');
INSERT INTO `t_product` VALUES ('3', '哈密瓜丝', '哈密', '2023-08-01', 'HMGS', '1.00', '1.50', '60');
INSERT INTO `t_product` VALUES ('4', '地瓜干', '地瓜', '2023-08-01', 'DGG', '13.50', '35.30', '60');
INSERT INTO `t_product` VALUES ('5', '小苏打', '苏打', '2023-08-01', 'SD', '3.50', '8.00', '60');
INSERT INTO `t_product` VALUES ('6', '淀粉', '淀粉', '2023-08-01', 'DF', '3.50', '7.00', '66');

-- ----------------------------
-- Table structure for t_record
-- ----------------------------
DROP TABLE IF EXISTS `t_record`;
CREATE TABLE `t_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `recordTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_record
-- ----------------------------
INSERT INTO `t_record` VALUES ('3', '26', '2023-08-02 08:31:22');
INSERT INTO `t_record` VALUES ('4', '26', '2023-08-02 08:31:56');
INSERT INTO `t_record` VALUES ('5', '27', '2023-08-02 08:41:43');
INSERT INTO `t_record` VALUES ('6', '26', '2023-08-02 09:39:02');

-- ----------------------------
-- Table structure for t_shop
-- ----------------------------
DROP TABLE IF EXISTS `t_shop`;
CREATE TABLE `t_shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shop
-- ----------------------------
INSERT INTO `t_shop` VALUES ('1', 'ff');
INSERT INTO `t_shop` VALUES ('2', '312');
INSERT INTO `t_shop` VALUES ('3', 'asd');
INSERT INTO `t_shop` VALUES ('4', 'fadsdfs');
INSERT INTO `t_shop` VALUES ('5', 'ffffff');
INSERT INTO `t_shop` VALUES ('7', '111');
INSERT INTO `t_shop` VALUES ('8', '11');
INSERT INTO `t_shop` VALUES ('9', '11113asdf');
INSERT INTO `t_shop` VALUES ('10', '12dfasd');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '123', '1');
INSERT INTO `t_user` VALUES ('26', '123', '123', '0');
INSERT INTO `t_user` VALUES ('27', '333', '333', '0');
