CREATE DATABASE  IF NOT EXISTS `ish_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ish_db`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: localhost    Database: ish_db
-- ------------------------------------------------------
-- Server version	5.6.13

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
-- Table structure for table `class_details`
--

DROP TABLE IF EXISTS `class_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_details` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(11) NOT NULL,
  `class_teacher` int(11) DEFAULT NULL,
  `student_count` varchar(45) DEFAULT NULL,
  `class_start` int(11) NOT NULL,
  `active` varchar(45) NOT NULL,
  PRIMARY KEY (`class_id`),
  UNIQUE KEY `class_id_UNIQUE` (`class_id`),
  KEY `teacher_ref_idx` (`class_teacher`),
  KEY `class_name_ref_idx` (`class_name`),
  CONSTRAINT `teacher_ref` FOREIGN KEY (`class_teacher`) REFERENCES `teacher_details` (`teacher_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='table to represent each class';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_details`
--

LOCK TABLES `class_details` WRITE;
/*!40000 ALTER TABLE `class_details` DISABLE KEYS */;
INSERT INTO `class_details` VALUES (1,'1 A',1,'1',2012,'active'),(2,'2 A',2,'2',2012,'active'),(3,'1 C',3,'10',2012,'inactive'),(29,'4 A',4,NULL,2012,'active'),(30,'5 A',5,NULL,2012,'active'),(39,'6 A',6,NULL,2012,'active'),(40,'7 A',7,NULL,2012,'active'),(41,'8 A',8,NULL,2012,'active'),(43,'9 A',9,NULL,2012,'active'),(44,'10 A',10,NULL,2012,'active'),(45,'2 B',11,NULL,2012,'active');
/*!40000 ALTER TABLE `class_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-12 17:14:11
