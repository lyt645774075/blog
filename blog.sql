/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50626
 Source Host           : localhost
 Source Database       : blog

 Target Server Type    : MySQL
 Target Server Version : 50626
 File Encoding         : utf-8

 Date: 05/11/2016 21:04:04 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` varchar(20) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `title` varchar(100) NOT NULL,
  `creator_id` varchar(20) NOT NULL,
  `creator_nick_name` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  `see_scope` int(8) DEFAULT NULL,
  `status` varchar(8) DEFAULT NULL,
  `device` int(8) DEFAULT NULL,
  `location` varchar(200) DEFAULT NULL,
  `content_map` varchar(20000) DEFAULT NULL,
  `label_id_list` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_pk` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `blog`
-- ----------------------------
BEGIN;
INSERT INTO `blog` VALUES ('2b014814d67e42a78729', '2016-05-09 19:05:35', '2016-05-09 19:05:35', 'dtttt', '11', '李洋涛', 'STANDARD', '默认', '1', 'FINISH', '1', '四川成都', '{\"title\":\"dtttt\",\"content\":\"ddd\"}', ''), ('7490675e75dd4fdb8db0', '2016-05-08 19:19:27', '2016-05-08 19:19:27', '测试博客创建', '11', '李洋涛', 'STANDARD', '默认', '1', 'FINISH', '1', '四川成都', '{\"title\":\"测试博客创建\",\"content\":\"<p>hi,all</p><p>这是第一篇博客文章，欢迎大家关注我。</p><p><img src=\\\"http://freturn.oss-cn-hangzhou.aliyuncs.com/upload/img/user/013db9200f2cc647c82346a09b4f62f2.jpg\\\" data-filename=\\\"上传图片\\\" style=\\\"width: 740px;\\\"><br></p><p>中国中国中国</p>\"}', ''), ('8a0d4af618864daea707', '2016-05-08 19:26:47', '2016-05-08 19:26:47', 'jujingwei永久分支', '11', '李洋涛', 'STANDARD', '默认', '1', 'FINISH', '1', '四川成都', '{\"title\":\"jujingwei永久分支\",\"content\":\"<p>hi,all</p><p>这是测试博客</p><p>欢迎关注</p><p><img src=\\\"http://freturn.oss-cn-hangzhou.aliyuncs.com/upload/img/user/f2e93210c5efb34863c334347c9425f3.jpg\\\" data-filename=\\\"上传图片\\\" style=\\\"width: 394.05px; height: 213px;\\\"></p><pre style=\\\"background-color:#2b2b2b;color:#a9b7c6;font-family:\'Menlo\';font-size:12.0pt;\\\"><span style=\\\"background-color:#344134;\\\">blog</span>.setType(BlogType.<span style=\\\"color:#9876aa;font-style:italic;\\\">STANDARD</span>)<span style=\\\"color:#cc7832;\\\">;<br></span><span style=\\\"background-color:#344134;\\\">blog</span>.setCategory(<span style=\\\"color:#6a8759;\\\">\\\"默认\\\"</span>)<span style=\\\"color:#cc7832;\\\">;<br></span><span style=\\\"background-color:#344134;\\\">blog</span>.setSeeScope(SeeScope.<span style=\\\"color:#9876aa;font-style:italic;\\\">PRIVATE</span>)<span style=\\\"color:#cc7832;\\\">;<br></span><span style=\\\"background-color:#344134;\\\">blog</span>.setStatus(BlogStatus.<span style=\\\"color:#9876aa;font-style:italic;\\\">FINISH</span>)<span style=\\\"color:#cc7832;\\\">;<br></span><span style=\\\"background-color:#344134;\\\">blog</span>.setDevice(Device.<span style=\\\"color:#9876aa;font-style:italic;\\\">PC</span>)<span style=\\\"color:#cc7832;\\\">;<br></span><span style=\\\"background-color:#344134;\\\">blog</span>.setLocation(<span style=\\\"color:#6a8759;\\\">\\\"四川成都\\\"</span>)<span style=\\\"color:#cc7832;\\\">;</span></pre><p>java.daimai</p><p>好吧</p><p><br></p><p><br></p>\"}', ''), ('8eab899588fd47a2b7e3', '2016-05-11 20:50:02', '2016-05-11 20:50:02', 'ttt', '1462601551357', 'ttt', 'STANDARD', '默认', '1', 'FINISH', '1', '四川成都', '{\"title\":\"ttt\",\"content\":\"ddd\"}', ''), ('97715edd61b44d1c89d3', '2016-05-08 20:10:41', '2016-05-08 20:10:41', 'JAVA设计模式', '11', '李洋涛', 'STANDARD', '默认', '1', 'FINISH', '1', '四川成都', '{\"title\":\"JAVA设计模式\",\"content\":\"<p>java设计模式中经典的单例模式<span style=\\\"text-indent: 28px;\\\">单例模式是一种常用的软件设计模式。在它的核心结构中只包含一个被称为单例的特殊类。通过单例模式可以保证系统中一个类只有一个实例</span></p><p><img src=\\\"http://freturn.oss-cn-hangzhou.aliyuncs.com/upload/img/user/f2e93210c5efb34863c334347c9425f3.jpg\\\" data-filename=\\\"上传图片\\\" style=\\\"width: 439.844px; height: 237.159px;\\\"><span style=\\\"text-indent: 28px;\\\"><br></span></p><p><span style=\\\"letter-spacing: 0.1px; line-height: 23.998px;\\\">java设计模式中经典的单例模式</span><span style=\\\"letter-spacing: 0.1px; line-height: 23.998px; text-indent: 28px;\\\">单例模式是一种常用的软件设计模式。在它的核心结构中只包含一个被称为单例的特殊类。通过单例模式可以保证系统中一个类只有一个实例</span><span style=\\\"text-indent: 28px;\\\"><br></span></p>\"}', ''), ('ba9c872f0fc04d759c98', '2016-05-06 15:30:26', '2016-05-06 15:30:26', '博客测试标题', '11', '李洋涛', 'STANDARD', '默认', '1', 'FINISH', '1', '四川成都', '{\"title\":\"博客测试标题\",\"content\":\"<p>ddddd</p><ol><li>d</li><li>d</li><li>d</li><li>d</li></ol><p><br></p><p><span style=\\\"background-color: rgb(255, 255, 0);\\\">好吧</span></p><p>\\r\\n                                \\r\\n                            </p>\"}', ''), ('f83d2f1618ef484fb6df', '2016-05-08 19:22:13', '2016-05-08 19:22:13', '这是测试博客', '11', '李洋涛', 'STANDARD', '默认', '1', 'FINISH', '1', '四川成都', '{\"title\":\"这是测试博客\",\"content\":\"<p>hi,all</p><p>这是一篇测试博客。。</p><p>关注我，</p><p><img src=\\\"http://freturn.oss-cn-hangzhou.aliyuncs.com/upload/img/user/0cff48a94ee0d4f2139fd7a3c2f295e3.jpg\\\" data-filename=\\\"上传图片\\\" style=\\\"width: 740px;\\\"><br></p>\"}', '');
COMMIT;

