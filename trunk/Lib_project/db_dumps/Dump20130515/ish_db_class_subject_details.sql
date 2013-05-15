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
-- Table structure for table `class_subject_details`
--

DROP TABLE IF EXISTS `class_subject_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_subject_details` (
  `class_subject_details_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `subject_reference_data_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`class_subject_details_id`),
  UNIQUE KEY `class_reference_data_id_UNIQUE` (`class_subject_details_id`),
  KEY `reference_class_ref_idx` (`class_id`),
  KEY `reference_data_ref_idx` (`subject_reference_data_id`),
  KEY `exam_class_ref_idx` (`class_id`),
  KEY `subject_teacher_ref_idx` (`teacher_id`),
  CONSTRAINT `subject_class_ref` FOREIGN KEY (`class_id`) REFERENCES `class_details` (`class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `subject_reference_data_ref` FOREIGN KEY (`subject_reference_data_id`) REFERENCES `reference_data` (`reference_data_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `subject_teacher_ref` FOREIGN KEY (`teacher_id`) REFERENCES `teacher_details` (`teacher_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 COMMENT='Table to contain reference data for class';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_subject_details`
--

LOCK TABLES `class_subject_details` WRITE;
/*!40000 ALTER TABLE `class_subject_details` DISABLE KEYS */;
INSERT INTO `class_subject_details` VALUES (19,1,33,1),(20,1,34,1),(44,39,35,1),(45,39,36,1),(46,39,37,1),(47,39,38,1),(48,39,39,1),(49,39,40,1),(62,30,34,1),(63,30,35,1),(70,39,34,1),(71,40,33,1),(72,40,34,1),(73,40,35,1),(74,40,36,1),(75,40,37,1),(76,41,33,1),(77,41,34,1),(78,41,35,1),(79,41,36,1),(80,43,33,1),(81,43,34,1),(82,43,35,1);
/*!40000 ALTER TABLE `class_subject_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-15 16:36:39
