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
-- Table structure for table `class_exam_details`
--

DROP TABLE IF EXISTS `class_exam_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_exam_details` (
  `class_exam_details_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `exam_reference_data_id` int(11) NOT NULL,
  PRIMARY KEY (`class_exam_details_id`),
  KEY `subject_reference_data_id_idx` (`exam_reference_data_id`),
  KEY `class_subject_ref_id_idx` (`class_id`),
  KEY `exam__idx` (`exam_reference_data_id`),
  KEY `exam_class_ref_idx` (`class_id`),
  CONSTRAINT `exam_class_ref` FOREIGN KEY (`class_id`) REFERENCES `class_details` (`class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `exam_reference_data_ref` FOREIGN KEY (`exam_reference_data_id`) REFERENCES `reference_data` (`reference_data_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_exam_details`
--

LOCK TABLES `class_exam_details` WRITE;
/*!40000 ALTER TABLE `class_exam_details` DISABLE KEYS */;
INSERT INTO `class_exam_details` VALUES (30,2,46),(31,2,47),(32,2,45),(33,3,46),(34,3,47),(35,3,45),(36,29,46),(37,29,47),(38,29,45),(67,1,46),(68,1,45),(69,1,43),(70,1,44),(87,39,44),(88,39,45),(94,30,46),(95,30,45),(96,30,43),(100,40,43),(101,40,44),(102,40,45),(103,40,46),(104,41,44),(105,41,43),(106,43,43),(107,43,45),(108,43,44),(109,44,43),(110,44,45),(111,45,43),(112,45,44);
/*!40000 ALTER TABLE `class_exam_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-19 17:10:30