-- ----------------------------
--  Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `domain_id` varchar(20) DEFAULT NULL,
  `domain_type` int(8) DEFAULT NULL,
  `domain_name` varchar(100) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `user_nick_name` varchar(50) DEFAULT NULL,
  `type` int(8) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `creator_id` varchar(20) DEFAULT NULL,
  `creator_nick_name` varchar(50) DEFAULT NULL,
  `creator_icon_url` varchar(300) DEFAULT NULL,
  `device` int(8) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_pk` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `comment`
-- ----------------------------
BEGIN;
INSERT INTO `comment` VALUES ('1', '2016-04-28 21:43:44', '2016-04-28 21:43:47', null, null, null, null, null, null, '深度好闻Maecenas a vehicula urna, at tempu In sed tempor sem.', null, null, null, null, '11', '6'), ('2', '2016-05-09 10:53:21', '2016-05-09 10:53:21', 'ba9c872f0fc04d759c98', '1', '博客测试标题', null, null, '1', '111', null, '11', '李洋涛', null, '1', '中国'), ('3', '2016-05-09 19:37:26', '2016-05-09 19:37:26', 'ba9c872f0fc04d759c98', '1', '博客测试标题', null, null, '1', 'dd', null, '11', '李洋涛', null, '1', '中国'), ('4', '2016-05-09 19:37:46', '2016-05-09 19:37:46', 'ba9c872f0fc04d759c98', '1', '博客测试标题', null, null, '1', '如果人人多一点爱', null, '11', '李洋涛', null, '1', '中国'), ('5', '2016-05-10 13:45:33', '2016-05-10 13:45:33', 'ba9c872f0fc04d759c98', '1', '博客测试标题', '11', '李洋涛', '1', 'cececece', null, '11', '李洋涛', 'http://freturn.oss-cn-hangzhou.aliyuncs.com/img/lyt.jpeg', '1', '中国'), ('6', '2016-05-10 13:45:52', '2016-05-10 13:45:52', 'ba9c872f0fc04d759c98', '1', '博客测试标题', '11', '李洋涛', '1', 'dddd', null, '11', '李洋涛', 'http://freturn.oss-cn-hangzhou.aliyuncs.com/img/lyt.jpeg', '1', '中国'), ('7', '2016-05-10 13:46:08', '2016-05-10 13:46:08', '8a0d4af618864daea707', '1', 'jujingwei永久分支', '11', '李洋涛', '1', 'dddd', null, '11', '李洋涛', 'http://freturn.oss-cn-hangzhou.aliyuncs.com/img/lyt.jpeg', '1', '中国'), ('8', '2016-05-10 13:46:16', '2016-05-10 13:46:16', '8a0d4af618864daea707', '1', 'jujingwei永久分支', '11', '李洋涛', '1', 'ddd', null, '11', '李洋涛', 'http://freturn.oss-cn-hangzhou.aliyuncs.com/img/lyt.jpeg', '1', '中国'), ('9', '2016-05-10 13:46:26', '2016-05-10 13:46:26', '97715edd61b44d1c89d3', '1', 'JAVA设计模式', '11', '李洋涛', '1', 'ddd', null, '11', '李洋涛', 'http://freturn.oss-cn-hangzhou.aliyuncs.com/img/lyt.jpeg', '1', '中国'), ('10', '2016-05-10 13:46:38', '2016-05-10 13:46:38', '97715edd61b44d1c89d3', '1', 'JAVA设计模式', '11', '李洋涛', '1', 'dddddddd', null, '11', '李洋涛', 'http://freturn.oss-cn-hangzhou.aliyuncs.com/img/lyt.jpeg', '1', '中国'), ('11', '2016-05-10 13:48:23', '2016-05-10 13:48:23', '97715edd61b44d1c89d3', '1', 'JAVA设计模式', '11', '李洋涛', '1', 'hahdhdhd', null, '1462601551357', 'ttt', null, '1', '中国');
COMMIT;

-- ----------------------------
--  Table structure for `label`
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `scope` varchar(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `count` int(14) DEFAULT NULL,
  `creator_id` varchar(20) DEFAULT NULL,
  `creator_nick_name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `label`
