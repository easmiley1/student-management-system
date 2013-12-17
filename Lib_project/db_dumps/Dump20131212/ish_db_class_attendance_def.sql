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
-- Table structure for table `class_attendance_def`
--

DROP TABLE IF EXISTS `class_attendance_def`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_attendance_def` (
  `attendance_month_id` int(11) NOT NULL AUTO_INCREMENT,
  `month_year` varchar(30) NOT NULL,
  `class_id` int(11) NOT NULL,
  PRIMARY KEY (`attendance_month_id`),
  UNIQUE KEY `attendance_month_id_UNIQUE` (`attendance_month_id`),
  KEY `class_id_ref_idx` (`class_id`),
  CONSTRAINT `class_id_ref` FOREIGN KEY (`class_id`) REFERENCES `class_details` (`class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='table to contain all the months for attendance register for a particular class';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_attendance_def`
--

LOCK TABLES `class_attendance_def` WRITE;
/*!40000 ALTER TABLE `class_attendance_def` DISABLE KEYS */;
INSERT INTO `class_attendance_def` VALUES (50,'March-2013',39),(54,'August-2013',39),(56,'February-2013',39),(57,'May-2013',1),(58,'October-2013',39),(59,'September-2013',39),(60,'October-2013',3),(61,'October-2013',43),(62,'October-2013',30),(63,'October-2013',2),(64,'October-2013',29),(65,'November-2013',41),(66,'November-2013',40);
/*!40000 ALTER TABLE `class_attendance_def` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-12 17:14:10
