CREATE DATABASE  IF NOT EXISTS `ish_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ish_db`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: ish_db
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `blood_group_ref`
--

DROP TABLE IF EXISTS `blood_group_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blood_group_ref` (
  `blood_group_id` int(11) NOT NULL AUTO_INCREMENT,
  `blood_group_name` varchar(5) NOT NULL,
  PRIMARY KEY (`blood_group_id`),
  UNIQUE KEY `blood_group_name_UNIQUE` (`blood_group_name`),
  UNIQUE KEY `blood_group_id_UNIQUE` (`blood_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='reference table for blood group';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blood_group_ref`
--

LOCK TABLES `blood_group_ref` WRITE;
/*!40000 ALTER TABLE `blood_group_ref` DISABLE KEYS */;
INSERT INTO `blood_group_ref` VALUES (4,'A+'),(3,'A-'),(8,'AB+'),(7,'AB-'),(6,'B+'),(5,'B-'),(2,'O+'),(1,'O-');
/*!40000 ALTER TABLE `blood_group_ref` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-14  0:29:27