-- ----------------------------
BEGIN;
INSERT INTO `label` VALUES ('1', '2016-04-27 15:02:03', '2016-04-27 15:02:06', 'CATEGORY', 'JAVA技术', null, null, null, '文章分类'), ('2', '2016-04-27 15:02:32', '2016-04-27 15:02:34', 'CATEGORY', '设计模式', null, null, null, '文章分类'), ('3', '2016-04-27 15:02:47', '2016-04-27 15:02:49', 'CATEGORY', '数据库技术', null, null, null, '文章分类'), ('4', '2016-04-27 19:16:33', '2016-04-27 19:16:36', 'CATEGORY', '搜索引擎', null, null, null, '文章分类'), ('5', '2016-04-27 19:16:59', '2016-04-27 19:17:01', 'CATEGORY', '推荐系统', null, null, null, '文章分类'), ('6', '2016-04-27 19:17:20', '2016-04-27 19:17:22', 'LABEL', '深度好文', null, null, null, '标签'), ('7', '2016-04-27 19:17:55', '2016-04-27 19:17:58', 'LABEL', '娱乐', null, '10', null, '标签'), ('8', '2016-04-27 19:19:21', '2016-04-27 19:19:24', 'LABEL', '购物', null, '10', null, '标签'), ('9', '2016-05-04 13:37:26', '2016-05-04 13:37:26', 'blog', 'JAVA核心技术', null, '11', 'liyangtao', 'description'), ('10', '2016-05-04 13:38:30', '2016-05-04 18:57:33', 'blog', 'JAVA核心技术', null, '11', '李洋涛', 'description');
COMMIT;

