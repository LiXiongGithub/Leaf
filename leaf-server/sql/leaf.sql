/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.7.25-log : Database - leaf
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`leaf` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `leaf`;

/*Table structure for table `app` */

DROP TABLE IF EXISTS `app`;

CREATE TABLE `app` (
  `id` varchar(32) NOT NULL COMMENT 'uuid',
  `app_id` varchar(16) NOT NULL COMMENT '渠道id',
  `app_name` varchar(32) DEFAULT NULL COMMENT '渠道名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='app';

/*Data for the table `app` */

/*Table structure for table `leaf_alloc` */

DROP TABLE IF EXISTS `leaf_alloc`;

CREATE TABLE `leaf_alloc` (
  `biz_tag` varchar(128) NOT NULL DEFAULT '',
  `max_id` bigint(20) NOT NULL DEFAULT '1',
  `step` int(11) NOT NULL,
  `description` varchar(256) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `app_id` varchar(16) DEFAULT NULL COMMENT '渠道方id',
  `num_size` varchar(2) DEFAULT NULL COMMENT '自增id字符串大小',
  `prefix_add` varchar(32) DEFAULT NULL COMMENT '一个业务id对应一个prefix',
  `type` varchar(2) DEFAULT NULL COMMENT '0数字类型,1雪花类型',
  PRIMARY KEY (`biz_tag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `leaf_alloc` */

insert  into `leaf_alloc`(`biz_tag`,`max_id`,`step`,`description`,`update_time`,`app_id`,`num_size`,`prefix_add`,`type`) values 
('leaf-segment-test',22001,2000,'Test leaf Segment Mode Get Id','2019-10-09 10:47:59','lxtest','8','lxprefix','0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
