-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: easeshopping
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cid` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `buy_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `picture` varchar(1024) NOT NULL,
  `price` float(10,2) NOT NULL,
  `quantity` int(5) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'niBavgSgO0WeIFq+BKA7Re3epUTHZsM+','云音乐','2019-01-18 13:57:35','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1546959980942&di=c8a7d3aedc0a6385648b84f858086a53&imgtype=0&src=http%3A%2F%2Fpic31.photophoto.cn%2F20140624%2F0007019944077411_b.jpg',15.00,1),(2,'re8LZyXBIRCt7wtnJcEhEGs3aI6pic4G','小猪','2019-01-18 14:06:29','https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1547644090&di=939442cad259d3237f20e633aad42340&src=http://pic.90sjimg.com/design/00/72/26/90/592fa210b2d88.png!/fwfh/804x889/quality/90/unsharp/true/compress/true',18.00,1),(3,'niBavgSgO0WeIFq+BKA7Re3epUTHZsM+','云音乐','2019-01-18 14:15:21','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1546959980942&di=c8a7d3aedc0a6385648b84f858086a53&imgtype=0&src=http%3A%2F%2Fpic31.photophoto.cn%2F20140624%2F0007019944077411_b.jpg',15.00,1),(4,'re8LZyXBIRCt7wtnJcEhEGs3aI6pic4G','小猪','2019-01-18 14:15:21','https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1547644090&di=939442cad259d3237f20e633aad42340&src=http://pic.90sjimg.com/design/00/72/26/90/592fa210b2d88.png!/fwfh/804x889/quality/90/unsharp/true/compress/true',18.00,1),(5,'iGE++xQpGiuIYT77FCkaK3tfhbFLj2Xp','黑猪','2019-01-18 15:51:48','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547212080441&di=da613af4af5444d4007fe91fd48ae116&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fdesign%2F00%2F79%2F50%2F59%2F58db72685ef1f.png',100.00,1),(6,'kSQjxfSuGzWRJCPF9K4bNZFMP3dseB2i','虫子','2019-01-20 18:26:35','d74521ebe1754d989ddd6ec29545f2ba.jpg',12.00,1),(7,'niBavgSgO0WeIFq+BKA7Re3epUTHZsM+','云音乐','2019-01-20 20:11:46','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1546959980942&di=c8a7d3aedc0a6385648b84f858086a53&imgtype=0&src=http%3A%2F%2Fpic31.photophoto.cn%2F20140624%2F0007019944077411_b.jpg',15.00,1),(8,'k2gmVjdZMteTaCZWN1ky19v6hPQFyhUz','test','2019-01-21 22:07:22','c16d2a6bc367451aada17efbb47f5f33.jpg',111.00,1),(9,'iGE++xQpGiuIYT77FCkaK3tfhbFLj2Xp','黑猪','2019-01-22 10:24:25','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547212080441&di=da613af4af5444d4007fe91fd48ae116&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fdesign%2F00%2F79%2F50%2F59%2F58db72685ef1f.png',100.00,1),(10,'uFpKYIt0jLu4Wkpgi3SMuy3hIPMBk3f7','Ubuntu','2019-01-22 11:14:53','06086e49e6054b24b9fb2d80ed1082a0.png',10.24,2),(11,'l5Sm9WKQGb6XlKb1YpAZvukzUskUZYAm','送福','2019-01-22 11:15:15','a8816db4fe774092a2064c8854ac46b5.jpg',2019.19,1),(12,'m/GRj/cbNdCb8ZGP9xs10OkzUskUZYAn','猫咪','2019-01-22 15:19:33','8dfa93d074da47a5bd667ed10596d2c0.jpg',1314.13,2),(15,'m/GRj/cbNdCb8ZGP9xs10OkzUskUZYAn','猫咪','2019-01-22 19:56:56','8dfa93d074da47a5bd667ed10596d2c0.jpg',1314.13,1),(16,'niBavgSgO0WeIFq+BKA7Re3epUTHZsM+','云音乐','2019-02-22 20:48:46','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1546959980942&di=c8a7d3aedc0a6385648b84f858086a53&imgtype=0&src=http%3A%2F%2Fpic31.photophoto.cn%2F20140624%2F0007019944077411_b.jpg',15.00,3);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cid` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `price` float(10,2) NOT NULL,
  `quantity` int(5) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity`
--

DROP TABLE IF EXISTS `commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commodity` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cid` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `picture` varchar(1024) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `price` float(10,2) NOT NULL,
  `quantity` int(5) DEFAULT '99999',
  `is_selled` int(1) NOT NULL DEFAULT '0',
  `selled_quantity` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity`
--

LOCK TABLES `commodity` WRITE;
/*!40000 ALTER TABLE `commodity` DISABLE KEYS */;
INSERT INTO `commodity` VALUES (1,'niBavgSgO0WeIFq+BKA7Re3epUTHZsM+','云音乐','网易云音乐','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1546959980942&di=c8a7d3aedc0a6385648b84f858086a53&imgtype=0&src=http%3A%2F%2Fpic31.photophoto.cn%2F20140624%2F0007019944077411_b.jpg','一款很棒的音乐软件',15.00,99995,1,6),(3,'re8LZyXBIRCt7wtnJcEhEGs3aI6pic4G','小猪','可爱的小猪','https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1547644090&di=939442cad259d3237f20e633aad42340&src=http://pic.90sjimg.com/design/00/72/26/90/592fa210b2d88.png!/fwfh/804x889/quality/90/unsharp/true/compress/true','会跳舞的小猪。',18.00,99999,1,2),(4,'kSQjxfSuGzWRJCPF9K4bNZFMP3dseB2i','虫子','虫子大作战','9dcc2ecf12ae4e90984e03b27342a6bb.jpg','虫子中的战斗机。',16.00,99998,1,1),(5,'iGE++xQpGiuIYT77FCkaK3tfhbFLj2Xp','黑猪','肥猪','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547212080441&di=da613af4af5444d4007fe91fd48ae116&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fdesign%2F00%2F79%2F50%2F59%2F58db72685ef1f.png','肥而不腻，肉中上品。',100.00,99998,1,2),(10,'k2gmVjdZMteTaCZWN1ky19v6hPQFyhUz','test','test1','c16d2a6bc367451aada17efbb47f5f33.jpg','test test',111.00,99998,1,1),(12,'uFpKYIt0jLu4Wkpgi3SMuy3hIPMBk3f7','Ubuntu','开源软件','06086e49e6054b24b9fb2d80ed1082a0.png','拥抱开源，共同进步。',10.24,99995,1,4),(13,'l5Sm9WKQGb6XlKb1YpAZvukzUskUZYAm','送福','迎新春','a8816db4fe774092a2064c8854ac46b5.jpg','新年新气象。',2019.19,99998,1,1),(14,'m/GRj/cbNdCb8ZGP9xs10OkzUskUZYAn','猫咪','欢乐猫','8dfa93d074da47a5bd667ed10596d2c0.jpg','笑嘻嘻笑哈哈。',1314.13,99996,1,3),(16,'hlHAkqnMg2KGUcCSqcyDYh2qtBSyMSCI','test9','asas','awrwefrew','vcxvv',1.32,99999,0,0);
/*!40000 ALTER TABLE `commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2120f72b4b5af10ddb9356903a6a5acb','buyer','2120f72b4b5af10ddb9356903a6a5acb','buyer','BUYER','2019-01-19 15:38:01'),(2,'125a5f8f76f01a923347f61c30d46d33','seller','125a5f8f76f01a923347f61c30d46d33','seller','SELLER','2019-01-19 15:38:01');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-25 21:56:00