-- ----------------------------
--  Table structure for `user_base_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_base_info`;
CREATE TABLE `user_base_info` (
  `id` varchar(20) NOT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL COMMENT '注册用户名',
  `pass_word` varchar(20) DEFAULT NULL,
  `type` int(8) DEFAULT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `icon_url` varchar(300) DEFAULT NULL,
  `self_introduction` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user_base_info`
-- ----------------------------
BEGIN;
INSERT INTO `user_base_info` VALUES ('11', '2016-04-27 14:24:07', '2016-04-27 14:24:10', '645774075@qq.com', '123', '1', '李洋涛', 'http://freturn.oss-cn-hangzhou.aliyuncs.com/img/lyt.jpeg', '我是一枚程序猿,热爱代码,热爱生活.'), ('1462601551357', '2016-05-07 14:12:31', '2016-05-07 14:12:31', 'yangtao.lyt@alibaba-inc.com', '123', '1', 'ttt', null, null), ('1462601928066', '2016-05-07 14:18:48', '2016-05-07 14:18:48', 'yangtao.lyt@alibaba.com', '123', '1', 'dd', null, null), ('1462604578331', '2016-05-07 15:02:58', '2016-05-07 15:02:58', 'yangtao.lyt@tt.com', '123', '1', 'ttt', null, null), ('1462604688807', '2016-05-07 15:04:48', '2016-05-07 15:04:48', 'yangtao.lyt@ttddd.com', '123', '1', 'ddd', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `user_ext_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_ext_info`;
CREATE TABLE `user_ext_info` (
  `id` varchar(20) NOT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `user_nick_name` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `ext_name` varchar(50) DEFAULT NULL,
  `ext_value` varchar(500) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user_ext_info`
-- ----------------------------
BEGIN;
INSERT INTO `user_ext_info` VALUES ('1', '2016-04-28 19:03:07', '2016-04-28 19:03:10', '11', null, 'LINK', 'walkwithus site', 'http://walkwithus.cn:8080', null), ('2', '2016-04-28 19:03:54', '2016-04-28 19:03:56', '11', null, 'LINK', 'web archetype', 'https://github.com/FReturn/archetype', null), ('3', '2016-05-06 13:26:19', '2016-05-06 13:26:21', '11', null, 'CATEGORY', 'JAVA技术', '2', null), ('4', '2016-05-06 13:29:20', '2016-05-06 13:29:24', '11', null, 'CATEGORY', '设计模式', '12', null), ('5', '2016-05-06 13:29:49', '2016-05-06 13:29:51', '11', null, 'CATEGORY', '数据库', '3', null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
