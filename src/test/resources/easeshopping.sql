DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uid` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `salt` varchar(35) NOT NULL,
  `role` varchar(20) NOT NULL,
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
INSERT INTO `user` (`id`, `uid`, `username`, `password`, `salt`, `role`)
VALUES
(1, MD5('37254660e226ea65ce6f1efd54233424'),'buyer', MD5('37254660e226ea65ce6f1efd54233424'),'buyer', 'BUYER'),
(2, MD5('981c57a5cfb0f868e064904b8745766f'),'seller', MD5('981c57a5cfb0f868e064904b8745766f'),'seller', 'SELLER');

DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cid` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `picture` varchar(1024) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `price` float(10,2) NOT NULL,
  `quantity` int(5) NULL DEFAULT 99999,
  `is_selled` int(1) NOT NULL DEFAULT 0,
  selled_quantity int(5) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cid` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `buy_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `picture` varchar(1024) NOT NULL,
  `price` float(10,2) NOT NULL,
  `quantity` int(5) NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cid` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `price` float(10,2) NOT NULL,
  `quantity` int(5) NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


