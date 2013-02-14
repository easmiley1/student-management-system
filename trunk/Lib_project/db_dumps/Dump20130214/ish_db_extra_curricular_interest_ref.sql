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
-- Table structure for table `extra_curricular_interest_ref`
--

DROP TABLE IF EXISTS `extra_curricular_interest_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `extra_curricular_interest_ref` (
  `extra_curricular_interest_ref_id` int(11) NOT NULL AUTO_INCREMENT,
  `extra_curricular_interest` varchar(45) NOT NULL,
  PRIMARY KEY (`extra_curricular_interest_ref_id`),
  UNIQUE KEY `extra_curricular_interest_ref_id_UNIQUE` (`extra_curricular_interest_ref_id`),
  UNIQUE KEY `extra_curricular_interest_UNIQUE` (`extra_curricular_interest`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='Reference table for extra curricular interests';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extra_curricular_interest_ref`
--

LOCK TABLES `extra_curricular_interest_ref` WRITE;
/*!40000 ALTER TABLE `extra_curricular_interest_ref` DISABLE KEYS */;
INSERT INTO `extra_curricular_interest_ref` VALUES (3,'Basketball'),(4,'Cricket'),(2,'Football'),(1,'Music'),(6,'Others(comments)'),(5,'Tennis');
/*!40000 ALTER TABLE `extra_curricular_interest_ref` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-14  0:29:31
