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
  `teacher_id` int(11) NOT NULL,
  `day_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `class_start_time` varchar(30) DEFAULT NULL,
  `class_end_time` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`class_time_table_id`),
  UNIQUE KEY `class_time_table_id_UNIQUE` (`class_time_table_id`),
  KEY `class_ref_idx` (`class_id`),
  KEY `subject_ref_idx` (`subject_id`),
  KEY `day_ref_idx` (`day_id`),
  KEY `time_table_teacher_ref_idx` (`teacher_id`),
  CONSTRAINT `time_table_class_ref` FOREIGN KEY (`class_id`) REFERENCES `class_details` (`class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `time_table_day_ref` FOREIGN KEY (`day_id`) REFERENCES `reference_data` (`reference_data_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `time_table_subject_ref` FOREIGN KEY (`subject_id`) REFERENCES `reference_data` (`reference_data_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `time_table_teacher_ref` FOREIGN KEY (`teacher_id`) REFERENCES `teacher_details` (`teacher_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='table which contains the time_table for a particular class';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_time_table`
--

LOCK TABLES `class_time_table` WRITE;
/*!40000 ALTER TABLE `class_time_table` DISABLE KEYS */;
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

-- Dump completed on 2013-02-23 22:27:45
