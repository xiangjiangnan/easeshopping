DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(35) DEFAULT NULL,
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `login_ticket`;
CREATE TABLE `login_ticket` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `ticket` varchar(100) DEFAULT NULL,
  `expired` datetime DEFAULT CURRENT_TIMESTAMP,
  `status` int DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ticket_index` (`ticket` ASC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cid` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `picture` varchar(1024) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `price` float(5,2) NOT NULL,
  `quantity` int(5) NULL DEFAULT 99999,
  `is_selled` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cid` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `buy_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `picture` varchar(1024) NOT NULL,
  `price` float(5,2) NOT NULL,
  `quantity` int(5) NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cid` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `price` float(5,2) NOT NULL,
  `quantity` int(5) NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



