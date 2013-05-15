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
-- Table structure for table `class_time_table`
--

DROP TABLE IF EXISTS `class_time_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_time_table` (
  `class_time_table_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `period_seq` varchar(45) NOT NULL,
  `day_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `class_start_time` varchar(30) DEFAULT NULL,
  `class_end_time` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`class_time_table_id`),
  UNIQUE KEY `class_time_table_id_UNIQUE` (`class_time_table_id`),
  KEY `class_ref_idx` (`class_id`),
  KEY `subject_ref_idx` (`subject_id`),
  KEY `day_ref_idx` (`day_id`),
  CONSTRAINT `time_table_class_ref` FOREIGN KEY (`class_id`) REFERENCES `class_details` (`class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `time_table_day_ref` FOREIGN KEY (`day_id`) REFERENCES `reference_data` (`reference_data_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `time_table_subject_ref` FOREIGN KEY (`subject_id`) REFERENCES `class_subject_details` (`class_subject_details_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8 COMMENT='table which contains the time_table for a particular class';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_time_table`
--

LOCK TABLES `class_time_table` WRITE;
/*!40000 ALTER TABLE `class_time_table` DISABLE KEYS */;
INSERT INTO `class_time_table` VALUES (133,39,'Period 1',10,46,'10:37','11:18'),(134,39,'Period 2',10,45,'07:29','07:34'),(135,39,'Period 3',10,44,'',''),(136,39,'Period 4',10,44,'',''),(137,39,'Period 5',10,44,'',''),(138,39,'Period 6',10,44,'',''),(139,39,'Period 7',10,44,'',''),(140,39,'Period 8',10,44,'',''),(141,39,'Period 1',11,44,'',''),(142,39,'Period 2',11,44,'',''),(143,39,'Period 3',11,44,'',''),(144,39,'Period 4',11,44,'',''),(145,39,'Period 5',11,44,'',''),(146,39,'Period 6',11,44,'',''),(147,39,'Period 7',11,44,'',''),(148,39,'Period 8',11,44,'',''),(149,39,'Period 1',12,44,'',''),(150,39,'Period 2',12,44,'',''),(151,39,'Period 3',12,44,'',''),(152,39,'Period 4',12,44,'',''),(153,39,'Period 5',12,44,'',''),(154,39,'Period 6',12,44,'',''),(155,39,'Period 7',12,44,'',''),(156,39,'Period 8',12,44,'',''),(157,39,'Period 1',13,44,'',''),(158,39,'Period 2',13,44,'',''),(159,39,'Period 3',13,44,'',''),(160,39,'Period 4',13,44,'',''),(161,39,'Period 5',13,44,'',''),(162,39,'Period 6',13,44,'',''),(163,39,'Period 7',13,44,'',''),(164,39,'Period 8',13,44,'',''),(165,39,'Period 1',14,44,'',''),(166,39,'Period 2',14,44,'',''),(167,39,'Period 3',14,44,'',''),(168,39,'Period 4',14,44,'',''),(169,39,'Period 5',14,44,'',''),(170,39,'Period 6',14,44,'',''),(171,39,'Period 7',14,44,'',''),(172,39,'Period 8',14,44,'',''),(173,39,'Period 1',15,44,'',''),(174,39,'Period 2',15,44,'',''),(175,39,'Period 3',15,44,'',''),(176,39,'Period 4',15,44,'','');
/*!40000 ALTER TABLE `class_time_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-15 16:36:41
