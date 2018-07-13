/*
 Navicat Premium Data Transfer

 Source Server         : driving
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : driving

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 08/07/2018 21:45:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for school_user
-- ----------------------------
DROP TABLE IF EXISTS `school_user`;
CREATE TABLE `school_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL,
  `email` varchar(64) DEFAULT NULL,
  `pwd` varchar(128) NOT NULL,
  `sex` varchar(8) DEFAULT NULL,
  `cancel_flag` varchar(8) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_user
-- ----------------------------
BEGIN;
INSERT INTO `school_user` VALUES (1, 'yangpengcheng', 'driving@163.com', '12345678', '男', 'Y', '2018-07-07 04:39:20', '2018-07-07 04:39:20');
INSERT INTO `school_user` VALUES (2, '小鹏', 'drivingschool@163.com', '12345678', '男', 'Y', '2018-07-07 04:40:31', '2018-07-07 04:40:31');
INSERT INTO `school_user` VALUES (3, '小明', 'drivingschool@163.com', '12345678', '男', 'Y', '2018-07-07 05:32:56', '2018-07-07 05:32:56');
INSERT INTO `school_user` VALUES (4, '娄先生', 'drivingschool-lou@163.com', '12345678', '男', 'Y', '2018-07-07 10:25:16', '2018-07-07 10:25:16');
INSERT INTO `school_user` VALUES (5, '杨海正', 'drivingschool-yang@163.com', '12345678', '女', 'Y', '2018-07-07 10:29:53', '2018-07-07 10:29:53');
INSERT INTO `school_user` VALUES (6, '杨教练', 'drivingschool-yang@163.com', '12345678', '男', 'Y', '2018-07-07 10:31:25', '2018-07-07 10:31:25');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
