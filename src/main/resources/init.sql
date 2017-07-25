/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 5.7.18-0ubuntu0.16.04.1 : Database - sunrise
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sunrise` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sunrise`;

/*Table structure for table `conf_entity` */

DROP TABLE IF EXISTS `conf_entity`;

CREATE TABLE `conf_entity` (
  `entity_name` varchar(20) NOT NULL,
  `primary_field` varchar(50) DEFAULT NULL,
  `create_url` varchar(30) DEFAULT NULL,
  `update_url` varchar(30) DEFAULT NULL,
  `delete_url` varchar(30) DEFAULT NULL,
  `query_sql` text,
  `title` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`entity_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `conf_entity` */

insert  into `conf_entity`(`entity_name`,`primary_field`,`create_url`,`update_url`,`delete_url`,`query_sql`,`title`) values 
('sysRole','role_code',NULL,NULL,NULL,'select * from sys_role','角色编码参数信息');

/*Table structure for table `conf_fields` */

DROP TABLE IF EXISTS `conf_fields`;

CREATE TABLE `conf_fields` (
  `entity_name` varchar(20) NOT NULL,
  `column_index` int(11) NOT NULL,
  `field_name` varchar(50) NOT NULL,
  `field_type` varchar(10) NOT NULL,
  `field_text` varchar(50) NOT NULL,
  `hidden` char(1) DEFAULT NULL,
  `renderer` text,
  `width` int(4) DEFAULT '100',
  `datasql` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`entity_name`,`column_index`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `conf_fields` */

insert  into `conf_fields`(`entity_name`,`column_index`,`field_name`,`field_type`,`field_text`,`hidden`,`renderer`,`width`,`datasql`) values 
('sysRole',1,'roleCode','string','角色编码',NULL,NULL,100,NULL),
('sysRole',2,'dataCode','string','数据编码',NULL,NULL,100,NULL),
('sysRole',3,'dataType','string','数据类型',NULL,NULL,100,NULL),
('sysRole',4,'roleName','string','角色名称',NULL,NULL,100,NULL),
('sysRole',5,'roleAttr','string','角色属性',NULL,NULL,100,NULL),
('sysRole',6,'remark','string','备注',NULL,NULL,100,NULL),
('sysRole',7,'validflag','string','是否有效',NULL,NULL,100,NULL),
('sysRole',8,'updateTime','date','跟新时间',NULL,NULL,100,NULL),
('sysRole',9,'updateStaffId','string','跟新员工',NULL,NULL,100,NULL),
('sysRole',10,'staffId','string','员工ID',NULL,NULL,100,NULL);

/*Table structure for table `log_h_operate` */

DROP TABLE IF EXISTS `log_h_operate`;

CREATE TABLE `log_h_operate` (
  `LOG_ID` varchar(16) NOT NULL COMMENT '日志ID:YYYYMMDD+8位顺序号',
  `STAFF_ID` varchar(8) DEFAULT NULL,
  `MOD_CODE` varchar(30) DEFAULT NULL COMMENT '模块编码:子系统编码＋三位序列',
  `ACTION_TYPE` int(2) DEFAULT NULL,
  `OPERATE_TIME` date DEFAULT NULL,
  `OPERATE_RESULT` char(1) DEFAULT NULL COMMENT '操作结果：0-成功，1-失败',
  `REMARK` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`LOG_ID`),
  KEY `FK_REFERENCE_2` (`ACTION_TYPE`),
  CONSTRAINT `FK_REFERENCE_2` FOREIGN KEY (`ACTION_TYPE`) REFERENCES `sys_action_type` (`ACTION_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `log_h_operate` */

/*Table structure for table `log_operate` */

DROP TABLE IF EXISTS `log_operate`;

CREATE TABLE `log_operate` (
  `LOG_ID` varchar(16) NOT NULL COMMENT '日志ID：YYYYMMDD+8位顺序号',
  `STAFF_ID` varchar(8) DEFAULT NULL,
  `MOD_CODE` varchar(30) DEFAULT NULL COMMENT '模块编码：子系统编码＋三位序列',
  `ACTION_TYPE` int(2) DEFAULT NULL,
  `OPERATE_TIME` date DEFAULT NULL,
  `OPERATE_RESULT` char(1) DEFAULT NULL COMMENT '操作结果：0-成功，1-失败',
  `ERMARK` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`LOG_ID`),
  KEY `FK_REFERENCE_1` (`ACTION_TYPE`),
  CONSTRAINT `FK_REFERENCE_1` FOREIGN KEY (`ACTION_TYPE`) REFERENCES `sys_action_type` (`ACTION_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `log_operate` */

/*Table structure for table `log_rightl` */

DROP TABLE IF EXISTS `log_rightl`;

CREATE TABLE `log_rightl` (
  `RIGHT_CODE` varchar(30) NOT NULL COMMENT '权限编码：权限编码或者角色编码',
  `OPERED_STAFF_ID` varchar(8) NOT NULL COMMENT '操作对象员工编码：给角色分配权限时，操作对象员工编码插一个固定的值，如“ZZZZZZZZ”',
  `RIGHT_ATTR` char(1) NOT NULL COMMENT '权限属性：如果是功能权限：0－菜单权限，1－界面控件权限，2－系统特权；如果是数据权限：0－资源权限，1－数据特权(行列数等)，2－产品权限，3－资费权限，4－服务权限',
  `LOG_ID` varchar(16) NOT NULL,
  `OPER_TYPE` char(1) NOT NULL COMMENT '操作类型：0－分配，1－回收',
  `RIGHT_TYPE` char(4) NOT NULL COMMENT '权限类型：0000－单个功能权限，1000－角色功能权限，2000－单个数据权限，3000－角色数据权限，4000－临时功能权限，5000－临时数据权限',
  `ROLE_CODE` char(8) DEFAULT NULL,
  `OPER_STAFF_ID` varchar(8) DEFAULT NULL,
  `OPER_DEPART_ID` varchar(5) DEFAULT NULL,
  `OPER_DATE` date DEFAULT NULL,
  `RIGHT_CLASS` char(1) DEFAULT NULL,
  `OPER_SPECIAL` char(1) DEFAULT NULL,
  `TERM_IP` varchar(15) DEFAULT NULL,
  `USE_TAG` char(1) DEFAULT NULL COMMENT '用标志：0－按次数使用，1－按时间范围使用',
  `TIMES` int(3) DEFAULT '0',
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`RIGHT_CODE`,`OPERED_STAFF_ID`,`RIGHT_ATTR`,`LOG_ID`),
  KEY `IDX_SYS_RIGHTLOG_DATESTAFF` (`OPER_DATE`,`OPER_STAFF_ID`,`OPER_TYPE`),
  KEY `IDX_SYS_RIGHTLOG_DATERIGHT` (`OPERED_STAFF_ID`,`OPER_DATE`,`RIGHT_CODE`),
  KEY `IDX_SYS_RIGHTLOG_LOGID` (`LOG_ID`),
  KEY `IDX_SYS_RIGHTLOG_ROLE` (`ROLE_CODE`),
  KEY `IDX_SYS_RIGHTLOG_IP` (`TERM_IP`,`OPER_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限管理日志：批量操作时，流水号一致，给角色分配权限时，角色编码插ROLE_CODE。';

/*Data for the table `log_rightl` */

/*Table structure for table `log_staff` */

DROP TABLE IF EXISTS `log_staff`;

CREATE TABLE `log_staff` (
  `LOG_ID` varchar(16) NOT NULL COMMENT '日志流水：起唯一主键作用',
  `STAFF_ID` varchar(8) DEFAULT NULL,
  `IN_TIME` date DEFAULT NULL,
  `OUT_TIME` date DEFAULT NULL,
  `SUBSYS_CODE` char(3) NOT NULL,
  `IN_IP` varchar(15) DEFAULT NULL,
  `REMARK` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`LOG_ID`),
  KEY `IDX_SYS_STAFFLOG_INTIME` (`STAFF_ID`,`IN_TIME`,`IN_IP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存员工登录云平台和退出云平台时间、IP等信息';

/*Data for the table `log_staff` */

/*Table structure for table `log_staff_his` */

DROP TABLE IF EXISTS `log_staff_his`;

CREATE TABLE `log_staff_his` (
  `LOG_ID` varchar(16) NOT NULL COMMENT '日志流水：起唯一主键作用',
  `STAFF_ID` varchar(8) DEFAULT NULL,
  `IN_TIME` date DEFAULT NULL,
  `OUT_TIME` date DEFAULT NULL,
  `SUBSYS_CODE` char(3) NOT NULL,
  `IN_IP` varchar(15) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`LOG_ID`),
  KEY `IDX_SYS_STAFFLOG_HIS_INTIME` (`STAFF_ID`,`IN_TIME`,`IN_IP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存员工登录云平台和退出云平台时间、IP等信息';

/*Data for the table `log_staff_his` */

/*Table structure for table `sys_action_type` */

DROP TABLE IF EXISTS `sys_action_type`;

CREATE TABLE `sys_action_type` (
  `ACTION_TYPE` int(2) NOT NULL,
  `REMARK` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ACTION_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_action_type` */

/*Table structure for table `sys_current_token` */

DROP TABLE IF EXISTS `sys_current_token`;

CREATE TABLE `sys_current_token` (
  `token` varchar(50) NOT NULL,
  `staff_id` varchar(8) NOT NULL,
  `expiration_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `request_ip` varchar(20) NOT NULL,
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_current_token` */

insert  into `sys_current_token`(`token`,`staff_id`,`expiration_time`,`request_ip`) values 
('cc2f2c28-961d-4069-b09f-d43fb633c4aa','syu','2017-07-21 11:07:52','192.168.1.133');

/*Table structure for table `sys_dataright` */

DROP TABLE IF EXISTS `sys_dataright`;

CREATE TABLE `sys_dataright` (
  `DATA_CODE` varchar(30) NOT NULL COMMENT '数据编码： 产品、资费和服务等权限采用其对应的参数编码，其它类型权限采用有意义的字母表示',
  `DATA_NAME` varchar(50) DEFAULT NULL,
  `RIGHT_TYPE` char(4) NOT NULL DEFAULT '1000' COMMENT '权限类型：',
  `ORDER_INDEX` int(12) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`DATA_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存数据权限信息，包含资源、数据特权等相关权限集合';

/*Data for the table `sys_dataright` */

insert  into `sys_dataright`(`DATA_CODE`,`DATA_NAME`,`RIGHT_TYPE`,`ORDER_INDEX`,`REMARK`,`UPDATE_TIME`,`UPDATE_STAFF_ID`) values 
('data_1','地质数据','1000',NULL,NULL,NULL,NULL),
('data_2','地理数据','1000',NULL,NULL,NULL,NULL),
('data_3','什么数据','1000',NULL,NULL,NULL,NULL),
('data_4','??数据','1000',NULL,NULL,NULL,NULL);

/*Table structure for table `sys_depart` */

DROP TABLE IF EXISTS `sys_depart`;

CREATE TABLE `sys_depart` (
  `DEPART_ID` varchar(5) NOT NULL,
  `DEPART_CODE` varchar(8) NOT NULL,
  `DEPART_NAME` varchar(50) DEFAULT NULL,
  `VALIDFLAG` char(1) NOT NULL COMMENT '有效标记：0－有效，1－失效（注销）',
  `PARENT_DEPART_ID` varchar(5) DEFAULT NULL,
  `MANAGER_STAFF_ID` varchar(8) DEFAULT NULL COMMENT '部门管理者：部门经理',
  `ORDER_NO` int(3) NOT NULL COMMENT '序号：树状结构信息生成时的显示顺序(同级部门/组织的优先级关系)',
  `START_DATE` date NOT NULL,
  `END_DATE` date DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`DEPART_ID`),
  KEY `IDX_SYS_DEPART_DEPARTCODE` (`DEPART_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门组织表';

/*Data for the table `sys_depart` */

insert  into `sys_depart`(`DEPART_ID`,`DEPART_CODE`,`DEPART_NAME`,`VALIDFLAG`,`PARENT_DEPART_ID`,`MANAGER_STAFF_ID`,`ORDER_NO`,`START_DATE`,`END_DATE`,`REMARK`) values 
('0','bzkj','步桌科技','0',NULL,'docZuo',0,'2017-07-01',NULL,NULL),
('1','technic','技术部','0','0','docZhao',1,'2017-07-01',NULL,NULL),
('2','cloud','云平台','0','1','xusy',2,'2017-07-01',NULL,NULL),
('3','big_data','大数据','0','1','guanj',3,'2017-07-01',NULL,NULL);

/*Table structure for table `sys_funcright` */

DROP TABLE IF EXISTS `sys_funcright`;

CREATE TABLE `sys_funcright` (
  `RIGHT_CODE` varchar(30) NOT NULL COMMENT '权限编码：对于菜单权限－子系统编码＋有意义的英文说明(界面名称或者功能简称)；对于界面控件操作权限－窗体类名＋按钮名',
  `RIGHT_NAME` varchar(50) DEFAULT NULL,
  `CLASS_CODE` varchar(4) NOT NULL COMMENT '分类编码：将相同功能组合为一类，由我们定义，与子系统有不同之处',
  `RIGHT_ATTR` char(1) DEFAULT NULL COMMENT '权限属性：0－菜单权限，1－界面控件权限，2－系统特权',
  `MOD_CODE` varchar(30) DEFAULT NULL COMMENT '模块编码：子系统编码＋三位序列报表组作为有意义编码，编码可以为30位',
  `ORDER_INDEX` int(12) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL COMMENT '更新员工：这些权限编码基本由程序员设定，因此无需要“更新部门”字段。',
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`RIGHT_CODE`),
  KEY `IDX_SYS_FUNCRIGHT_CLASSCODE` (`CLASS_CODE`),
  KEY `IDX_SYS_FUNCRIGHT_MODCODE` (`MOD_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存菜单、按钮以及相关操作特权等权限信息';

/*Data for the table `sys_funcright` */

insert  into `sys_funcright`(`RIGHT_CODE`,`RIGHT_NAME`,`CLASS_CODE`,`RIGHT_ATTR`,`MOD_CODE`,`ORDER_INDEX`,`REMARK`,`UPDATE_TIME`,`UPDATE_STAFF_ID`,`UPDATE_DEPART_ID`) values 
('dsj_menu','大数据菜单权限','dsjm','0',NULL,NULL,NULL,NULL,NULL,NULL),
('sys_menu','系统菜单','sysm','0',NULL,NULL,NULL,NULL,NULL,NULL),
('ypt_menu','云平台菜单权限','yptm','0',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `sys_hidemenuitem` */

DROP TABLE IF EXISTS `sys_hidemenuitem`;

CREATE TABLE `sys_hidemenuitem` (
  `STAFF_ID` varchar(8) NOT NULL COMMENT '员工编码',
  `MENU_ID` varchar(7) CHARACTER SET latin1 NOT NULL,
  `DEPART_ID` char(5) NOT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`STAFF_ID`,`MENU_ID`,`DEPART_ID`),
  KEY `FK_REFERENCE_9` (`MENU_ID`),
  CONSTRAINT `FK_REFERENCE_9` FOREIGN KEY (`MENU_ID`) REFERENCES `sys_systemguimenu` (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='屏蔽员工相关菜单';

/*Data for the table `sys_hidemenuitem` */

insert  into `sys_hidemenuitem`(`STAFF_ID`,`MENU_ID`,`DEPART_ID`,`REMARK`,`UPDATE_TIME`,`UPDATE_STAFF_ID`,`UPDATE_DEPART_ID`) values 
('syu','menu1','1',NULL,NULL,NULL,NULL);

/*Table structure for table `sys_mh_stafftempdataright` */

DROP TABLE IF EXISTS `sys_mh_stafftempdataright`;

CREATE TABLE `sys_mh_stafftempdataright` (
  `STAFF_ID` varchar(8) NOT NULL,
  `DATA_CODE` varchar(30) NOT NULL,
  `DATA_TYPE` char(1) NOT NULL COMMENT '数据类型：0－资源权限，1－数据特权(行列数等)，2－产品权限，3－资费权限，4－服务权限',
  `RIGHT_CLASS` char(1) DEFAULT NULL,
  `OPER_SPECIAL` char(1) DEFAULT NULL,
  `ACCREDIT_TIME` date DEFAULT NULL,
  `ACCREDIT_STAFF_ID` varchar(8) DEFAULT NULL,
  `USE_TAG` char(1) NOT NULL COMMENT '用标志：0－按次数使用，1－按时间范围使用',
  `TIMES` int(3) DEFAULT '0',
  `USED_TIMES` int(3) DEFAULT '0',
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `TERM_IP` varchar(15) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date NOT NULL,
  `UPDATE_STAFF_ID` char(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` char(5) DEFAULT NULL,
  KEY `IDX_SYS_STAFFTEMPDATA_DATA_HIS` (`DATA_CODE`,`DATA_TYPE`),
  KEY `IDX_SYS_STAFFTEMPDATA_STAFF_HIS` (`STAFF_ID`,`DATA_CODE`,`DATA_TYPE`),
  KEY `IDX_SYS_STAFFTEMPDATA_TIME_HIS` (`UPDATE_TIME`,`UPDATE_STAFF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工临时数据权限历史表，记录历史信息，员工临时数据权限失效后搬到此表备份';

/*Data for the table `sys_mh_stafftempdataright` */

/*Table structure for table `sys_mh_stafftempfuncright` */

DROP TABLE IF EXISTS `sys_mh_stafftempfuncright`;

CREATE TABLE `sys_mh_stafftempfuncright` (
  `STAFF_ID` varchar(8) NOT NULL,
  `RIGHT_CODE` varchar(30) NOT NULL,
  `ACCREDIT_TIME` date DEFAULT NULL,
  `ACCREDIT_STAFF_ID` varchar(8) DEFAULT NULL,
  `USE_TAG` char(1) NOT NULL COMMENT '用标志：0－按次数使用，1－按时间范围使用',
  `TIMES` int(3) DEFAULT '0',
  `USED_TIMES` int(3) DEFAULT '0',
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `TERM_IP` varchar(15) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date NOT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  KEY `IDX_SYS_STAFFTEMPFUNC_RIGHT` (`RIGHT_CODE`),
  KEY `IDX_SYS_STAFFTEMPFUNC_STAFF` (`STAFF_ID`,`RIGHT_CODE`),
  KEY `IDX_SYS_STAFFTEMPFUNC_TIME` (`UPDATE_TIME`,`UPDATE_STAFF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存员工临时功能权限历史信息，员工临时功能权限失效后搬到此表备份';

/*Data for the table `sys_mh_stafftempfuncright` */

/*Table structure for table `sys_modfile` */

DROP TABLE IF EXISTS `sys_modfile`;

CREATE TABLE `sys_modfile` (
  `MOD_CODE` varchar(30) NOT NULL COMMENT '模块编码：子系统编码＋三位序列',
  `MOD_NAME` varchar(512) NOT NULL,
  `MOD_TYPE` char(1) NOT NULL COMMENT '库文件类型：0－GUI的DLL文件，1－WEB地址',
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  UNIQUE KEY `IDX_SYS_MODFILE_MODNAME` (`MOD_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存GUI的DLL文件编码信息和WEB地址URL信息等';

/*Data for the table `sys_modfile` */

/*Table structure for table `sys_rightlog_his` */

DROP TABLE IF EXISTS `sys_rightlog_his`;

CREATE TABLE `sys_rightlog_his` (
  `RIGHT_CODE` varchar(30) NOT NULL,
  `OPERED_STAFF_ID` varchar(8) NOT NULL,
  `RIGHT_ATTR` char(1) NOT NULL COMMENT '权限属性：如果是功能权限：0－菜单权限，1－界面控件权限，2－系统特权；如果是数据权限：0－资源权限，1－数据特权(行列数等)，2－产品权限，3－资费权限，4－服务权限',
  `LOG_ID` varchar(16) NOT NULL,
  `OPER_TYPE` char(1) NOT NULL COMMENT '操作类型：0－分配，1－回收',
  `RIGHT_TYPE` char(4) NOT NULL COMMENT '权限类型：0000－单个功能权限，1000－角色功能权限，2000－单个数据权限，3000－角色数据权限，4000－临时功能权限，5000－临时数据权限',
  `ROLE_CODE` char(8) DEFAULT NULL,
  `AREA_CODE` char(4) DEFAULT NULL COMMENT '地域编码：保存地州信息',
  `OPER_STAFF_ID` varchar(8) DEFAULT NULL,
  `OPER_DEPART_ID` varchar(5) DEFAULT NULL,
  `OPER_DATE` date DEFAULT NULL,
  `RIGHT_CLASS` char(1) DEFAULT NULL,
  `OPER_SPECIAL` char(1) DEFAULT NULL,
  `TERM_IP` varchar(15) DEFAULT NULL,
  `USE_TAG` char(1) DEFAULT NULL COMMENT '用标志：0－按次数使用，1－按时间范围使用',
  `TIMES` int(3) DEFAULT '0',
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_rightlog_his` */

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `ROLE_CODE` char(30) NOT NULL COMMENT '角色编码',
  `ROLE_NAME` varchar(30) DEFAULT NULL,
  `ROLE_ATTR` char(1) NOT NULL COMMENT '角色属性：0－功能权限角色，1－资源数据权限角色，2－数据特权角色 可扩展',
  `REMARK` varchar(100) DEFAULT NULL,
  `VALIDFLAG` char(1) NOT NULL COMMENT '有效0 ；无效1',
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`ROLE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存角色编码参数信息';

/*Data for the table `sys_role` */

insert  into `sys_role`(`ROLE_CODE`,`ROLE_NAME`,`ROLE_ATTR`,`REMARK`,`VALIDFLAG`,`UPDATE_TIME`,`UPDATE_STAFF_ID`,`UPDATE_DEPART_ID`) values 
('role_admin_menu','admin菜单权限','0',NULL,'0','2017-07-19',NULL,NULL),
('role_data_admin','admin数据权限','1',NULL,'0','2017-07-19',NULL,NULL);

/*Table structure for table `sys_roledataright` */

DROP TABLE IF EXISTS `sys_roledataright`;

CREATE TABLE `sys_roledataright` (
  `ROLE_CODE` char(30) NOT NULL,
  `DATA_CODE` varchar(30) NOT NULL,
  `DATA_TYPE` char(1) NOT NULL COMMENT '数据类型：0－资源权限，1－数据特权(行列数等)，9—网别，P－产品权限，D－资费权限，S－服务权限，K—包权限',
  `RIGHT_CLASS` char(1) DEFAULT NULL COMMENT '权限级别：0－无权限，1－个人权限，2－营业厅权限，3－业务区权限，4－地州权限，5－全省权限',
  `OPER_SPECIAL` char(1) DEFAULT NULL COMMENT '操作特权：0－可同级操作，1－可越级操作',
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`ROLE_CODE`,`DATA_CODE`,`DATA_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存数据权限的角色信息';

/*Data for the table `sys_roledataright` */

insert  into `sys_roledataright`(`ROLE_CODE`,`DATA_CODE`,`DATA_TYPE`,`RIGHT_CLASS`,`OPER_SPECIAL`,`UPDATE_TIME`,`UPDATE_STAFF_ID`,`UPDATE_DEPART_ID`) values 
('role_data_admin','data_4','0','7',NULL,NULL,NULL,NULL);

/*Table structure for table `sys_rolefuncright` */

DROP TABLE IF EXISTS `sys_rolefuncright`;

CREATE TABLE `sys_rolefuncright` (
  `ROLE_CODE` char(30) NOT NULL,
  `RIGHT_CODE` varchar(30) NOT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`ROLE_CODE`,`RIGHT_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存相关功能权限的角色信息';

/*Data for the table `sys_rolefuncright` */

insert  into `sys_rolefuncright`(`ROLE_CODE`,`RIGHT_CODE`,`UPDATE_TIME`,`UPDATE_STAFF_ID`,`UPDATE_DEPART_ID`) values 
('role_admin_menu','sys_menu',NULL,NULL,NULL);

/*Table structure for table `sys_staff` */

DROP TABLE IF EXISTS `sys_staff`;

CREATE TABLE `sys_staff` (
  `STAFF_ID` varchar(8) NOT NULL COMMENT '员工编码：在任何时间内唯一，离职的员工打上标记，不直接删除。',
  `DEPART_ID` varchar(5) DEFAULT NULL,
  `STAFF_NAME` varchar(50) DEFAULT NULL,
  `JOB_CODE` varchar(20) DEFAULT NULL COMMENT '岗位编码：对应岗位参数表，类似角色功能，给权限分配提供方便。',
  `MANAGER_INFO` varchar(50) DEFAULT NULL,
  `SEX` char(1) NOT NULL COMMENT '员工性别：0－男，1－女',
  `EMAIL` varchar(30) NOT NULL COMMENT '必须校验唯一性，用户可以用工号登陆，也可以用email登陆，还可以用手机号登陆',
  `USER_PID` varchar(20) NOT NULL,
  `SERIAL_NUMBER` varchar(15) DEFAULT NULL,
  `DIMISSION_TAG` char(1) NOT NULL COMMENT '离职标志：0－正常，1－已经离职',
  `BIRTHDAY` date DEFAULT NULL,
  `CUST_HOBYY` varchar(80) DEFAULT NULL,
  `MANAGER_STAFF_ID` varchar(8) DEFAULT NULL COMMENT '员工管理者：员工的上级',
  `LOGIN_FLAG` char(1) NOT NULL DEFAULT '0' COMMENT '员工登录标记：0－正常，1－虚拟（不允许登录，便于权限控制）',
  `REMARK` varchar(100) DEFAULT NULL,
  `START_DATE` date NOT NULL COMMENT '起始有效时间',
  `END_DATE` date NOT NULL COMMENT '终止有效时间',
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`STAFF_ID`),
  KEY `IDX_SYS_STAFF_DEPARTID` (`DEPART_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存所有登陆云平台的员工工号信息';

/*Data for the table `sys_staff` */

insert  into `sys_staff`(`STAFF_ID`,`DEPART_ID`,`STAFF_NAME`,`JOB_CODE`,`MANAGER_INFO`,`SEX`,`EMAIL`,`USER_PID`,`SERIAL_NUMBER`,`DIMISSION_TAG`,`BIRTHDAY`,`CUST_HOBYY`,`MANAGER_STAFF_ID`,`LOGIN_FLAG`,`REMARK`,`START_DATE`,`END_DATE`,`UPDATE_TIME`,`UPDATE_STAFF_ID`,`UPDATE_DEPART_ID`) values 
('docZhao','1','赵博士','manager',NULL,'0','zhao@qq.com','something','13577050132','0',NULL,NULL,'docZuo','0',NULL,'2017-07-13','2018-07-13',NULL,NULL,NULL),
('docZuo','0','左老师','boss',NULL,'0','zuo@qq.com','something','13577050371','0',NULL,NULL,NULL,'0',NULL,'2017-07-01','2018-07-13',NULL,NULL,NULL),
('syu','2','syu','worder',NULL,'0','syu@qq.com','something','13577050174','0',NULL,NULL,'xusy','0',NULL,'2017-07-01','2018-07-13',NULL,NULL,NULL),
('xusy','2','徐斯远','manager',NULL,'0','xu@qq.com','something','13577050173','0',NULL,NULL,'docZhao','0',NULL,'2017-07-13','2018-07-13',NULL,NULL,NULL);

/*Table structure for table `sys_staffauthcode` */

DROP TABLE IF EXISTS `sys_staffauthcode`;

CREATE TABLE `sys_staffauthcode` (
  `STAFF_ID` varchar(8) NOT NULL COMMENT '员工编码',
  `WEB_PASSWD` varchar(50) NOT NULL COMMENT '授权码',
  `STR_DATA` date NOT NULL,
  `END_DATA` date NOT NULL,
  `REMARK` varchar(200) DEFAULT NULL COMMENT '备注',
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`STAFF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_staffauthcode` */

/*Table structure for table `sys_staffdataright` */

DROP TABLE IF EXISTS `sys_staffdataright`;

CREATE TABLE `sys_staffdataright` (
  `STAFF_ID` varchar(8) NOT NULL,
  `DATA_CODE` varchar(30) NOT NULL COMMENT '权限或角色编码：可能是单个的权限编码，也可能是角色编码',
  `DATA_TYPE` char(1) NOT NULL COMMENT '数据类型：0－资源权限，1－数据特权(行列数等)',
  `RIGHT_ATTR` char(1) NOT NULL COMMENT '权限属性：0－数据权限，1－数据角色权限',
  `RIGHT_CLASS` char(1) DEFAULT NULL COMMENT '权限级别：当权限属性是0时有效，操作特权类似',
  `OPER_SPECIAL` char(1) DEFAULT NULL,
  `RIGHT_TAG` char(1) NOT NULL COMMENT '权限标志：0－无效，1－有效',
  `REMARK` varchar(100) DEFAULT NULL,
  `ACCREDIT_TIME` date DEFAULT NULL,
  `ACCREDIT_STAFF_ID` varchar(8) DEFAULT NULL,
  KEY `IDX_SYS_STAFFDATA_DATACODE` (`DATA_CODE`,`DATA_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存员工所有数据权限/角色信息';

/*Data for the table `sys_staffdataright` */

insert  into `sys_staffdataright`(`STAFF_ID`,`DATA_CODE`,`DATA_TYPE`,`RIGHT_ATTR`,`RIGHT_CLASS`,`OPER_SPECIAL`,`RIGHT_TAG`,`REMARK`,`ACCREDIT_TIME`,`ACCREDIT_STAFF_ID`) values 
('syu','data_3','0','0','3',NULL,'0',NULL,NULL,NULL),
('syu','role_data_admin','0','1','4','9','0',NULL,NULL,NULL),
('syu','role_data_admin','s','1','p','f','0',NULL,NULL,NULL);

/*Table structure for table `sys_staffdatetime` */

DROP TABLE IF EXISTS `sys_staffdatetime`;

CREATE TABLE `sys_staffdatetime` (
  `LIMIT_ID` varchar(4) NOT NULL COMMENT '受限标识：序列号生成，只实现主键含义。',
  `STAFF_ID` varchar(8) DEFAULT NULL,
  `SYS_TAG` char(1) NOT NULL COMMENT '系统限制标记：0－普通员工限制，1－全体员工限制',
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存限制员工登录日期和时间的相关信息';

/*Data for the table `sys_staffdatetime` */

/*Table structure for table `sys_stafffuncright` */

DROP TABLE IF EXISTS `sys_stafffuncright`;

CREATE TABLE `sys_stafffuncright` (
  `STAFF_ID` varchar(8) NOT NULL,
  `RIGHT_CODE` varchar(30) NOT NULL COMMENT '权限或角色编码：可能是单个的权限编码，也可能是角色编码',
  `RIGHT_ATTR` char(1) NOT NULL COMMENT '权限属性：0－功能权限，1－功能角色权限',
  `RIGHT_TAG` char(1) NOT NULL COMMENT '权限标志：0－无效，1－有效',
  `REMARK` varchar(100) DEFAULT NULL,
  `ACCREDIT_TIME` date DEFAULT NULL,
  `ACCREDIT_STAFF_ID` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`STAFF_ID`,`RIGHT_CODE`),
  KEY `IDX_SYS_STAFFFUNCRIGHT_RIGHT` (`RIGHT_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存员工的所有功能权限/角色信息';

/*Data for the table `sys_stafffuncright` */

insert  into `sys_stafffuncright`(`STAFF_ID`,`RIGHT_CODE`,`RIGHT_ATTR`,`RIGHT_TAG`,`REMARK`,`ACCREDIT_TIME`,`ACCREDIT_STAFF_ID`) values 
('syu','role_admin_menu','1','0',NULL,NULL,NULL),
('syu','ypt_menu','0','0',NULL,NULL,NULL);

/*Table structure for table `sys_staffpasswd` */

DROP TABLE IF EXISTS `sys_staffpasswd`;

CREATE TABLE `sys_staffpasswd` (
  `STAFF_ID` varchar(8) NOT NULL,
  `STAFF_PASSWD` varchar(10) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`STAFF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存加密后的员工密码信息';

/*Data for the table `sys_staffpasswd` */

insert  into `sys_staffpasswd`(`STAFF_ID`,`STAFF_PASSWD`,`UPDATE_TIME`,`UPDATE_STAFF_ID`,`UPDATE_DEPART_ID`) values 
('docZhao','123456',NULL,NULL,NULL),
('docZuo','123456',NULL,NULL,NULL),
('syu','123456',NULL,NULL,NULL),
('xusy','123456',NULL,NULL,NULL);

/*Table structure for table `sys_stafftempdataright` */

DROP TABLE IF EXISTS `sys_stafftempdataright`;

CREATE TABLE `sys_stafftempdataright` (
  `STAFF_ID` varchar(8) NOT NULL,
  `DATA_CODE` varchar(30) NOT NULL,
  `DATA_TYPE` char(1) NOT NULL COMMENT '数据类型：0－资源权限，1－数据特权(行列数等)，2－产品权限，3－资费权限，4－服务权限',
  `RIGHT_CLASS` char(1) DEFAULT NULL,
  `OPER_SPECIAL` char(1) DEFAULT NULL,
  `ACCREDIT_TIME` date DEFAULT NULL,
  `ACCREDIT_STAFF_ID` char(8) DEFAULT NULL,
  `USE_TAG` char(1) NOT NULL COMMENT '用标志：0－按次数使用，1－按时间范围使用',
  `TIMES` int(3) DEFAULT '0',
  `USED_TIMES` int(3) DEFAULT '0',
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date NOT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  KEY `IDX_SYS_STAFFTEMPDATA_DATA` (`DATA_CODE`,`DATA_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工临时数据权限表：只记录有效临时权限信息，失效后搬到历史表(分配权限时判断)';

/*Data for the table `sys_stafftempdataright` */

insert  into `sys_stafftempdataright`(`STAFF_ID`,`DATA_CODE`,`DATA_TYPE`,`RIGHT_CLASS`,`OPER_SPECIAL`,`ACCREDIT_TIME`,`ACCREDIT_STAFF_ID`,`USE_TAG`,`TIMES`,`USED_TIMES`,`START_DATE`,`END_DATE`,`REMARK`,`UPDATE_TIME`,`UPDATE_STAFF_ID`,`UPDATE_DEPART_ID`) values 
('syu','data_1','1','1','1',NULL,NULL,'0',3,7,NULL,NULL,NULL,'2017-07-18',NULL,NULL);

/*Table structure for table `sys_stafftempfuncright` */

DROP TABLE IF EXISTS `sys_stafftempfuncright`;

CREATE TABLE `sys_stafftempfuncright` (
  `STAFF_ID` varchar(8) NOT NULL,
  `RIGHT_CODE` varchar(30) NOT NULL,
  `ACCREDIT_TIME` date DEFAULT NULL,
  `ACCREDIT_STAFF_ID` varchar(8) DEFAULT NULL,
  `USE_TAG` char(1) NOT NULL COMMENT '用标志：0－按次数使用，1－按时间范围使用',
  `TIMES` int(3) DEFAULT '0',
  `USED_TIMES` int(3) DEFAULT '0',
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date NOT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`STAFF_ID`,`RIGHT_CODE`),
  KEY `IDX_SYS_STAFFTEMPFUNC_RIGHT` (`RIGHT_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工临时功能权限表：只记录有效临时权限信息，失效后搬到历史表(分配权限时判断)';

/*Data for the table `sys_stafftempfuncright` */

insert  into `sys_stafftempfuncright`(`STAFF_ID`,`RIGHT_CODE`,`ACCREDIT_TIME`,`ACCREDIT_STAFF_ID`,`USE_TAG`,`TIMES`,`USED_TIMES`,`START_DATE`,`END_DATE`,`REMARK`,`UPDATE_TIME`,`UPDATE_STAFF_ID`,`UPDATE_DEPART_ID`) values 
('syu','dsj_menu',NULL,NULL,'1',0,0,'2017-07-01','2017-08-01',NULL,'2017-07-13',NULL,NULL);

/*Table structure for table `sys_stafftermipaddr` */

DROP TABLE IF EXISTS `sys_stafftermipaddr`;

CREATE TABLE `sys_stafftermipaddr` (
  `STAFF_ID` varchar(8) NOT NULL,
  `IP_START` varchar(15) NOT NULL,
  `IP_END` varchar(15) NOT NULL COMMENT 'IP终止地址：如果是固定IP，填写和起始IP相同',
  `SYS_TAG` char(1) NOT NULL COMMENT '系统限制标记：0－不能登录IP，1－只能登录IP段',
  `REMARK` varchar(100) DEFAULT NULL COMMENT '备注：受限原因',
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存限制员工登录的机器IP地址信息';

/*Data for the table `sys_stafftermipaddr` */

insert  into `sys_stafftermipaddr`(`STAFF_ID`,`IP_START`,`IP_END`,`SYS_TAG`,`REMARK`,`UPDATE_TIME`,`UPDATE_STAFF_ID`,`UPDATE_DEPART_ID`) values 
('syu','192.168.1.0','192.168.1.255','1',NULL,NULL,NULL,NULL);

/*Table structure for table `sys_subsys` */

DROP TABLE IF EXISTS `sys_subsys`;

CREATE TABLE `sys_subsys` (
  `SUBSYS_CODE` char(3) CHARACTER SET latin1 NOT NULL COMMENT '子系统编码：三位有意义的编码简称',
  `SUBSYS_NAME` varchar(50) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`SUBSYS_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存云平台所有子系统编码信息';

/*Data for the table `sys_subsys` */

insert  into `sys_subsys`(`SUBSYS_CODE`,`SUBSYS_NAME`,`REMARK`,`UPDATE_TIME`,`UPDATE_STAFF_ID`,`UPDATE_DEPART_ID`) values 
('dsj','大数据',NULL,'2017-07-13','syu','2'),
('sys','系统',NULL,'2017-07-17','syu','2'),
('ypt','云平台',NULL,'2017-07-13','syu','2');

/*Table structure for table `sys_sys_class` */

DROP TABLE IF EXISTS `sys_sys_class`;

CREATE TABLE `sys_sys_class` (
  `CLASS_CODE` varchar(4) NOT NULL COMMENT '分类编码：将相同功能组合为一类，由我们定义，与子系统有不同之处',
  `CLASS_NAME` varchar(50) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存权限分类编码参数信息';

/*Data for the table `sys_sys_class` */

/*Table structure for table `sys_systemguimenu` */

DROP TABLE IF EXISTS `sys_systemguimenu`;

CREATE TABLE `sys_systemguimenu` (
  `MENU_ID` varchar(7) CHARACTER SET latin1 NOT NULL COMMENT '菜单项标识：默认为“子系统编码＋四位序列”',
  `PARENT_MENU_ID` varchar(7) DEFAULT NULL,
  `SUBSYS_CODE` char(3) CHARACTER SET latin1 NOT NULL,
  `MENU_TITLE` varchar(30) DEFAULT NULL,
  `MENU_TEXT` varchar(100) DEFAULT NULL,
  `IMAGE_URL` varchar(50) DEFAULT NULL,
  `SHOW_ORDER` int(8) DEFAULT NULL,
  `CLASS_LEVEL` int(2) DEFAULT NULL,
  `DISPLAY_MODE` char(1) DEFAULT NULL,
  `RIGHT_CODE` varchar(30) DEFAULT NULL,
  `SHORT_KEY` varchar(20) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`),
  KEY `IDX_SYS_SYSMENU_SUBSYS` (`SUBSYS_CODE`),
  KEY `IDX_SYS_SYSMENU_RIGHTCODE` (`RIGHT_CODE`),
  CONSTRAINT `FK_REFERENCE_23` FOREIGN KEY (`SUBSYS_CODE`) REFERENCES `sys_subsys` (`SUBSYS_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存云平台所有GUI菜单信息';

/*Data for the table `sys_systemguimenu` */

insert  into `sys_systemguimenu`(`MENU_ID`,`PARENT_MENU_ID`,`SUBSYS_CODE`,`MENU_TITLE`,`MENU_TEXT`,`IMAGE_URL`,`SHOW_ORDER`,`CLASS_LEVEL`,`DISPLAY_MODE`,`RIGHT_CODE`,`SHORT_KEY`,`REMARK`,`UPDATE_TIME`,`UPDATE_STAFF_ID`,`UPDATE_DEPART_ID`) values 
('menu1',NULL,'dsj','大数据','大数据',NULL,NULL,NULL,NULL,'dsj_menu',NULL,NULL,NULL,NULL,NULL),
('menu2',NULL,'ypt','云平台','云平台',NULL,NULL,NULL,NULL,'ypt_menu',NULL,NULL,NULL,NULL,NULL),
('menu3','2','ypt','云平台111','云平台111',NULL,NULL,NULL,NULL,'ypt_menu',NULL,NULL,NULL,NULL,NULL),
('menu4','2','ypt','云平台2','云平台2',NULL,NULL,NULL,NULL,'ypt_menu',NULL,NULL,NULL,NULL,NULL),
('menu5',NULL,'dsj','大数据2222','大数据2222',NULL,NULL,NULL,NULL,'dsj_menu',NULL,NULL,NULL,NULL,NULL),
('menu6','2','sys','系统111','系统111',NULL,NULL,NULL,NULL,'sys_menu',NULL,NULL,NULL,NULL,NULL),
('menu7','2','sys','系统222','系统222',NULL,NULL,NULL,NULL,'sys_menu',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `sys_termipaddr` */

DROP TABLE IF EXISTS `sys_termipaddr`;

CREATE TABLE `sys_termipaddr` (
  `IP_START` varchar(15) NOT NULL,
  `IP_END` varchar(15) NOT NULL,
  `NET_SEG` varchar(3) NOT NULL COMMENT '网段：IP地址第二个点号与第三个点号之间的值',
  `ADDR_START` varchar(3) NOT NULL COMMENT 'IP起始值：对应IP起始地址最后一个点号后的值',
  `ADDR_END` varchar(3) NOT NULL COMMENT 'IP终止值：对应IP终止地址最后一个点号后的值',
  `TERM_NAME` varchar(50) DEFAULT NULL,
  `LOG_TAG` char(1) NOT NULL COMMENT '允许登录标志：0－不允许登录，1－允许登录',
  `DEPART_ID` varchar(5) NOT NULL,
  `FORCE_TAG` char(1) NOT NULL COMMENT '强制归属标志：0－不强制，1－强制,员工登录后,强制为IP地址所归属的部门和地域',
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`IP_START`,`IP_END`),
  KEY `IDX_SYS_TERMIPADDR_NETADDR` (`NET_SEG`,`ADDR_START`,`ADDR_END`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存登录BOSS系统的员工终端机器IP地址信息';

/*Data for the table `sys_termipaddr` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
