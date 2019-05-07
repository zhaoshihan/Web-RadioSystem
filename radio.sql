CREATE DATABASE  IF NOT EXISTS `radio` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `radio`;
-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: localhost    Database: radio
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `gender` varchar(1) NOT NULL,
  `city` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `postcode` varchar(10) NOT NULL,
  `phonenumber` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `account` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_UNIQUE` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'zhangsan','m','Wuhan','Hongsan Street','430032','15612345678','zhangsan@qq.com','zhangsan','123456'),(2,'lisi','m','Beijing','Changan Street','100010','19312345678','lisi@163.com','lisi','123'),(3,'String','f','String','String','String','String','String','String','String');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order` (
  `id` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `memberID` int(11) NOT NULL,
  `orderDate` date NOT NULL,
  `unitprice` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `sendDate` date NOT NULL,
  `sendAddress` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`memberID`),
  KEY `productID_idx` (`productID`),
  CONSTRAINT `memberID` FOREIGN KEY (`memberID`) REFERENCES `member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `productID` FOREIGN KEY (`productID`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,1,1,'1970-01-01',100,1,'1970-01-02','Shanghai'),(268222461,1,1,'2019-05-06',100,10,'2019-05-06','Hongsan Street');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `type` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `discount` int(11) DEFAULT NULL,
  `habitat` varchar(45) NOT NULL,
  `director` varchar(45) NOT NULL,
  `superstar` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Light','The Foggy Drew',100,80,'Switzerland','Bandari','Bandari','2001-03-10','A light music that describe the countryside scenery'),(2,'Light','Snowdreams',70,50,'Switzerland','Bandari','Bandari','2017-07-28','Romantic pace that desctibe the beautiful scenery at the Winter days'),(3,'Traditional','Maiden of Alisan',30,25,'China','Liu ZiLing','Liu ZiLing','2015-06-11','A traditional chinese music describe the love story in Taiwan'),(4,'Traditional','Autumn Moon over the Calm Lake',50,40,'China','Guzheng','Guzheng','2011-11-29','Tradition chinese music using Guzheng instrument'),(5,'Traditional','The Wizard of Oz',100,90,'China','Chen Yue','Chen Yue','2011-09-05','The bamboo flute is played vertically, like the western recorder'),(6,'Traditional','A Spray of Plum Blossoms',100,95,'China','Fei YuQing','Fei YuQing','2017-04-22','The lyrics describe a love oath that using the traditonal chinese metaphor'),(7,'Symphony','Main Title',80,70,'America','Ramin Djawadi','Ramin Djawadi','2013-10-25','The main title from \"Game of Thrones\"'),(8,'Symphony','Khaleesi',70,65,'America','Ramin Djawadi','Ramin Djawadi','2016-06-23','A slot sundtrack in Game of Thrones Season 6'),(9,'Classic','My Motherland',50,30,'China','Guo LanYing','Guo LanYing','2009-12-05','A patriotism song that comes from a old movie'),(10,'Classic','Paean of Heros',40,35,'China','Zhang YIngZhe','Zhang YIngZhe','2010-09-26','A slot song from movie that describe Korean War');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `account` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_UNIQUE` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'zhaoshihan','zsh','123'),(2,'jiajing','andrew','123'),(10,'isname','test','test');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-07 10:43:03
