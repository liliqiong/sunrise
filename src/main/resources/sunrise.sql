/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 127.0.0.1
 Source Database       : sunrise

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 09/06/2017 09:23:18 AM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `conf_data`
-- ----------------------------
DROP TABLE IF EXISTS `conf_data`;
CREATE TABLE `conf_data` (
  `data_type` varchar(20) DEFAULT NULL,
  `text` varchar(20) DEFAULT NULL,
  `value` varchar(20) DEFAULT NULL,
  `memo` varchar(20) DEFAULT NULL,
  `data_group` int(11) DEFAULT NULL,
  KEY `group_index` (`data_group`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `conf_data`
-- ----------------------------
BEGIN;
INSERT INTO `conf_data` VALUES ('roleValid', '无效', '1', '角色表是否有效', '1'), ('roleVaild', '有效', '0', null, '1'), ('dataType', '资源权限', '0', '角色数据类型', '2'), ('dataType', '数据特权', '1', null, '2'), ('dataType', '网别', '9', null, '2'), ('dataType', '产品权限', 'P', null, '2'), (null, '资费权限', 'D', null, '2'), (null, '服务权限', 'S', null, '2'), (null, '包权限', 'K', null, '2'), ('roleAttr', '功能权限角色', '0', '角色属性', '3'), ('roleAttr', '资源数据权限角色', '1', '角色属性', '3'), ('roleAttr', '数据特权角色', '2', '角色属性', '3'), ('rightAttr', '菜单权限', '0', '权限属性', '4'), (null, '界面控制权限', '1', '权限属性', '4'), (null, '系统特权', '2', null, '4'), ('modType', 'GUI的DLL文件', '0', '库文件类型', '5'), (null, 'WEB地址', '1', null, '5'), ('rightClass', '无权限', '0', '权限级别', '6'), (null, '个人权限', '1', null, '6'), (null, '营业厅权限', '2', null, '6'), (null, '业务区域权限', '3', null, '6'), (null, '地州权限', '4', null, '6'), (null, '全省权限', '5', null, '6'), ('operSpecial', '可同级操作', '0', '操作特权', '7'), (null, '可越级操作', '1', null, '7'), ('sex', '男', '0', '性别', '8'), (null, '女', '1', null, '8'), ('dismissFlag', '正常', '0', null, '9'), (null, '离职', '1', null, '9'), ('loginFlag', '正常', '0', '登记标记', '10'), (null, '虚拟', '1', null, '10'), ('rightAttr', '数据权限', '0', '权限属性(数据)', '11'), (null, '数据角色权限', '1', null, '11'), ('rightFlag', '有效', '0', '权限是否可用', '12'), (null, '无效', '1', null, '12'), ('sysTag', '普通员工限制', '0', '系统限制标记', '13'), (null, '全体员工限制', '1', null, '13'), (null, '功能权限', '0', '权限属性(功能)', '14'), (null, '功能角色权限', '1', null, '14'), ('useTag', '按次数使用', '0', '使用标志', '15'), (null, '按时间范围使用', '1', null, '15'), ('ipTag', '黑名单', '0', '限制标记', '16'), (null, '白名单', '1', null, '16');
COMMIT;

-- ----------------------------
--  Table structure for `conf_entity`
-- ----------------------------
DROP TABLE IF EXISTS `conf_entity`;
CREATE TABLE `conf_entity` (
  `entity_name` varchar(50) NOT NULL,
  `primary_field` varchar(50) DEFAULT NULL,
  `create_url` varchar(30) DEFAULT NULL,
  `update_url` varchar(30) DEFAULT NULL,
  `delete_url` varchar(30) DEFAULT NULL,
  `query_sql` text,
  `title` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`entity_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `conf_entity`
-- ----------------------------
BEGIN;
INSERT INTO `conf_entity` VALUES ('sysDataright', null, null, null, null, 'select * from sys_dataright', '数据权限编码表'), ('sysDepart', null, null, null, null, 'select * from sys_depart', '部门/组织编码表'), ('sysFuncright', null, null, null, null, 'select * from sys_funcright', '功能权限编码表'), ('sysHidemenuitem', null, null, null, null, 'select * from sys_hidemenuitem', '菜单定制隐藏显示'), ('sysModfile', null, null, null, null, 'select * from sys_modfile', '模块编码表'), ('sysRole', 'role_code', null, null, null, 'select * from sys_role', '角色编码参数信息'), ('sysRoledataright', null, null, null, null, 'select * from sys_roledataright', '角色数据权限表'), ('sysRolefuncright', null, null, null, null, 'select * from sys_rolefuncright', '角色功能权限表'), ('sysStaff', null, null, null, null, 'select * from sys_staff', '员工编码表'), ('sysStaffauthcode', null, null, null, null, 'select * from sys_staffauthcode', '员工授权码表'), ('sysStaffdataright', null, null, null, null, 'select * from sys_staffdataright', '员工数据权限表'), ('sysStaffdatetime', null, null, null, null, 'select * from sys_staffdatetime', '员工登陆时间限制表'), ('sysStafffuncright', null, null, null, null, 'select * from sys_stafffuncright', '员工功能权限表'), ('sysStafftempdataright', null, null, null, null, 'select * from sys_stafftempdataright', '员工临时数据权限表'), ('sysStafftempfuncright', null, null, null, null, 'select * from sys_stafftempfuncright', '员工临时功能权限表'), ('sysStafftermipaddr', null, null, null, null, 'select * from sys_stafftermipaddr', '员工登录IP限制表'), ('sysSubsys', null, null, null, null, 'select * from sys_subsys', '子系统参数表'), ('sysSysClass', null, null, null, null, 'select * from sys_sys_class', '系统分类编码参数表'), ('sysSystemguimenu', null, null, null, null, 'select * from Sys_Systemguimenu', '系统GUI菜单'), ('sysTermipaddr', null, null, null, null, 'select * from sys_termipaddr', '终端IP地址表');
COMMIT;

-- ----------------------------
--  Table structure for `conf_fields`
-- ----------------------------
DROP TABLE IF EXISTS `conf_fields`;
CREATE TABLE `conf_fields` (
  `entity_name` varchar(50) NOT NULL,
  `column_index` int(11) NOT NULL,
  `field_name` varchar(50) NOT NULL,
  `field_type` varchar(10) NOT NULL,
  `field_text` varchar(50) NOT NULL,
  `init_valid` char(1) DEFAULT NULL,
  `hidden` char(1) NOT NULL,
  `renderer` text,
  `width` int(4) DEFAULT '100',
  `data_sql` varchar(500) DEFAULT NULL,
  `allow_blank` char(1) NOT NULL,
  `check_sql` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `conf_fields`
-- ----------------------------
BEGIN;
INSERT INTO `conf_fields` VALUES ('sysactiontype', '1', 'actiontype', 'int', '', null, '0', null, '100', null, '0', null), ('sysactiontype', '2', 'remark', 'string', '', null, '0', null, '100', null, '0', null), ('syscurrenttoken', '1', 'token', 'string', '', null, '0', null, '100', null, '0', null), ('syscurrenttoken', '2', 'staffid', 'string', '', null, '0', null, '100', null, '0', null), ('syscurrenttoken', '3', 'expirationtime', 'string', '', null, '0', null, '100', null, '0', null), ('syscurrenttoken', '4', 'requestip', 'string', '', null, '0', null, '100', null, '0', null), ('sysdataright', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('sysdataright', '2', 'dataCode', 'string', '数据编码', null, '0', null, '100', null, '1', 'select count(1) from sys_dataright where 1=1 and data_code=:dataCode'), ('sysdataright', '3', 'dataName', 'string', '数据名称', null, '0', null, '100', null, '1', 'select count(1) from sys_dataright where 1=1 and data_name=:dataName'), ('sysdataright', '4', 'rightType', 'string', '权限类型', null, '0', null, '100', null, '0', null), ('sysdataright', '5', 'orderIndex', 'int', '排序标识', null, '0', null, '100', null, '0', null), ('sysdataright', '6', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('sysdataright', '7', 'updateTime', 'date', '更新时间', null, '1', null, '100', null, '0', null), ('sysdataright', '8', 'updateStaffid', 'string', '更新员工', null, '1', null, '100', null, '0', null), ('sysDepart', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('sysDepart', '2', 'departId', 'string', '部门ID', null, '0', '', '100', null, '1', 'select count(1) from sys_depart where 1=1 and depart_id=:departId'), ('sysDepart', '3', 'departCode', 'string', '部门编码', null, '0', null, '100', null, '1', 'select count(1) from sys_depart where 1=1 and depart_code=:departCode'), ('sysDepart', '4', 'departName', 'string', '部门名称', null, '0', null, '100', null, '1', null), ('sysDepart', '5', 'validflag', 'string', '可用标识', null, '0', null, '100', 'select text,value from conf_data where data_group=1', '1', null), ('sysDepart', '6', 'parentDepartId', 'string', '上级部门ID', null, '0', null, '100', '', '0', null), ('sysDepart', '7', 'managerStaffId', 'string', '部门经理ID', null, '0', null, '100', 'select staff_name text,staff_id value from sys_staff', '1', null), ('sysDepart', '8', 'orderNo', 'int', '排序标识', null, '0', null, '100', null, '0', null), ('sysDepart', '9', 'startDate', 'date', '开始时间', null, '0', null, '100', null, '0', null), ('sysDepart', '10', 'endDate', 'date', '结束时间', null, '0', null, '100', null, '0', null), ('sysDepart', '11', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('sysfuncright', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('sysfuncright', '2', 'rightCode', 'string', '权限编码', null, '0', null, '100', null, '1', 'select count(1) from sys_funcright where 1=1 and right_code=:rightCode'), ('sysfuncright', '3', 'rightName', 'string', '权限名称', null, '0', null, '100', null, '1', null), ('sysfuncright', '4', 'classCode', 'string', '分类编码', null, '0', null, '100', null, '0', null), ('sysfuncright', '5', 'rightAttr', 'string', '权限属性', null, '0', null, '100', 'select text,value from conf_data where data_group=4', '1', null), ('sysfuncright', '6', 'modCode', 'string', '模块编码', null, '0', null, '100', 'select mod_name text,mod_code value from sys_modfile', '0', null), ('sysfuncright', '7', 'orderIndex', 'int', '排序标识', null, '0', null, '100', null, '0', null), ('sysfuncright', '8', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('sysfuncright', '9', 'updateTime', 'date', '跟新时间', null, '1', null, '100', null, '0', null), ('sysfuncright', '10', 'updateStaffId', 'string', '跟新员工ID', null, '1', null, '100', null, '0', null), ('sysfuncright', '11', 'updateDepartId', 'string', '跟新员工部门ID', null, '1', null, '100', null, '0', null), ('syshidemenuitem', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('syshidemenuitem', '2', 'staffId', 'string', '员工ID', null, '0', null, '100', 'select staff_name text,staff_id value from sys_staff', '1', null), ('syshidemenuitem', '3', 'menuId', 'string', '菜单ID', null, '0', null, '100', 'select menu_text text,menu_id value from sys_systemguimenu', '0', null), ('syshidemenuitem', '4', 'departId', 'string', '部门ID', null, '1', null, '100', null, '0', null), ('syshidemenuitem', '5', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('syshidemenuitem', '6', 'updateTime', 'date', '跟新时间', null, '1', null, '100', null, '0', null), ('syshidemenuitem', '7', 'updateStaffId', 'string', '跟新员工ID', null, '1', null, '100', null, '0', null), ('syshidemenuitem', '8', 'updateDepartId', 'string', '跟新员工部门ID', null, '1', null, '100', null, '0', null), ('sysmhstafftempdataright', '1', 'id', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '2', 'staffid', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '3', 'datacode', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '4', 'datatype', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '5', 'rightclass', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '6', 'operspecial', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '7', 'accredittime', 'date', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '8', 'accreditstaffid', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '9', 'usetag', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '10', 'times', 'int', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '11', 'usedtimes', 'int', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '12', 'startdate', 'date', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '13', 'enddate', 'date', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '14', 'termip', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '15', 'remark', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '16', 'updatetime', 'date', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '17', 'updatestaffid', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempdataright', '18', 'updatedepartid', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempfuncright', '1', 'id', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempfuncright', '2', 'staffid', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempfuncright', '3', 'rightcode', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempfuncright', '4', 'accredittime', 'date', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempfuncright', '5', 'accreditstaffid', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempfuncright', '6', 'usetag', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempfuncright', '7', 'times', 'int', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempfuncright', '8', 'usedtimes', 'int', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempfuncright', '9', 'startdate', 'date', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempfuncright', '10', 'enddate', 'date', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempfuncright', '11', 'termip', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempfuncright', '12', 'remark', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempfuncright', '13', 'updatetime', 'date', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempfuncright', '14', 'updatestaffid', 'string', '', null, '0', null, '100', null, '0', null), ('sysmhstafftempfuncright', '15', 'updatedepartid', 'string', '', null, '0', null, '100', null, '0', null), ('sysmodfile', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('sysmodfile', '2', 'modCode', 'string', '模块编码', null, '0', null, '100', null, '1', 'select count(1) from sys_modfile where 1=1 and mod_code=:modCode'), ('sysmodfile', '3', 'modName', 'string', '模块名称', null, '0', null, '100', null, '1', null), ('sysmodfile', '4', 'modType', 'string', '库文件类型', null, '0', null, '100', 'select text,value from conf_data where data_group=5', '1', null), ('sysmodfile', '5', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('sysmodfile', '6', 'updateTime', 'date', '跟新时间', null, '1', null, '100', null, '0', null), ('sysmodfile', '7', 'updateStaffId', 'string', '跟新员工ID', null, '1', null, '100', null, '0', null), ('sysmodfile', '8', 'updateDepartId', 'string', '跟新员工部门ID', null, '1', null, '100', null, '0', null), ('sysrightloghis', '1', 'rightCode', 'string', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '2', 'operedStaffid', 'string', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '3', 'rightattr', 'string', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '4', 'logid', 'string', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '5', 'opertype', 'string', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '6', 'righttype', 'string', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '7', 'rolecode', 'string', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '8', 'areacode', 'string', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '9', 'operstaffid', 'string', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '10', 'operdepartid', 'string', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '11', 'operdate', 'date', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '12', 'rightclass', 'string', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '13', 'operspecial', 'string', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '14', 'termip', 'string', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '15', 'usetag', 'string', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '16', 'times', 'int', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '17', 'startdate', 'date', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '18', 'enddate', 'date', '', null, '0', null, '100', null, '0', null), ('sysrightloghis', '19', 'remark', 'string', '', null, '0', null, '100', null, '0', null), ('sysRole', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('sysRole', '2', 'roleCode', 'string', '角色编码', null, '0', null, '100', null, '1', 'select count(1) from sys_role where 1=1 and role_code=:roleCode'), ('sysRole', '3', 'dataCode', 'string', '数据编码', null, '0', null, '100', null, '0', null), ('sysRole', '4', 'dataType', 'string', '数据类型', null, '0', null, '100', 'select text,value from conf_data where data_group=2', '1', null), ('sysRole', '5', 'roleName', 'string', '角色名称', null, '0', null, '100', null, '1', null), ('sysRole', '6', 'roleAttr', 'string', '角色属性', null, '0', null, '100', 'select text,value from conf_data where data_group=3', '1', null), ('sysRole', '7', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('sysRole', '8', 'validflag', 'string', '是否有效', null, '0', null, '100', 'select text,value from conf_data where data_group=1', '1', null), ('sysRole', '9', 'updateTime', 'date', '跟新时间', null, '1', null, '100', null, '0', null), ('sysRole', '10', 'updateStaffId', 'string', '跟新员工', null, '1', null, '100', null, '0', null), ('sysroledataright', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('sysroledataright', '2', 'roleCode', 'string', '角色编码', null, '0', null, '100', 'select role_name text,role_code value from sys_role', '1', null), ('sysroledataright', '3', 'dataCode', 'string', '数据编码', null, '0', null, '100', 'select data_name text,data_code value from sys_dataright', '1', null), ('sysroledataright', '4', 'dataType', 'string', '数据类型', null, '0', null, '100', 'select text,value from conf_data where data_group=2', '1', null), ('sysroledataright', '5', 'rightClass', 'string', '权限级别', null, '0', null, '100', 'select text,value from conf_data where data_group=6', '1', null), ('sysroledataright', '6', 'operSpecial', 'string', '操作特权', null, '0', null, '100', 'select text,value from conf_data where data_group=7', '1', null), ('sysroledataright', '7', 'updaTetime', 'date', '跟新时间', null, '1', null, '100', null, '0', null), ('sysroledataright', '8', 'updateStaffId', 'string', '跟新员工ID', null, '1', null, '100', null, '0', null), ('sysroledataright', '9', 'updateDepartId', 'string', '跟新员工部门ID', null, '1', null, '100', null, '0', null), ('sysrolefuncright', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('sysrolefuncright', '2', 'roleCode', 'string', '角色编码', null, '0', null, '100', 'select role_name text,role_code value from sys_role where role_attr=0', '1', null), ('sysrolefuncright', '3', 'rightCode', 'string', '权限编码', null, '0', null, '100', 'select right_name text,right_code value from sys_funcright', '1', null), ('sysrolefuncright', '4', 'updateTime', 'date', '跟新时间', null, '1', null, '100', null, '0', null), ('sysrolefuncright', '5', 'updateStaffId', 'string', '跟新员工ID', null, '1', null, '100', null, '0', null), ('sysrolefuncright', '6', 'updateDepartId', 'string', '跟新员工部门ID', null, '1', null, '100', null, '0', null), ('sysstaff', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('sysstaff', '2', 'staffId', 'string', '员工ID', null, '0', null, '100', null, '1', 'select count(1) from sys_staff where 1=1 and staff_id=:staffId'), ('sysstaff', '3', 'departId', 'string', '部门ID', null, '0', null, '100', 'select depart_name text,depart_id value from sys_depart', '1', null), ('sysstaff', '4', 'staffName', 'string', '姓名', null, '0', null, '100', null, '1', null), ('sysstaff', '5', 'jobCode', 'string', '工作编码', null, '0', null, '100', null, '0', null), ('sysstaff', '6', 'managerInfo', 'string', '上级信息', null, '0', null, '100', null, '0', null), ('sysstaff', '7', 'sex', 'string', '性别', null, '0', null, '100', 'select text,value from conf_data where data_group=8', '0', null), ('sysstaff', '8', 'email', 'string', 'EMAIL', null, '0', null, '100', null, '1', 'select count(1) from sys_staff where 1=1 and email=:email'), ('sysstaff', '9', 'userPid', 'string', 'UerPid', null, '0', null, '100', null, '0', null), ('sysstaff', '10', 'serialNumber', 'string', ' 电话号码', null, '0', null, '100', null, '1', 'select count(1) from sys_staff where 1=1 and serial_number=:serialNumber'), ('sysstaff', '11', 'dimissionTag', 'string', '离职标识', null, '0', null, '100', 'select text,value from conf_data where data_group=9', '1', null), ('sysstaff', '12', 'birthday', 'date', '生日', null, '0', null, '100', null, '0', null), ('sysstaff', '13', 'custHobyy', 'string', 'custHobyy', null, '0', null, '100', null, '0', null), ('sysstaff', '14', 'managerStaffid', 'string', '上级ID', null, '0', null, '100', null, '0', null), ('sysstaff', '15', 'loginFlag', 'string', '登记标记', null, '0', null, '100', 'select text,value from conf_data where data_group=10', '0', null), ('sysstaff', '16', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('sysstaff', '17', 'startDate', 'date', '起始有效时间', null, '0', null, '100', null, '0', null), ('sysstaff', '18', 'endDate', 'date', '终止有效时间', null, '0', null, '100', null, '0', null), ('sysstaff', '19', 'updateTime', 'date', '跟新时间', null, '1', null, '100', null, '0', null), ('sysstaff', '20', 'updateStaffId', 'string', '跟新员工ID', null, '1', null, '100', null, '0', null), ('sysstaff', '21', 'updateDepartId', 'string', '跟新员工部门ID', null, '1', null, '100', null, '0', null), ('sysstaffauthcode', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('sysstaffauthcode', '2', 'staffId', 'string', '员工ID', null, '0', null, '100', 'select staff_name text,staff_id value from sys_staff', '1', ''), ('sysstaffauthcode', '3', 'webPasswd', 'string', '授权码', null, '0', null, '100', null, '1', null), ('sysstaffauthcode', '4', 'strData', 'date', '开始时间', null, '0', null, '100', null, '1', null), ('sysstaffauthcode', '5', 'endData', 'date', '结束时间', null, '0', null, '100', null, '1', null), ('sysstaffauthcode', '6', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('sysstaffauthcode', '7', 'updateTime', 'date', '跟新时间', null, '1', null, '100', null, '0', null), ('sysstaffauthcode', '8', 'updateStaffId', 'string', '跟新员工ID', null, '1', null, '100', null, '0', null), ('sysstaffauthcode', '9', 'updateDepartId', 'string', '跟新员工部门ID', null, '1', null, '100', null, '0', null), ('sysstaffdataright', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('sysstaffdataright', '2', 'staffId', 'string', '员工ID', null, '0', null, '100', 'select staff_name text,staff_id value from sys_staff', '1', null), ('sysstaffdataright', '3', 'dataCode', 'string', '权限或角色编码', null, '0', null, '100', 'select data_name text,data_code value from sys_dataright', '1', null), ('sysstaffdataright', '4', 'dataType', 'string', '数据类型', null, '0', null, '100', 'select text ,value from conf_data where data_group=2', '1', null), ('sysstaffdataright', '5', 'rightAttr', 'string', '权限属性', null, '0', 'function(){\n     var value=this.getValue();\n     var combo=this.up(\'form\').down(\'[name=\"dataCode\"]\');\n     combo.clearValue();\n     var classCombo=this.up(\'form\').down(\'[name=\"rightClass\"]\');\n     var opCombo=this.up(\'form\').down(\'[name=\"operSpecial\"]\');\n     if(value==\'0\'){\n        combo.store.getProxy().setExtraParam(\'sql\',\'select data_name text,data_code value from sys_dataright\');\n	combo.store.load();\n	classCombo.enable();\n	opCombo.enable();\n     }else if(value==\'1\'){\n	combo.store.getProxy().setExtraParam(\'sql\',\'select role_name text,role_code value from sys_role where role_attr=1\');\n	combo.store.load();\n	classCombo.setValue(null);\n	classCombo.disable();\n	opCombo.setValue(null);\n	opCombo.disable();\n     }\n}', '100', 'select text,value from conf_data where data_group=11', '1', null), ('sysstaffdataright', '6', 'rightClass', 'string', '权限级别', null, '0', null, '100', 'select text,value from conf_data where data_group=6', '0', null), ('sysstaffdataright', '7', 'operSpecial', 'string', '操作特权', null, '0', null, '100', 'select text,value from conf_data where data_group=7', '0', null), ('sysstaffdataright', '8', 'rightTag', 'string', '权限标志', null, '0', null, '100', 'select text,value from conf_data where data_group=12', '0', null), ('sysstaffdataright', '9', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('sysstaffdataright', '10', 'accreditTime', 'date', '授权时间', null, '0', null, '100', null, '0', null), ('sysstaffdataright', '11', 'accreditStaffid', 'string', '授权员工ID', null, '0', null, '100', null, '0', null), ('sysstaffdatetime', '1', 'id', 'string', 'ID ', null, '1', null, '100', null, '0', null), ('sysstaffdatetime', '2', 'limitId', 'string', 'LIMID', null, '0', null, '100', null, '1', null), ('sysstaffdatetime', '3', 'staffId', 'string', '员工ID', null, '0', null, '100', 'select staff_name text,staff_id value from sys_staff', '1', null), ('sysstaffdatetime', '4', 'sysTag', 'string', '系统限制标记', null, '0', null, '100', 'select text,value from conf_data where data_group=13', '1', null), ('sysstaffdatetime', '5', 'startDate', 'date', '开始限制时间', null, '0', null, '100', null, '1', null), ('sysstaffdatetime', '6', 'endDate', 'date', '结束限制时间', null, '0', null, '100', null, '1', null), ('sysstaffdatetime', '7', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('sysstaffdatetime', '8', 'updateTime', 'date', '跟新时间', null, '1', null, '100', null, '0', null), ('sysstaffdatetime', '9', 'updateStaffId', 'string', '跟新员工ID', null, '1', null, '100', null, '0', null), ('sysstaffdatetime', '10', 'updateDepartId', 'string', '跟新员工部门ID', null, '1', null, '100', null, '0', null), ('sysstafffuncright', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('sysstafffuncright', '2', 'staffId', 'string', '员工ID', null, '0', null, '100', 'select staff_name text,staff_id value from sys_staff', '1', null), ('sysstafffuncright', '3', 'rightCode', 'string', '权限或角色编码', null, '0', null, '100', 'select role_name text,role_code value from sys_role where role_attr=0', '1', null), ('sysstafffuncright', '4', 'rightAttr', 'string', '权限属性', null, '0', 'function(){\n    var value=this.getValue();\n    var combo=this.up(\'form\').down(\'[name=\"rightCode\"]\');\n    if(value==\'0\'){\n        combo.setValue(null);\n        combo.store.getProxy().setExtraParam(\'sql\',\'select right_name text,right_code value from sys_funcright\');\n	combo.store.load();\n    }else if(value==\'1\'){\n        combo.setValue(null);\n        combo.store.getProxy().setExtraParam(\'sql\',\'select role_name text,role_code value from sys_role where role_attr=0\');\n	combo.store.load();\n    }\n}', '100', 'select text,value from conf_data where data_group=14', '1', null), ('sysstafffuncright', '5', 'rightTag', 'string', '权限标志', null, '0', null, '100', 'select text,value from conf_data where data_group=12', '1', null), ('sysstafffuncright', '6', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('sysstafffuncright', '7', 'accreditTime', 'date', '跟新时间', null, '1', null, '100', null, '0', null), ('sysstafffuncright', '8', 'accreditStaffId', 'string', '跟新员工ID', null, '1', null, '100', null, '0', null), ('sysstaffpasswd', '1', 'id', 'string', '', null, '0', null, '100', null, '0', null), ('sysstaffpasswd', '2', 'staffId', 'string', '', null, '0', null, '100', null, '0', null), ('sysstaffpasswd', '3', 'staffpasswd', 'string', '', null, '0', null, '100', null, '0', null), ('sysstaffpasswd', '4', 'updatetime', 'date', '', null, '0', null, '100', null, '0', null), ('sysstaffpasswd', '5', 'updatestaffid', 'string', '', null, '0', null, '100', null, '0', null), ('sysstaffpasswd', '6', 'updatedepartid', 'string', '', null, '0', null, '100', null, '0', null), ('sysstafftempdataright', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('sysstafftempdataright', '2', 'staffId', 'string', '员工ID', null, '0', null, '100', 'select staff_name text,staff_id value from sys_staff', '1', null), ('sysstafftempdataright', '3', 'dataCode', 'string', '数据编码', null, '0', null, '100', 'select data_name text,data_code value from sys_dataright', '1', null), ('sysstafftempdataright', '4', 'dataType', 'string', '数据类型', null, '0', null, '100', 'select text,value from conf_data where data_group=2', '0', null), ('sysstafftempdataright', '5', 'rightClass', 'string', '权限类型', null, '0', null, '100', 'select text,value from conf_data where data_group=6', '0', null), ('sysstafftempdataright', '6', 'operSpecial', 'string', '操作特权', null, '0', null, '100', 'select text,value from conf_data where data_group=7', '0', null), ('sysstafftempdataright', '7', 'accreditTime', 'date', '授权时间', null, '0', null, '100', null, '0', null), ('sysstafftempdataright', '8', 'accreditStaffid', 'string', '授权员工ID', null, '0', null, '100', null, '0', null), ('sysstafftempdataright', '9', 'useTag', 'string', '使用标志', null, '0', 'function(){\n\n     switch(this.getValue()){\n	case \'0\':\nthis.up(\'form\').down(\'[name=\"startDate\"]\').disable();\nthis.up(\'form\').down(\'[name=\"endDate\"]\').disable();\nthis.up(\'form\').down(\'[name=\"startDate\"]\').setValue(null);\nthis.up(\'form\').down(\'[name=\"endDate\"]\').setValue(null);\nthis.up(\'form\').down(\'[name=\"times\"]\').enable();\nthis.up(\'form\').down(\'[name=\"usedTimes\"]\').enable();\nbreak;\n	case \'1\':\nthis.up(\'form\').down(\'[name=\"times\"]\').disable();\nthis.up(\'form\').down(\'[name=\"usedTimes\"]\').disable();\nthis.up(\'form\').down(\'[name=\"times\"]\').setValue(null);\nthis.up(\'form\').down(\'[name=\"usedTimes\"]\').setValue(null);\nthis.up(\'form\').down(\'[name=\"startDate\"]\').enable();\nthis.up(\'form\').down(\'[name=\"endDate\"]\').enable();\nbreak;\n     }\n}', '100', 'select text,value from conf_data where data_group=15', '1', null), ('sysstafftempdataright', '10', 'times', 'int', '可用次数', null, '0', null, '100', null, '0', null), ('sysstafftempdataright', '11', 'usedTimes', 'int', '已经使用次数', null, '0', null, '100', null, '0', null), ('sysstafftempdataright', '12', 'startDate', 'date', '可用开始时间', null, '0', null, '100', null, '0', null), ('sysstafftempdataright', '13', 'endDate', 'date', '可用结束时间', null, '0', null, '100', null, '0', null), ('sysstafftempdataright', '14', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('sysstafftempdataright', '15', 'updateTime', 'date', '跟新时间', null, '1', null, '100', null, '0', null), ('sysstafftempdataright', '16', 'updateStaffId', 'string', '跟新员工ID', null, '1', null, '100', null, '0', null), ('sysstafftempdataright', '17', 'updateDepartId', 'string', '跟新员工部门ID', null, '1', null, '100', null, '0', null), ('sysstafftempfuncright', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('sysstafftempfuncright', '2', 'staffId', 'string', '员工ID', null, '0', null, '100', 'select staff_name text,staff_id value from sys_staff', '1', null), ('sysstafftempfuncright', '3', 'rightCode', 'string', '功能编码', null, '0', null, '100', 'select right_name text ,right_code value from sys_funcright', '1', null), ('sysstafftempfuncright', '4', 'accreditTime', 'date', '授权时间', null, '0', null, '100', null, '0', null), ('sysstafftempfuncright', '5', 'accreditStaffId', 'string', '授权员工ID', null, '0', null, '100', null, '0', null), ('sysstafftempfuncright', '6', 'useTag', 'string', '使用标志', null, '0', 'function(){\n     switch(this.getValue()){\n	case \'0\':\nthis.up(\'form\').down(\'[name=\"startDate\"]\').disable();\nthis.up(\'form\').down(\'[name=\"endDate\"]\').disable();\nthis.up(\'form\').down(\'[name=\"startDate\"]\').setValue(null);\nthis.up(\'form\').down(\'[name=\"endDate\"]\').setValue(null);\nthis.up(\'form\').down(\'[name=\"times\"]\').enable();\nthis.up(\'form\').down(\'[name=\"usedTimes\"]\').enable();\nbreak;\n	case \'1\':\nthis.up(\'form\').down(\'[name=\"times\"]\').disable();\nthis.up(\'form\').down(\'[name=\"usedTimes\"]\').disable();\nthis.up(\'form\').down(\'[name=\"times\"]\').setValue(null);\nthis.up(\'form\').down(\'[name=\"usedTimes\"]\').setValue(null);\nthis.up(\'form\').down(\'[name=\"startDate\"]\').enable();\nthis.up(\'form\').down(\'[name=\"endDate\"]\').enable();\nbreak;\n     }\n}', '100', 'select text,value from conf_data where data_group=15', '1', null), ('sysstafftempfuncright', '7', 'times', 'int', '可用次数', null, '0', null, '100', null, '0', null), ('sysstafftempfuncright', '8', 'usedTimes', 'int', '使用次数', null, '0', null, '100', null, '0', null), ('sysstafftempfuncright', '9', 'startDate', 'date', '可用开始时间', null, '0', null, '100', null, '0', null), ('sysstafftempfuncright', '10', 'endDate', 'date', '可用结束时间', null, '0', null, '100', null, '0', null), ('sysstafftempfuncright', '11', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('sysstafftempfuncright', '12', 'updateTime', 'date', '跟新时间', null, '1', null, '100', null, '0', null), ('sysstafftempfuncright', '13', 'updateStaffid', 'string', '跟新员工ID', null, '1', null, '100', null, '0', null), ('sysstafftempfuncright', '14', 'updateDepartid', 'string', '跟新员工部门ID', null, '1', null, '100', null, '0', null), ('sysstafftermipaddr', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('sysstafftermipaddr', '2', 'staffId', 'string', '员工ID', null, '0', null, '100', 'select staff_name text,staff_id value from sys_staff', '1', null), ('sysstafftermipaddr', '3', 'ipStart', 'string', '起始IP', null, '0', null, '100', null, '0', null), ('sysstafftermipaddr', '4', 'ipEnd', 'string', '结束IP', null, '0', null, '100', null, '0', null), ('sysstafftermipaddr', '5', 'sysTag', 'string', 'IP限制标记', null, '0', null, '100', 'select text,value from conf_data where data_group=16', '0', null), ('sysstafftermipaddr', '6', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('sysstafftermipaddr', '7', 'updateTime', 'date', '跟新时间', null, '1', null, '100', null, '0', null), ('sysstafftermipaddr', '8', 'updateStaffid', 'string', '跟新员工ID', null, '1', null, '100', null, '0', null), ('sysstafftermipaddr', '9', 'updateDepartid', 'string', '跟新员工部门ID', null, '1', null, '100', null, '0', null), ('syssubsys', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('syssubsys', '2', 'subsysCode', 'string', '子系统编码', null, '0', null, '100', null, '1', 'select count(1) from sys_subsys where 1=1 and subsys_code=:subsysCode'), ('syssubsys', '3', 'subsysName', 'string', '子系统名称', null, '0', null, '100', null, '1', null), ('syssubsys', '4', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('syssubsys', '5', 'updateTime', 'date', '跟新时间', null, '1', null, '100', null, '0', null), ('syssubsys', '6', 'updateStaffId', 'string', '跟新员工ID', null, '1', null, '100', null, '0', null), ('syssubsys', '7', 'updateDepartId', 'string', '跟新员工部门ID', null, '1', null, '100', null, '0', null), ('syssysclass', '1', 'id', 'string', 'ID', null, '0', null, '100', null, '0', null), ('syssysclass', '2', 'classCode', 'string', '分类编码', null, '0', null, '100', null, '0', null), ('syssysclass', '3', 'className', 'string', '分类名称', null, '0', null, '100', null, '0', null), ('syssysclass', '4', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('syssysclass', '5', 'updateTime', 'date', '跟新时间', null, '0', null, '100', null, '0', null), ('syssysclass', '6', 'updateStaffId', 'string', '跟新员工ID', null, '0', null, '100', null, '0', null), ('syssysclass', '7', 'updateDepartId', 'string', '跟新员工部门ID', null, '0', null, '100', null, '0', null), ('syssystemguimenu', '1', 'id', 'string', 'ID', null, '1', null, '100', null, '0', null), ('syssystemguimenu', '2', 'menuId', 'string', '菜单ID', null, '0', null, '100', null, '1', 'select count(1) from sys_systemguimenu where 1=1 and menu_id=:menuId'), ('syssystemguimenu', '3', 'parentMenuId', 'string', '父菜单ID', null, '0', null, '100', null, '0', null), ('syssystemguimenu', '4', 'subsysCode', 'string', '子系统编码', null, '0', null, '100', 'select subsys_name text,subsys_code value from sys_subsys', '0', null), ('syssystemguimenu', '5', 'menuTitle', 'string', '菜单标题', null, '0', null, '100', null, '0', null), ('syssystemguimenu', '6', 'menuText', 'string', '菜单说明', null, '0', null, '100', null, '0', null), ('syssystemguimenu', '7', 'imageUrl', 'string', '图片URL', null, '0', null, '100', null, '0', null), ('syssystemguimenu', '8', 'showOrder', 'int', '现实顺序', null, '0', null, '100', null, '0', null), ('syssystemguimenu', '9', 'classLevel', 'int', '级别', null, '0', null, '100', null, '0', null), ('syssystemguimenu', '10', 'displayMode', 'string', '显示方式', null, '0', null, '100', null, '0', null), ('syssystemguimenu', '11', 'rightCode', 'string', '权限编码', null, '0', null, '100', 'select right_name text,right_code value from sys_funcright', '1', null), ('syssystemguimenu', '12', 'shortKey', 'string', '快捷键', null, '0', null, '100', null, '0', null), ('syssystemguimenu', '13', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('syssystemguimenu', '14', 'updateTime', 'date', '跟新时间', null, '1', null, '100', null, '0', null), ('syssystemguimenu', '15', 'updateStaffId', 'string', '跟新员工', null, '1', null, '100', null, '0', null), ('syssystemguimenu', '16', 'updateDepartId', 'string', '跟新员工部门ID', null, '1', null, '100', null, '0', null), ('systermipaddr', '1', 'id', 'string', 'ID', null, '0', null, '100', null, '0', null), ('systermipaddr', '2', 'ipStart', 'string', '开始IP', null, '0', null, '100', null, '0', null), ('systermipaddr', '3', 'ipEnd', 'string', '结束IP', null, '0', null, '100', null, '0', null), ('systermipaddr', '4', 'netSeg', 'string', '网段', null, '0', null, '100', null, '0', null), ('systermipaddr', '5', 'addrStart', 'string', 'IP启始值', null, '0', null, '100', null, '0', null), ('systermipaddr', '6', 'addrEnd', 'string', 'IP终止值', null, '0', null, '100', null, '0', null), ('systermipaddr', '7', 'termName', 'string', '终端名称', null, '0', null, '100', null, '0', null), ('systermipaddr', '8', 'logTag', 'string', '允许登陆标示', null, '0', null, '100', null, '0', null), ('systermipaddr', '9', 'departId', 'string', '部门/组织标识', null, '0', null, '100', null, '0', null), ('systermipaddr', '10', 'forceTag', 'string', '强制归属标志', null, '0', null, '100', null, '0', null), ('systermipaddr', '11', 'remark', 'string', '备注', null, '0', null, '100', null, '0', null), ('systermipaddr', '12', 'updateTime', 'date', '跟新时间', null, '0', null, '100', null, '0', null), ('systermipaddr', '13', 'updateStaffId', 'string', '跟新员工ID', null, '0', null, '100', null, '0', null), ('systermipaddr', '14', 'updateDepartId', 'string', '跟新员工部门ID', null, '0', null, '100', null, '0', null);
COMMIT;

-- ----------------------------
--  Table structure for `conf_related`
-- ----------------------------
DROP TABLE IF EXISTS `conf_related`;
CREATE TABLE `conf_related` (
  `entity_name` varchar(30) DEFAULT NULL,
  `field_name` varchar(30) DEFAULT NULL,
  `related_field` varchar(30) DEFAULT NULL,
  `related_value` varchar(10) DEFAULT NULL,
  `disable_field` varchar(100) DEFAULT NULL,
  `data_sql` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `conf_related`
-- ----------------------------
BEGIN;
INSERT INTO `conf_related` VALUES ('sysstaffdataright', 'dataCode', 'rightAttr', '0', null, 'select data_name text,data_code value from sys_dataright'), ('sysstaffdataright', 'dataCode', 'rightAttr', '1', 'operSpecial,rightClass', 'select role_name text,role_code value from sys_role where role_attr=1'), ('sysstafffuncright', 'rightCode', 'rightAttr', '0', null, 'select right_name text,right_code value from sys_funcright'), ('sysstafffuncright', 'rightCode', 'rightAttr', '1', null, 'select role_name text,role_code value from sys_role where role_attr=0'), ('sysstafftempfuncright', null, 'useTag', '0', 'startDate,endDate', null), ('sysstafftempfuncright', null, 'useTag', '1', 'times,usedTimes', null), ('sysstafftempdataright', null, 'useTag', '0', 'startDate,endDate', null), ('sysstafftempdataright', null, 'useTag', '1', 'times,usedTimes', null);
COMMIT;

-- ----------------------------
--  Table structure for `conf_tree`
-- ----------------------------
DROP TABLE IF EXISTS `conf_tree`;
CREATE TABLE `conf_tree` (
  `id` int(11) NOT NULL,
  `level` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `text` varchar(50) DEFAULT NULL,
  `table_name` varchar(50) DEFAULT NULL,
  `entity_name` varchar(50) DEFAULT NULL,
  `leaf` char(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `conf_tree`
-- ----------------------------
BEGIN;
INSERT INTO `conf_tree` VALUES ('3', '1', '0', '角色编码表', 'sys_role', 'sysRole', 'true'), ('4', '1', '0', '数据权限编码表', 'SysDataright', 'sysDataright', 'true'), ('5', '1', '0', '部门/组织编码表', 'SysDepart', 'sysDepart', 'true'), ('6', '1', '0', '功能权限编码表', 'SysFuncright', 'sysFuncright', 'true'), ('7', '1', '0', '菜单定制隐藏显示', 'SysHidemenuitem', 'sysHidemenuitem', 'true'), ('8', '1', '0', '模块编码表', 'SysModfile', 'sysModfile', 'true'), ('9', '1', '0', '角色数据权限表', 'SysRoledataright', 'sysRoledataright', 'true'), ('10', '1', '0', '角色功能权限表', 'SysRolefuncright', 'sysRolefuncright', 'true'), ('11', '1', '0', '员工编码表', 'SysStaff', 'sysStaff', 'true'), ('12', '1', '0', '员工授权码表', 'SysStaffauthcode', 'sysStaffauthcode', 'true'), ('13', '1', '0', '员工数据权限表', 'SysStaffdataright', 'sysStaffdataright', 'true'), ('14', '1', '0', '员工登陆时间限制表', 'SysStaffdatetime', 'sysStaffdatetime', 'true'), ('15', '1', '0', '员工功能权限表', 'SysStafffuncright', 'sysStafffuncright', 'true'), ('16', '1', '0', '员工临时数据权限表', 'SysStafftempdataright', 'sysStafftempdataright', 'true'), ('17', '1', '0', '员工登录IP限制表', 'SysStafftermipaddr', 'sysStafftermipaddr', 'true'), ('18', '1', '0', '子系统参数表', 'SysSubsys', 'sysSubsys', 'true'), ('19', '1', '0', '系统分类编码参数表', 'SysSysClass', 'sysSysClass', 'true'), ('20', '1', '0', '系统GUI菜单表', 'SysSystemguimenu', 'sysSystemguimenu', 'true'), ('21', '1', '0', '终端IP地址表', 'SysTermipaddr', 'sysTermipaddr', 'true'), ('22', '1', '0', '员工临时功能权限表', 'sysStafftempfuncright', 'sysStafftempfuncright', 'true');
COMMIT;

-- ----------------------------
--  Table structure for `log_h_operate`
-- ----------------------------
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

-- ----------------------------
--  Table structure for `log_operate`
-- ----------------------------
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

-- ----------------------------
--  Table structure for `log_rightl`
-- ----------------------------
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

-- ----------------------------
--  Table structure for `log_staff`
-- ----------------------------
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

-- ----------------------------
--  Table structure for `log_staff_his`
-- ----------------------------
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

-- ----------------------------
--  Table structure for `sys_action_type`
-- ----------------------------
DROP TABLE IF EXISTS `sys_action_type`;
CREATE TABLE `sys_action_type` (
  `ACTION_TYPE` int(2) NOT NULL,
  `REMARK` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ACTION_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `sys_current_token`
-- ----------------------------
DROP TABLE IF EXISTS `sys_current_token`;
CREATE TABLE `sys_current_token` (
  `token` varchar(50) NOT NULL,
  `staff_id` varchar(8) NOT NULL,
  `expiration_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `request_ip` varchar(20) NOT NULL,
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_current_token`
-- ----------------------------
BEGIN;
INSERT INTO `sys_current_token` VALUES ('2bf566bd-8eac-43da-951b-e5e1ac2c8f64', 'syu', '2017-09-05 15:48:25', '192.168.1.192');
COMMIT;

-- ----------------------------
--  Table structure for `sys_dataright`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dataright`;
CREATE TABLE `sys_dataright` (
  `id` varchar(36) DEFAULT NULL,
  `DATA_CODE` varchar(30) NOT NULL COMMENT '数据编码： 产品、资费和服务等权限采用其对应的参数编码，其它类型权限采用有意义的字母表示',
  `DATA_NAME` varchar(50) DEFAULT NULL,
  `RIGHT_TYPE` char(4) NOT NULL DEFAULT '1000' COMMENT '权限类型：',
  `ORDER_INDEX` int(12) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`DATA_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存数据权限信息，包含资源、数据特权等相关权限集合';

-- ----------------------------
--  Records of `sys_dataright`
-- ----------------------------
BEGIN;
INSERT INTO `sys_dataright` VALUES ('defbe119-ea1f-4f9e-ad1f-6adcebb5d40a', 'data_1', '地质数据', '1000', '1', 'jkjkkjk', '2017-08-14', 'syu'), ('594d1a55-3ef3-4f9a-acd7-4d927e8f7304', 'data_2', '地理数据', '1000', '2', '', '2017-08-03', ''), ('94e23b83-7c42-4762-8468-9c14bc879289', 'data_3', '什么数据', '1000', null, null, null, null), ('2474f28c-3def-4a9a-bf21-42a8f70546ad', 'data_4', '??数据', '1000', null, null, null, null), ('71c50db3ca1e415eac682a8fa2639be9', 'data_5', '权限数九', '1000', '5', '过后就哭了', '2017-08-13', null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_depart`
-- ----------------------------
DROP TABLE IF EXISTS `sys_depart`;
CREATE TABLE `sys_depart` (
  `id` varchar(36) DEFAULT NULL,
  `DEPART_ID` varchar(5) NOT NULL,
  `DEPART_CODE` varchar(8) NOT NULL,
  `DEPART_NAME` varchar(50) DEFAULT NULL,
  `VALIDFLAG` char(1) NOT NULL COMMENT '有效标记：0－有效，1－失效（注销）',
  `level` int(11) DEFAULT NULL,
  `PARENT_DEPART_ID` varchar(5) DEFAULT NULL,
  `MANAGER_STAFF_ID` varchar(8) DEFAULT NULL COMMENT '部门管理者：部门经理',
  `ORDER_NO` int(3) NOT NULL COMMENT '序号：树状结构信息生成时的显示顺序(同级部门/组织的优先级关系)',
  `START_DATE` date NOT NULL,
  `END_DATE` date DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`DEPART_ID`),
  KEY `IDX_SYS_DEPART_DEPARTCODE` (`DEPART_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门组织表';

-- ----------------------------
--  Records of `sys_depart`
-- ----------------------------
BEGIN;
INSERT INTO `sys_depart` VALUES ('4f2a5133-70b0-4209-818f-b937a57b1a00', '0', 'bzkj', '步桌科技', '0', '0', '', 'docZuo', '0', '2017-07-01', '2017-08-31', ''), ('660808d8-2d89-4bcc-ad0c-1334c7194c35', '1', 'technic', '技术部', '0', '1', '0', 'docZhao', '1', '2017-07-01', null, null), ('bc31dd19-2f3e-40af-9c6c-5efd25158949', '2', 'cloud', '云平台', '0', '1', '1', 'xusy', '2', '2017-07-01', null, null), ('2f78fe84-d1ff-472d-b926-0e43728c3ae1', '3', 'big_data', '大数据', '0', '1', '1', 'guanj', '3', '2017-07-01', null, null), ('0f528d22e06a4e339957df2b1e8bf7ff', '4', 'client', '客服部', '0', '1', '0', 'docZhao', '4', '2017-08-02', '2017-08-02', '');
COMMIT;

-- ----------------------------
--  Table structure for `sys_element`
-- ----------------------------
DROP TABLE IF EXISTS `sys_element`;
CREATE TABLE `sys_element` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `uri` varchar(255) DEFAULT NULL,
  `menu_id` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `path` varchar(2000) DEFAULT NULL,
  `method` varchar(10) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT NULL,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `sys_element`
-- ----------------------------
BEGIN;
INSERT INTO `sys_element` VALUES ('3', 'userManager:btn_add', 'button', '新增', '/back/user', '1', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null), ('4', 'userManager:btn_edit', 'button', '编辑', '/back/user', '1', null, null, 'PUT', '', null, null, null, null, null, null, null, null, null, null, null, null), ('5', 'userManager:btn_del	', 'button', '删除', '/back/user', '1', null, null, 'DELETE', '', null, null, null, null, null, null, null, null, null, null, null, null), ('9', 'menuManager:element', 'uri', '按钮页面', '/admin/element', '6', null, null, 'GET', '', null, null, null, null, null, null, null, null, null, null, null, null), ('10', 'menuManager:btn_add', 'button', '新增', '/back/menu', '6', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null), ('11', 'menuManager:btn_edit', 'button', '编辑', '/back/menu', '6', '', '', 'PUT', '', '2017-06-24 00:00:00', '', '', '', '', '', '', '', '', '', '', ''), ('12', 'menuManager:btn_del	', 'button', '删除', '/back/menu', '6', '', '', 'DELETE', '', '2017-06-24 00:00:00', '', '', '', '', '', '', '', '', '', '', ''), ('13', 'menuManager:btn_element_add', 'button', '新增元素', '/back/element', '6', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null), ('14', 'menuManager:btn_element_edit', 'button', '编辑元素', '/back/element', '6', null, null, 'PUT', '', null, null, null, null, null, null, null, null, null, null, null, null), ('15', 'btn_element_del', 'button', '删除元素', '/back/element', '6', null, null, 'DELETE', '', null, null, null, null, null, null, null, null, null, null, null, null), ('16', 'groupManager:btn_add', 'button', '新增', '/back/group', '7', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null), ('17', 'groupManager:btn_edit', 'button', '编辑', '/back/group', '7', null, null, 'PUT', '', null, null, null, null, null, null, null, null, null, null, null, null), ('18', 'groupManager:btn_del', 'button', '删除', '/back/group', '7', null, null, 'DELETE', '', null, null, null, null, null, null, null, null, null, null, null, null), ('19', 'groupManager:btn_userManager', 'button', '分配用户', '/back/group/{*}/user', '7', null, null, 'PUT', '', null, null, null, null, null, null, null, null, null, null, null, null), ('20', 'groupManager:btn_resourceManager', 'button', '分配权限', '/back/group/{*}/authority', '7', null, null, 'GET', '', null, null, null, null, null, null, null, null, null, null, null, null), ('21', 'groupManager:menu', 'uri', '分配菜单', '/back/group/{*}/authority/menu', '7', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null), ('22', 'groupManager:element', 'uri', '分配资源', '/back/group/{*}/authority/element', '7', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null), ('23', 'userManager:view	', 'uri', '查看', '/back/user', '1', '', '', 'GET', '', '2017-06-26 00:00:00', '', '', '', '', '', '', '', '', '', '', ''), ('24', 'menuManager:view', 'uri', '查看', '/back/menu', '6', '', '', 'GET', '', '2017-06-26 00:00:00', '', '', '', '', '', '', '', '', '', '', ''), ('27', 'menuManager:element_view', 'uri', '查看', '/back/element', '6', null, null, 'GET', null, null, null, null, null, null, null, null, null, null, null, null, null), ('28', 'groupManager:view', 'uri', '查看', '/back/group', '7', null, null, 'GET', null, null, null, null, null, null, null, null, null, null, null, null, null), ('30', 'adminAPI:view', 'uri', '查看', '/back/swagger', '23', null, null, 'GET', '', null, null, null, null, null, null, null, null, null, null, null, null), ('31', 'adminAPI:swagger', 'uri', '查看', '/back/v2', '23', null, null, 'GET', '', null, null, null, null, null, null, null, null, null, null, null, null), ('32', 'groupTypeManager:view', 'uri', '查看', '/back/groupType', '8', null, null, 'GET', '', null, null, null, null, null, null, null, null, null, null, null, null), ('33', 'groupTypeManager:btn_add', 'button', '新增', '/back/groupType', '8', null, null, 'POST', null, null, null, null, null, null, null, null, null, null, null, null, null), ('34', 'groupTypeManager:btn_edit', 'button', '编辑', '/back/groupType', '8', null, null, 'PUT', null, null, null, null, null, null, null, null, null, null, null, null, null), ('35', 'groupTypeManager:btn_del', 'button', '删除', '/back/groupType', '8', null, null, 'DELETE', null, null, null, null, null, null, null, null, null, null, null, null, null), ('40', 'adminAPI:swagger_resources', 'uri', '查看', '/back/swagger-resources', '23', null, null, 'GET', '', null, null, null, null, null, null, null, null, null, null, null, null), ('41', 'gateLogManager:view', 'button', '查看', '/back/gateLog', '27', null, null, 'GET', '', '2017-07-01 00:00:00', '1', 'admin', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null), ('42', 'blogArticle:view', 'uri', '查看', '/blog/article', '17', null, null, 'GET', '', null, null, null, null, null, null, null, null, null, null, null, null), ('43', 'blogArticle:edit', 'button', '编辑', '/blog/article', '17', null, null, 'PUT', '', '2017-07-15 23:52:01', '1', '管理员', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null), ('44', 'blogArticle:del', 'button', '删除', '/blog/article', '17', null, null, 'DELETE', '', '2017-07-15 23:52:38', '1', '管理员', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null), ('45', 'blogArticle:add', 'button', '新增', '/blog/article', '17', null, null, 'POST', '', '2017-07-15 23:53:06', '1', '管理员', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_funcright`
-- ----------------------------
DROP TABLE IF EXISTS `sys_funcright`;
CREATE TABLE `sys_funcright` (
  `id` varchar(36) DEFAULT NULL,
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

-- ----------------------------
--  Records of `sys_funcright`
-- ----------------------------
BEGIN;
INSERT INTO `sys_funcright` VALUES ('e66af1bd53bc4cbb85000ba9b5b0704a', 'dili_menu', '地理菜单', '', '2', 'mod2', null, '', '2017-08-10', '', ''), ('dc8cf35d-42e4-4895-84d5-d34b37b6764a', 'dsj_menu', '大数据菜单权限', 'dsjm', '2', 'mod3', '1', 'bak', '2017-08-14', '', ''), ('49eed630-c215-4f62-aea8-2bec3e410a31', 'sys_menu', '系统菜单', 'sysm', '0', 'mod2', '1', '', null, null, null), ('093d98ab-9fe7-4660-b31b-41a000f68953', 'ypt_menu', '云平台菜单权限', 'yptm', '0', 'mod1', '1', '', null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_group_member`
-- ----------------------------
DROP TABLE IF EXISTS `sys_group_member`;
CREATE TABLE `sys_group_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '组织成员表',
  `group_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT NULL,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL,
  `upd_user` varchar(255) DEFAULT NULL,
  `upd_name` varchar(255) DEFAULT NULL,
  `upd_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `sys_group_member`
-- ----------------------------
BEGIN;
INSERT INTO `sys_group_member` VALUES ('2', '4', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('6', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('7', '1', '3', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('9', '9', '4', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_hidemenuitem`
-- ----------------------------
DROP TABLE IF EXISTS `sys_hidemenuitem`;
CREATE TABLE `sys_hidemenuitem` (
  `id` varchar(36) NOT NULL,
  `STAFF_ID` varchar(8) NOT NULL COMMENT '员工编码',
  `MENU_ID` varchar(7) CHARACTER SET latin1 NOT NULL,
  `DEPART_ID` char(5) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_REFERENCE_9` (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='屏蔽员工相关菜单';

-- ----------------------------
--  Records of `sys_hidemenuitem`
-- ----------------------------
BEGIN;
INSERT INTO `sys_hidemenuitem` VALUES ('003b545808294b998ef71c5f5acdde2c', 'docZhao', 'menu3', null, 'ces', null, '', null), ('fa83e8e9e03043518152c2ceb1f7f56a', 'syu', 'menu2', '', '', '2017-08-14', '', '');
COMMIT;

-- ----------------------------
--  Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `parent_id` int(11) NOT NULL,
  `href` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `order_num` int(11) NOT NULL DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  `enabled` char(1) DEFAULT NULL,
  `crt_time` datetime DEFAULT NULL,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL,
  `upd_user` varchar(255) DEFAULT NULL,
  `upd_name` varchar(255) DEFAULT NULL,
  `upd_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `sys_menu`
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES ('1', 'userManager', '用户管理', '5', '/admin/user', 'fa fa-user', null, '0', '', '/adminSys/sysManager/userManager', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('5', 'sysManager', '基础配置管理', '13', '', 'fa fa-cog fa-spin', null, '0', '用户', '/adminSys/sysManager', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('6', 'menuManager', '菜单管理', '5', '/admin/menu', 'fa fa-list', null, '0', '', '/adminSys/sysManager/menuManager', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('7', 'groupManager', '角色组管理', '5', '/admin/group', 'fa fa-users', null, '0', '', '/adminSys/sysManager/groupManager', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('8', 'groupTypeManager', '角色类型管理', '5', '/admin/groupType', 'fa fa-address-card-o', null, '0', '', '/adminSys/sysManager/groupTypeManager', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('9', 'monitorManager', '系统监控', '-1', '', 'fa fa-area-chart', null, '0', '', '/adminSys/monitorManager', null, null, null, null, null, '2017-08-08 17:47:09', '1', '朱海', '127.0.0.1', null, null, null, null, null, null, null, null), ('10', 'bootMonitor', 'Spring-Boot监控', '9', 'http://localhost:8764', 'fa fa-line-chart', null, '0', '', '/adminSys/monitorManager/bootMonitor', null, null, null, null, null, '2017-07-25 19:38:11', '1', 'Mr.AG', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null), ('11', 'hystrixMonitor', 'Hystrix监控', '9', 'http://localhost:8764/hystrix', 'fa fa-bar-chart', null, '0', '', '/adminSys/monitorManager/hystrixMonitor', null, null, null, null, null, '2017-08-11 09:33:57', 'admin', '朱海', '127.0.0.1', null, null, null, null, null, null, null, null), ('13', 'adminSys', '权限管理系统', '-1', '', 'fa fa-terminal', null, '0', '', '/adminSys', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('21', 'dictManager', '数据字典', '5', '', 'fa fa-book', null, '0', '', '/adminSys/sysManager/dictManager', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('22', 'apiManager', '服务端api文档', '-1', '', 'fa fa-folder', null, '0', '', '/adminSys/apiManager', null, null, null, null, null, '2017-08-08 17:47:21', '1', '朱海', '127.0.0.1', null, null, null, null, null, null, null, null), ('23', 'adminAPI', 'Admin Rest API', '22', '/back/swagger-ui.html', 'fa fa-file-code-o', null, '0', '', '/adminSys/apiManager/adminAPI', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('24', 'druidMonitor', 'Admin Druid数据监控', '9', '/back/druid/datasource.html', 'fa fa-line-chart', null, '0', '', '/adminSys/monitorManager/druidMonitor', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('27', 'gateLogManager', '操作日志', '5', '/admin/gateLog', 'fa fa-book', null, '0', '', '/adminSys/sysManager/gateLogManager', null, '2017-07-01 00:00:00', '1', 'admin', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_mh_stafftempdataright`
-- ----------------------------
DROP TABLE IF EXISTS `sys_mh_stafftempdataright`;
CREATE TABLE `sys_mh_stafftempdataright` (
  `id` varchar(36) DEFAULT NULL,
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

-- ----------------------------
--  Table structure for `sys_mh_stafftempfuncright`
-- ----------------------------
DROP TABLE IF EXISTS `sys_mh_stafftempfuncright`;
CREATE TABLE `sys_mh_stafftempfuncright` (
  `id` varchar(36) DEFAULT NULL,
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

-- ----------------------------
--  Table structure for `sys_modfile`
-- ----------------------------
DROP TABLE IF EXISTS `sys_modfile`;
CREATE TABLE `sys_modfile` (
  `id` varchar(36) DEFAULT NULL,
  `MOD_CODE` varchar(30) NOT NULL COMMENT '模块编码：子系统编码＋三位序列',
  `MOD_NAME` varchar(512) NOT NULL,
  `MOD_TYPE` char(1) NOT NULL COMMENT '库文件类型：0－GUI的DLL文件，1－WEB地址',
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  UNIQUE KEY `IDX_SYS_MODFILE_MODNAME` (`MOD_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存GUI的DLL文件编码信息和WEB地址URL信息等';

-- ----------------------------
--  Records of `sys_modfile`
-- ----------------------------
BEGIN;
INSERT INTO `sys_modfile` VALUES ('3d5231a97e2f4b45b35d3d9c1b7be736', 'mod1', '模块1', '0', '', null, '', null), ('15b4c4275a664d078ee7c5714a62c8c4', 'mod2', '模块2', '1', '', null, null, null), ('a71eb2de00d5478bb5766d57fc81fe56', 'mod3', '模块3', '0', '', '2017-08-10', '', '');
COMMIT;

-- ----------------------------
--  Table structure for `sys_resource_authority`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource_authority`;
CREATE TABLE `sys_resource_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority_id` varchar(255) DEFAULT NULL,
  `authority_type` varchar(255) DEFAULT NULL,
  `resource_id` varchar(255) DEFAULT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `path` varchar(2000) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT NULL,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=722 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `sys_resource_authority`
-- ----------------------------
BEGIN;
INSERT INTO `sys_resource_authority` VALUES ('285', '1', 'group', '3', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('286', '1', 'group', '4', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('287', '1', 'group', '5', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('288', '1', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('289', '1', 'group', '10', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('290', '1', 'group', '11', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('291', '1', 'group', '12', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('292', '1', 'group', '3', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('293', '1', 'group', '4', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('294', '1', 'group', '5', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('295', '1', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('296', '1', 'group', '10', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('297', '1', 'group', '11', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('298', '1', 'group', '12', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('299', '1', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('300', '1', 'group', '12', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('301', '1', 'group', '10', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('302', '1', 'group', '11', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('303', '1', 'group', '13', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('304', '1', 'group', '14', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('305', '1', 'group', '15', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('306', '1', 'group', '10', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('307', '1', 'group', '11', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('308', '1', 'group', '12', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('309', '1', 'group', '13', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('310', '1', 'group', '14', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('311', '1', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('312', '1', 'group', '15', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('313', '1', 'group', '16', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('314', '1', 'group', '17', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('315', '1', 'group', '18', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('316', '1', 'group', '19', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('317', '1', 'group', '20', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('318', '1', 'group', '21', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('319', '1', 'group', '22', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('349', '4', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('371', '1', 'group', '23', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('372', '1', 'group', '24', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('373', '1', 'group', '27', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('374', '1', 'group', '28', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('375', '1', 'group', '23', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('376', '1', 'group', '3', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('377', '1', 'group', '4', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('378', '1', 'group', '5', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('379', '1', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('380', '1', 'group', '11', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('381', '1', 'group', '14', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('382', '1', 'group', '13', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('383', '1', 'group', '15', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('384', '1', 'group', '12', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('385', '1', 'group', '24', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('386', '1', 'group', '10', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('387', '1', 'group', '27', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('388', '1', 'group', '16', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('389', '1', 'group', '18', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('390', '1', 'group', '17', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('391', '1', 'group', '19', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('392', '1', 'group', '20', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('393', '1', 'group', '28', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('394', '1', 'group', '22', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('395', '1', 'group', '21', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('396', '4', 'group', '23', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('397', '4', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('398', '4', 'group', '27', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('399', '4', 'group', '24', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('400', '4', 'group', '28', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('401', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('402', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('403', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('421', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('422', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('423', '4', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('424', '4', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('436', '1', 'group', '32', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('437', '1', 'group', '33', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('438', '1', 'group', '34', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('439', '1', 'group', '35', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('440', '4', 'group', '32', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('464', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('465', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('466', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('467', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('468', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('469', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('470', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('471', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('472', '1', 'group', '40', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('492', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('493', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('494', '1', 'group', '40', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('516', '4', 'group', '41', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('517', '4', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('518', '4', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('519', '4', 'group', '40', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('611', '4', 'group', '42', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('612', '4', 'group', '36', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('628', '4', 'group', '13', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('629', '4', 'group', '5', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('630', '4', 'group', '1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('631', '4', 'group', '6', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('632', '4', 'group', '7', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('633', '4', 'group', '8', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('634', '4', 'group', '27', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('635', '4', 'group', '9', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('636', '4', 'group', '24', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('637', '4', 'group', '22', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('638', '4', 'group', '23', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('639', '4', 'group', '25', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('640', '4', 'group', '26', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('641', '4', 'group', '28', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('666', '1', 'group', '41', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('689', '1', 'group', '43', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('690', '1', 'group', '42', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('691', '1', 'group', '44', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('692', '1', 'group', '45', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('693', '1', 'group', '13', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('694', '1', 'group', '5', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('695', '1', 'group', '1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('696', '1', 'group', '6', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('697', '1', 'group', '7', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('698', '1', 'group', '8', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('699', '1', 'group', '27', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('700', '1', 'group', '9', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('701', '1', 'group', '10', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('702', '1', 'group', '11', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('703', '1', 'group', '24', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('704', '1', 'group', '22', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('705', '1', 'group', '23', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('706', '1', 'group', '14', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('707', '1', 'group', '20', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('708', '1', 'group', '17', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('709', '1', 'group', '18', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('710', '9', 'group', '42', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('711', '9', 'group', '43', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('712', '9', 'group', '44', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('713', '9', 'group', '45', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('714', '9', 'group', '14', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('715', '9', 'group', '20', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('716', '9', 'group', '17', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('717', '9', 'group', '18', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('718', '9', 'group', '42', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('719', '9', 'group', '44', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('720', '9', 'group', '45', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('721', '9', 'group', '43', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_rightlog_his`
-- ----------------------------
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

-- ----------------------------
--  Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(36) NOT NULL,
  `ROLE_CODE` char(30) NOT NULL COMMENT '角色编码',
  `ROLE_NAME` varchar(30) DEFAULT NULL,
  `data_code` varchar(30) DEFAULT NULL,
  `data_type` char(1) DEFAULT NULL,
  `ROLE_ATTR` char(1) NOT NULL COMMENT '角色属性：0－功能权限角色，1－资源数据权限角色，2－数据特权角色 可扩展',
  `REMARK` varchar(100) DEFAULT NULL,
  `VALIDFLAG` char(1) NOT NULL COMMENT '有效0 ；无效1',
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ROLE_CODE` (`ROLE_CODE`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存角色编码参数信息';

-- ----------------------------
--  Records of `sys_role`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('52a0f97a-17a0-4c12-b6a7-1e2d73b8e24e', 'syu_data1', 'syu_somr', '101010', '0', '2', 'kkk', '1', '2017-08-11', '', null), ('602e510938434a288ab4c07c660d1564', 'syu_data2', 'syudata2', '101010', '1', '2', '', '0', '2017-08-11', '', null), ('760be92f1f9145fc8ad4df7277232eae', 'syu_data_3', '数据角色3', 'jkjkjk', '9', '2', '', '0', '2017-08-18', '', null), ('d2ce77c5-3da1-4b0e-a106-622e24c5abab', 'role_admin_menu', 'admin菜单权限', 'jhjhjh', 'P', '0', '', '0', '2017-08-10', '', null), ('d98c6958de9d443db37d6b70869ca1c1', 'syu_menu_1', 'syumenu1', '9090901', 'P', '0', '', '0', '2017-08-18', '', null), ('f26bf869-7ce1-467a-81a7-a219a029ac3e', 'role_data_admin', 'admin数据权限', 'fd', 'D', '1', '中文', '0', '2017-07-19', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_roledataright`
-- ----------------------------
DROP TABLE IF EXISTS `sys_roledataright`;
CREATE TABLE `sys_roledataright` (
  `id` varchar(36) NOT NULL,
  `ROLE_CODE` char(30) NOT NULL,
  `DATA_CODE` varchar(30) NOT NULL,
  `DATA_TYPE` char(1) NOT NULL COMMENT '数据类型：0－资源权限，1－数据特权(行列数等)，9—网别，P－产品权限，D－资费权限，S－服务权限，K—包权限',
  `RIGHT_CLASS` char(1) DEFAULT NULL COMMENT '权限级别：0－无权限，1－个人权限，2－营业厅权限，3－业务区权限，4－地州权限，5－全省权限',
  `OPER_SPECIAL` char(1) DEFAULT NULL COMMENT '操作特权：0－可同级操作，1－可越级操作',
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存数据权限的角色信息';

-- ----------------------------
--  Records of `sys_roledataright`
-- ----------------------------
BEGIN;
INSERT INTO `sys_roledataright` VALUES ('402881415e0cd836015e0cd83b410000', 'syu_admin', 'data_2', '1', '4', '2', '2017-08-03', 'syu', '2'), ('62884d219dfa4d2da049ac2e0bec7e6b', 'syu_data1', 'data_1', '9', '4', '1', '2017-08-03', '', 'kknd'), ('b5b3bc5f-ee10-47a6-a97f-7adbe7b450de', 'role_data_admin', 'data_4', '0', '5', '1', null, '', '');
COMMIT;

-- ----------------------------
--  Table structure for `sys_rolefuncright`
-- ----------------------------
DROP TABLE IF EXISTS `sys_rolefuncright`;
CREATE TABLE `sys_rolefuncright` (
  `id` varchar(36) NOT NULL,
  `ROLE_CODE` char(30) NOT NULL,
  `RIGHT_CODE` varchar(30) NOT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存相关功能权限的角色信息';

-- ----------------------------
--  Records of `sys_rolefuncright`
-- ----------------------------
BEGIN;
INSERT INTO `sys_rolefuncright` VALUES ('378395cc-0ce1-49a1-84ae-abb18ab52298', 'role_admin_menu', 'sys_menu', null, null, null), ('52fa4ae2b5914a208c4b0d14b0bb03dc', 'admin菜单权', 'dsj_menu', '2017-08-04', '', ''), ('bcc2284f9afc4bfd931cfd03eb4ea9fe', 'role_admin_menu', 'dili_menu', '2017-08-10', '', '');
COMMIT;

-- ----------------------------
--  Table structure for `sys_staff`
-- ----------------------------
DROP TABLE IF EXISTS `sys_staff`;
CREATE TABLE `sys_staff` (
  `id` varchar(36) NOT NULL,
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
  `START_DATE` date DEFAULT NULL COMMENT '起始有效时间',
  `END_DATE` date DEFAULT NULL COMMENT '终止有效时间',
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_SYS_STAFF_DEPARTID` (`DEPART_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存所有登陆云平台的员工工号信息';

-- ----------------------------
--  Records of `sys_staff`
-- ----------------------------
BEGIN;
INSERT INTO `sys_staff` VALUES ('162e381010ec49c0a3111f58e8d3dcda', 'zhuhai', '1', '朱海', 'manager', '', '0', 'zhuhai@qq.com', '', '13577050177', '0', null, '', null, '0', '', null, null, '2017-08-10', '', ''), ('185f5e60e0734f02abc4a3733d4530b4', 'xusheng', '1', '许生', 'worker', '', '0', 'xusheng@qq.com', '', '13577050176', '0', '2017-08-10', '', null, '0', '', null, null, '2017-08-10', '', ''), ('61fac2f4-a08d-4b0e-8265-d05b4a0d84c9', 'docZuo', '0', '左老师', 'boss', '', '0', 'zuo@qq.com', 'something', '13577050371', '0', null, '', '', '0', '', '2017-07-01', '2018-07-13', '2017-08-03', '', ''), ('a0891f3c80c442abb96f98bbe8cd6aae', 'zhuhai', '1', '朱海', 'manager', '', '0', 'zhuhai@qq.com', '', '13577050177', '0', null, '', null, '0', '', null, null, '2017-08-10', '', ''), ('a2a8441392004228ab33965626c98b94', 'mengyux', '1', '萌预想', 'worker', '', '0', 'menxux@qq.com', '', '13577050178', '0', null, '', null, '0', '', null, null, '2017-08-10', '', ''), ('c0c938aa-9cc0-4b47-89d5-57aca0c77c11', 'xusy', '2', '老司机', 'manager', '', '0', 'xu@qq.com', 'something', '13577050173', '0', null, '', 'docZhao', '0', '', '2017-07-13', '2018-07-13', '2017-08-03', '', ''), ('cbd90f30-094c-461a-bd3e-05ebfb5472b3', 'syu', '2', 'syu', 'worder', null, '0', 'syu@qq.com', 'something', '13577050174', '0', null, null, 'xusy', '0', null, '2017-07-01', '2018-07-13', null, null, null), ('ed4f65b4-6931-4a25-b284-7788a59a3a3c', 'docZhao', '1', '赵博士', 'manager', null, '0', 'zhao@qq.com', 'something', '13577050132', '0', null, null, 'docZuo', '0', null, '2017-07-13', '2018-07-13', null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_staffauthcode`
-- ----------------------------
DROP TABLE IF EXISTS `sys_staffauthcode`;
CREATE TABLE `sys_staffauthcode` (
  `id` varchar(36) NOT NULL,
  `STAFF_ID` varchar(8) NOT NULL COMMENT '员工编码',
  `WEB_PASSWD` varchar(50) NOT NULL COMMENT '授权码',
  `STR_DATA` datetime NOT NULL,
  `END_DATA` datetime NOT NULL,
  `REMARK` varchar(200) DEFAULT NULL COMMENT '备注',
  `UPDATE_TIME` datetime DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_staffauthcode`
-- ----------------------------
BEGIN;
INSERT INTO `sys_staffauthcode` VALUES ('0a1c39631fa24fe78d1fdea11c96f277', 'syu', 'yhjjnklll', '2017-08-03 17:05:15', '2018-08-03 17:05:19', '', '2017-08-03 17:05:23', '', '');
COMMIT;

-- ----------------------------
--  Table structure for `sys_staffdataright`
-- ----------------------------
DROP TABLE IF EXISTS `sys_staffdataright`;
CREATE TABLE `sys_staffdataright` (
  `id` varchar(36) NOT NULL,
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
  PRIMARY KEY (`id`),
  KEY `IDX_SYS_STAFFDATA_DATACODE` (`DATA_CODE`,`DATA_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存员工所有数据权限/角色信息';

-- ----------------------------
--  Records of `sys_staffdataright`
-- ----------------------------
BEGIN;
INSERT INTO `sys_staffdataright` VALUES ('2cafd203-db53-4ce2-8a20-73e3c89cd39b', 'syu', 'role_data_admin', '9', '1', '1', '0', '0', '', '2017-08-07', ''), ('63718acb-b4e8-4d5d-8904-8be096980022', 'syu', 'role_admin_menu', '0', '1', '4', '0', '0', '', null, ''), ('cf27873758cf47e19d221338b88745bc', 'syu', 'role_data_admin', 'K', '1', null, null, '0', '', null, null), ('d18738f0-85c7-4a77-ba16-69ac74b942f3', 'syu', 'data_3', '0', '0', '3', '1', '0', '', null, '');
COMMIT;

-- ----------------------------
--  Table structure for `sys_staffdatetime`
-- ----------------------------
DROP TABLE IF EXISTS `sys_staffdatetime`;
CREATE TABLE `sys_staffdatetime` (
  `id` varchar(36) NOT NULL,
  `LIMIT_ID` varchar(4) NOT NULL COMMENT '受限标识：序列号生成，只实现主键含义。',
  `STAFF_ID` varchar(8) NOT NULL,
  `SYS_TAG` char(1) NOT NULL COMMENT '系统限制标记：0－普通员工限制，1－全体员工限制',
  `START_DATE` timestamp NULL DEFAULT NULL,
  `END_DATE` timestamp NULL DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `LIMIT_ID` (`LIMIT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存限制员工登录日期和时间的相关信息';

-- ----------------------------
--  Records of `sys_staffdatetime`
-- ----------------------------
BEGIN;
INSERT INTO `sys_staffdatetime` VALUES ('8792863c5cce41ec81e9f57221d0b39b', 'so', 'syu', '0', '2017-08-04 14:56:55', '2017-08-05 14:56:58', '', '2017-08-04', '', '');
COMMIT;

-- ----------------------------
--  Table structure for `sys_stafffuncright`
-- ----------------------------
DROP TABLE IF EXISTS `sys_stafffuncright`;
CREATE TABLE `sys_stafffuncright` (
  `id` varchar(36) NOT NULL,
  `STAFF_ID` varchar(8) NOT NULL,
  `RIGHT_CODE` varchar(30) NOT NULL COMMENT '权限或角色编码：可能是单个的权限编码，也可能是角色编码',
  `RIGHT_ATTR` char(1) NOT NULL COMMENT '权限属性：0－功能权限，1－功能角色权限',
  `RIGHT_TAG` char(1) NOT NULL COMMENT '权限标志：0－无效，1－有效',
  `REMARK` varchar(100) DEFAULT NULL,
  `ACCREDIT_TIME` date DEFAULT NULL,
  `ACCREDIT_STAFF_ID` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_SYS_STAFFFUNCRIGHT_RIGHT` (`RIGHT_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存员工的所有功能权限/角色信息';

-- ----------------------------
--  Records of `sys_stafffuncright`
-- ----------------------------
BEGIN;
INSERT INTO `sys_stafffuncright` VALUES ('4c7398ff2fbe4e10a8652b76ca7cbc90', 'mengyux', 'syu_menu_1', '1', '0', '', '2017-08-11', ''), ('73b161a3-3276-42d9-84e7-cd9ec6018a12', 'syu', 'role_admin_menu', '1', '0', null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_staffpasswd`
-- ----------------------------
DROP TABLE IF EXISTS `sys_staffpasswd`;
CREATE TABLE `sys_staffpasswd` (
  `id` varchar(36) DEFAULT NULL,
  `STAFF_ID` varchar(8) NOT NULL,
  `STAFF_PASSWD` varchar(10) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`STAFF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存加密后的员工密码信息';

-- ----------------------------
--  Records of `sys_staffpasswd`
-- ----------------------------
BEGIN;
INSERT INTO `sys_staffpasswd` VALUES (null, 'docZhao', '123456', null, null, null), (null, 'docZuo', '123456', null, null, null), (null, 'syu', '123456', null, null, null), (null, 'xusy', '123456', null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_stafftempdataright`
-- ----------------------------
DROP TABLE IF EXISTS `sys_stafftempdataright`;
CREATE TABLE `sys_stafftempdataright` (
  `id` varchar(36) NOT NULL,
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
  PRIMARY KEY (`id`),
  KEY `IDX_SYS_STAFFTEMPDATA_DATA` (`DATA_CODE`,`DATA_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工临时数据权限表：只记录有效临时权限信息，失效后搬到历史表(分配权限时判断)';

-- ----------------------------
--  Records of `sys_stafftempdataright`
-- ----------------------------
BEGIN;
INSERT INTO `sys_stafftempdataright` VALUES ('0a62587c-e2cd-4c13-beed-12ba03175638', 'syu', 'data_1', '1', '1', '1', '2017-08-02', '', '0', '10', '10', '2017-08-02', '2017-08-02', '', '2017-07-18', '', null), ('f04e11bfb6d347958aa6e18b23275a2f', 'syu', 'data_5', 'P', '1', '0', null, null, '0', '10', '3', null, null, '', '2017-08-13', '', '');
COMMIT;

-- ----------------------------
--  Table structure for `sys_stafftempfuncright`
-- ----------------------------
DROP TABLE IF EXISTS `sys_stafftempfuncright`;
CREATE TABLE `sys_stafftempfuncright` (
  `id` varchar(36) NOT NULL,
  `STAFF_ID` varchar(8) NOT NULL,
  `RIGHT_CODE` varchar(30) NOT NULL,
  `ACCREDIT_TIME` date DEFAULT NULL,
  `ACCREDIT_STAFF_ID` varchar(8) DEFAULT NULL,
  `USE_TAG` char(1) NOT NULL COMMENT '用标志：0－按次数使用，1－按时间范围使用',
  `TIMES` int(3) DEFAULT '0',
  `USED_TIMES` int(3) DEFAULT '0',
  `START_DATE` timestamp NULL DEFAULT NULL,
  `END_DATE` timestamp NULL DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date NOT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_SYS_STAFFTEMPFUNC_RIGHT` (`RIGHT_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工临时功能权限表：只记录有效临时权限信息，失效后搬到历史表(分配权限时判断)';

-- ----------------------------
--  Records of `sys_stafftempfuncright`
-- ----------------------------
BEGIN;
INSERT INTO `sys_stafftempfuncright` VALUES ('2c943a2c860a4510ab4ff0dd107683d6', 'docZhao', 'sys_menu', '2017-08-04', '', '0', '10', '0', '2017-08-03 16:09:11', '2017-08-03 16:09:11', '', '2017-08-11', '', ''), ('912dc7fcf96c4ff3b93248466e51e366', 'syu', 'dili_menu', null, '', '0', '3', '7', null, null, '', '2017-08-18', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_stafftermipaddr`
-- ----------------------------
DROP TABLE IF EXISTS `sys_stafftermipaddr`;
CREATE TABLE `sys_stafftermipaddr` (
  `id` varchar(36) NOT NULL,
  `STAFF_ID` varchar(8) NOT NULL,
  `IP_START` varchar(15) NOT NULL,
  `IP_END` varchar(15) NOT NULL COMMENT 'IP终止地址：如果是固定IP，填写和起始IP相同',
  `SYS_TAG` char(1) NOT NULL COMMENT '系统限制标记：0－不能登录IP，1－只能登录IP段',
  `REMARK` varchar(100) DEFAULT NULL COMMENT '备注：受限原因',
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存限制员工登录的机器IP地址信息';

-- ----------------------------
--  Records of `sys_stafftermipaddr`
-- ----------------------------
BEGIN;
INSERT INTO `sys_stafftermipaddr` VALUES ('7d5002c4-0230-46e1-b84b-e31de3e3a13f', 'syu', '192.168.1.0', '192.168.1.255', '1', '', null, '', null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_subsys`
-- ----------------------------
DROP TABLE IF EXISTS `sys_subsys`;
CREATE TABLE `sys_subsys` (
  `id` varchar(36) NOT NULL,
  `SUBSYS_CODE` char(3) CHARACTER SET latin1 NOT NULL COMMENT '子系统编码：三位有意义的编码简称',
  `SUBSYS_NAME` varchar(50) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date NOT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存云平台所有子系统编码信息';

-- ----------------------------
--  Records of `sys_subsys`
-- ----------------------------
BEGIN;
INSERT INTO `sys_subsys` VALUES ('6a65746c-b6f1-4a6b-8675-70b3b71c1f4b', 'dsj', '大数据', null, '2017-07-13', 'syu', '2'), ('9e169a9c-7468-40ec-90a8-ccefd619a97e', 'ypt', '云平台', null, '2017-07-13', 'syu', '2'), ('e76db194-4979-4eda-9165-e1dab13e8f6b', 'sys', '系统', null, '2017-07-17', 'syu', '2');
COMMIT;

-- ----------------------------
--  Table structure for `sys_sys_class`
-- ----------------------------
DROP TABLE IF EXISTS `sys_sys_class`;
CREATE TABLE `sys_sys_class` (
  `id` varchar(36) NOT NULL,
  `CLASS_CODE` varchar(4) NOT NULL COMMENT '分类编码：将相同功能组合为一类，由我们定义，与子系统有不同之处',
  `CLASS_NAME` varchar(50) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` date DEFAULT NULL,
  `UPDATE_STAFF_ID` varchar(8) DEFAULT NULL,
  `UPDATE_DEPART_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存权限分类编码参数信息';

-- ----------------------------
--  Table structure for `sys_systemguimenu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_systemguimenu`;
CREATE TABLE `sys_systemguimenu` (
  `id` varchar(36) NOT NULL,
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
  PRIMARY KEY (`id`),
  KEY `IDX_SYS_SYSMENU_SUBSYS` (`SUBSYS_CODE`),
  KEY `IDX_SYS_SYSMENU_RIGHTCODE` (`RIGHT_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存云平台所有GUI菜单信息';

-- ----------------------------
--  Records of `sys_systemguimenu`
-- ----------------------------
BEGIN;
INSERT INTO `sys_systemguimenu` VALUES ('1b6aa95851e64154aa3839522f9f1a5d', 'menu8', '', 'sys', '菜单8', '菜单8', '', '1', null, '', 'dili_menu', '', '', '2017-08-18', '', ''), ('439ee2a261024b82bf1c22ee503fb7c0', 'menu2', '', 'ypt', '云平台2', '云平台2', '', null, null, '', 'ypt_menu', '', '', '2017-08-14', '', ''), ('4f7eb2ed-f7ac-4d92-a5d0-c2f9738e5af4', 'menu5', null, 'dsj', '大数据2222', '大数据2222', null, null, null, null, 'dsj_menu', null, null, null, null, null), ('6963e000-7616-48f7-966b-c7866633b2fd', 'menu6', '2', 'sys', '系统111', '系统111', null, null, null, null, 'sys_menu', null, null, null, null, null), ('a14ce8c6-b7a3-40b4-9756-23ed87d62bb3', 'menu1', null, 'dsj', '大数据', '大数据', null, null, null, null, 'dsj_menu', null, null, null, null, null), ('e7e5d8d7-3077-47f3-b276-858f4f301146', 'menu4', '2', 'ypt', '云平台1', '云平台1', '', null, null, '', 'ypt_menu', '', '', '2017-08-14', '', ''), ('fc968ee5-8fa6-4f6e-a459-f86862742bae', 'menu7', '2', 'sys', '系统222', '系统222', null, null, null, null, 'sys_menu', null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_termipaddr`
-- ----------------------------
DROP TABLE IF EXISTS `sys_termipaddr`;
CREATE TABLE `sys_termipaddr` (
  `id` varchar(36) DEFAULT NULL,
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

-- ----------------------------
--  Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL COMMENT '用户编码：在任何时间内唯一，离职的用户打上标记，不直接删除。',
  `password` varchar(255) DEFAULT NULL,
  `DEPART_CODE` varchar(20) DEFAULT NULL COMMENT '部门/组织编码',
  `name` varchar(20) DEFAULT NULL,
  `USER_ID` varchar(20) DEFAULT NULL,
  `ACC_ID` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `mobile_phone` varchar(15) DEFAULT NULL,
  `tel_phone` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `identity` varchar(40) DEFAULT NULL COMMENT '证件号码',
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT NULL,
  `crt_user` varchar(20) DEFAULT NULL,
  `crt_name` varchar(20) DEFAULT NULL,
  `crt_host` varchar(20) DEFAULT NULL,
  `crt_depart` varchar(20) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL,
  `upd_user` varchar(20) DEFAULT NULL,
  `upd_name` varchar(20) DEFAULT NULL,
  `upd_host` varchar(20) DEFAULT NULL,
  `upd_depart` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `sys_user`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', 'admin', '$2a$12$pdLiLeRre1LhFvaXRUpDm.pFFks5.KlhicXD7OoJm5Ec2h5bbmN.W', null, '朱海', null, null, '1990-09-07', '云南省昆明市西山区', '13908718002', '087184654216', 'zhuhai@bzhcloud.com', '0', null, '0', '532325198403120732', '我叫朱海', null, null, null, null, null, '2017-08-12 13:53:34', 'admin', '朱海', '127.0.0.1', null), ('2', 'test', '$2a$12$nkVGusvfDZMr2s/imgBxSukKeLe5Wt.D/TbM1OPFWg0gHGJKg59Cm', null, '测试账户', null, null, '2017-08-31', '昆明市', '13908700000', null, 'bzkj@bzhcloud.com', '1', null, '0', '532325198403120733', '', null, null, null, null, null, '2017-08-12 13:51:26', 'admin', '朱海', '127.0.0.1', null), ('29', 'yangzy', '$2a$12$JT/e6SLCnZg4f8Q3NUr5ReM1glrq27wwkPncdFhic9iHwwnAViN3a', null, '杨祖样', null, null, '2017-08-30', '昆明市', '13908718007', null, 'yangzy@bzhcloud.com', '0', null, '0', '532325198403120739', 'ceds', '2017-08-10 17:44:06', 'admin', '朱海', '127.0.0.1', null, '2017-08-12 13:47:30', 'admin', '朱海', '127.0.0.1', null), ('31', 'xusy', '$2a$12$ubnymF4V6sDm7rcZ7Kmk2eAw6Z.GBbjc9JKzpcmyo2AKSwi8cfZVW', null, '徐思远', null, null, '2017-08-31', '昆明市', '13908718008', '', 'xusy@bzhcloud.com', '0', null, '0', '532325198403120735', '', null, null, null, null, null, '2017-08-14 13:43:22', 'admin', '朱海', '127.0.0.1', null);
COMMIT;

-- ----------------------------
--  Procedure structure for `insert_conf_field`
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_conf_field`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_conf_field`()
begin
    declare v_table_name varchar(30) ; 
    
    declare done int default false;  
    declare table_cur cursor  for select table_name from information_schema.COLUMNS where TABLE_SCHEMA='sunrise' and table_name<>'sys_role' and table_name like 'sys%' group by table_name;
    declare continue handler for not found set done = true;  
    open table_cur;  
    table_cur:loop  
	fetch table_cur into v_table_name; 
	if done then 
	     leave table_cur;    
	end if; 

	BEGIN
          declare v_cloumn_name varchar(100);
          declare v_position    int;
          declare v_type        varchar(100);
	  declare done_1 int default false;  
	  declare field_cur cursor  for select column_name,ORDINAL_POSITION,data_type from information_schema.COLUMNS 
		where TABLE_SCHEMA='sunrise' and table_name =v_table_name order by table_name,ORDINAL_POSITION;
	  declare continue handler for not found set done_1 = true; 

          open  field_cur;
          field_cur:LOOP
		fetch field_cur into v_cloumn_name,v_position,v_type; 
		if done_1 then 
		     leave field_cur;    
		end if; 
                insert into conf_fields 
		   (entity_name,column_index,field_name,field_type,hidden,allow_blank,field_text)
                   values(v_table_name,v_position,v_cloumn_name,v_type,'0','0','');
		commit;

	  end loop;
          close field_cur;
	end;
	
    end loop;  
    close table_cur;


end
 ;;
delimiter ;

-- ----------------------------
--  Function structure for `test`
-- ----------------------------
DROP FUNCTION IF EXISTS `test`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `test`(a int) RETURNS int(11)
BEGIN
   DECLARE v_b int default 2;
   return a+v_b;
END
 ;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
