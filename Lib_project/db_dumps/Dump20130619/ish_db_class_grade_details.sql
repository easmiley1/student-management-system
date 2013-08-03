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
-- Table structure for table `class_grade_details`
--

DROP TABLE IF EXISTS `class_grade_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_grade_details` (
  `class_grade_details_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_subject_details_id` int(11) NOT NULL,
  `class_exam_details_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `mark` int(11) DEFAULT NULL,
  `grade` char(1) DEFAULT NULL,
  `class_id` int(11) NOT NULL,
  PRIMARY KEY (`class_grade_details_id`),
  UNIQUE KEY `class_grade_details_id_UNIQUE` (`class_grade_details_id`),
  KEY `subject_details_ref_idx` (`class_subject_details_id`),
  KEY `exam_details_ref_idx` (`class_exam_details_id`),
  KEY `grade_student_ref_idx` (`student_id`),
  KEY `grade_class_ref_idx` (`class_id`),
  CONSTRAINT `exam_details_ref` FOREIGN KEY (`class_exam_details_id`) REFERENCES `class_exam_details` (`class_exam_details_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `grade_class_ref` FOREIGN KEY (`class_id`) REFERENCES `class_details` (`class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `grade_student_ref` FOREIGN KEY (`student_id`) REFERENCES `student_details` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `subject_details_ref` FOREIGN KEY (`class_subject_details_id`) REFERENCES `class_subject_details` (`class_subject_details_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_grade_details`
--

LOCK TABLES `class_grade_details` WRITE;
/*!40000 ALTER TABLE `class_grade_details` DISABLE KEYS */;
INSERT INTO `class_grade_details` VALUES (1,44,87,2,13,NULL,39),(2,45,87,2,13,NULL,39),(3,48,87,2,0,NULL,39),(4,46,87,2,14,NULL,39),(5,47,87,2,15,NULL,39),(6,70,87,2,0,NULL,39),(7,49,87,2,0,NULL,39),(8,44,87,3,0,NULL,39),(9,45,87,3,0,NULL,39),(10,48,87,3,0,NULL,39),(11,46,87,3,0,NULL,39),(12,47,87,3,0,NULL,39),(13,70,87,3,0,NULL,39),(14,49,87,3,0,NULL,39),(15,44,87,4,0,NULL,39),(16,45,87,4,0,NULL,39),(17,48,87,4,0,NULL,39),(18,46,87,4,0,NULL,39),(19,47,87,4,0,NULL,39),(20,70,87,4,0,NULL,39),(21,49,87,4,0,NULL,39),(22,44,87,5,0,NULL,39),(23,45,87,5,0,NULL,39),(24,48,87,5,0,NULL,39),(25,46,87,5,0,NULL,39),(26,47,87,5,0,NULL,39),(27,70,87,5,0,NULL,39),(28,49,87,5,0,NULL,39),(29,44,87,6,12,NULL,39),(30,45,87,6,13,NULL,39),(31,48,87,6,0,NULL,39),(32,46,87,6,46,NULL,39),(33,47,87,6,0,NULL,39),(34,70,87,6,0,NULL,39),(35,49,87,6,0,NULL,39),(36,44,87,7,11,NULL,39),(37,45,87,7,12,NULL,39),(38,48,87,7,0,NULL,39),(39,46,87,7,12,NULL,39),(40,47,87,7,0,NULL,39),(41,70,87,7,0,NULL,39),(42,49,87,7,0,NULL,39),(43,44,87,8,0,NULL,39),(44,45,87,8,0,NULL,39),(45,48,87,8,0,NULL,39),(46,46,87,8,0,NULL,39),(47,47,87,8,0,NULL,39),(48,70,87,8,0,NULL,39),(49,49,87,8,0,NULL,39),(50,44,87,9,0,NULL,39),(51,45,87,9,0,NULL,39),(52,48,87,9,0,NULL,39),(53,46,87,9,0,NULL,39),(54,47,87,9,0,NULL,39),(55,70,87,9,0,NULL,39),(56,49,87,9,0,NULL,39),(57,44,87,10,0,NULL,39),(58,45,87,10,0,NULL,39),(59,48,87,10,0,NULL,39),(60,46,87,10,0,NULL,39),(61,47,87,10,0,NULL,39),(62,70,87,10,0,NULL,39),(63,49,87,10,0,NULL,39),(64,44,87,11,0,NULL,39),(65,45,87,11,0,NULL,39),(66,48,87,11,0,NULL,39),(67,46,87,11,0,NULL,39),(68,47,87,11,0,NULL,39),(69,70,87,11,0,NULL,39),(70,49,87,11,0,NULL,39),(71,44,87,12,0,NULL,39),(72,45,87,12,0,NULL,39),(73,48,87,12,0,NULL,39),(74,46,87,12,0,NULL,39),(75,47,87,12,0,NULL,39),(76,70,87,12,0,NULL,39),(77,49,87,12,0,NULL,39),(78,44,87,13,0,NULL,39),(79,45,87,13,0,NULL,39),(80,48,87,13,0,NULL,39),(81,46,87,13,0,NULL,39),(82,47,87,13,0,NULL,39),(83,70,87,13,0,NULL,39),(84,49,87,13,0,NULL,39),(85,44,87,14,0,NULL,39),(86,45,87,14,0,NULL,39),(87,48,87,14,0,NULL,39),(88,46,87,14,0,NULL,39),(89,47,87,14,0,NULL,39),(90,70,87,14,0,NULL,39),(91,49,87,14,0,NULL,39),(92,44,87,15,0,NULL,39),(93,45,87,15,0,NULL,39),(94,48,87,15,0,NULL,39),(95,46,87,15,0,NULL,39),(96,47,87,15,0,NULL,39),(97,70,87,15,0,NULL,39),(98,49,87,15,0,NULL,39),(99,44,87,16,0,NULL,39),(100,45,87,16,0,NULL,39),(101,48,87,16,0,NULL,39),(102,46,87,16,0,NULL,39),(103,47,87,16,0,NULL,39),(104,70,87,16,0,NULL,39),(105,49,87,16,0,NULL,39),(106,44,87,17,0,NULL,39),(107,45,87,17,0,NULL,39),(108,48,87,17,0,NULL,39),(109,46,87,17,0,NULL,39),(110,47,87,17,0,NULL,39),(111,70,87,17,0,NULL,39),(112,49,87,17,0,NULL,39),(113,44,87,18,0,NULL,39),(114,45,87,18,0,NULL,39),(115,48,87,18,0,NULL,39),(116,46,87,18,0,NULL,39),(117,47,87,18,0,NULL,39),(118,70,87,18,0,NULL,39),(119,49,87,18,0,NULL,39),(120,44,87,19,0,NULL,39),(121,45,87,19,0,NULL,39),(122,48,87,19,0,NULL,39),(123,46,87,19,0,NULL,39),(124,47,87,19,0,NULL,39),(125,70,87,19,0,NULL,39),(126,49,87,19,0,NULL,39),(127,44,87,2,1,NULL,39),(128,45,87,2,14,NULL,39),(129,48,87,2,0,NULL,39),(130,46,87,2,15,NULL,39),(131,47,87,2,0,NULL,39),(132,70,87,2,0,NULL,39),(133,49,87,2,0,NULL,39),(134,44,87,3,0,NULL,39),(135,45,87,3,0,NULL,39),(136,48,87,3,0,NULL,39),(137,46,87,3,0,NULL,39),(138,47,87,3,0,NULL,39),(139,70,87,3,0,NULL,39),(140,49,87,3,0,NULL,39),(141,44,87,4,0,NULL,39),(142,45,87,4,0,NULL,39),(143,48,87,4,0,NULL,39),(144,46,87,4,0,NULL,39),(145,47,87,4,0,NULL,39),(146,70,87,4,0,NULL,39),(147,49,87,4,0,NULL,39),(148,44,87,5,12,NULL,39),(149,45,87,5,15,NULL,39),(150,48,87,5,0,NULL,39),(151,46,87,5,18,NULL,39),(152,47,87,5,0,NULL,39),(153,70,87,5,0,NULL,39),(154,49,87,5,0,NULL,39),(155,44,87,6,0,NULL,39),(156,45,87,6,0,NULL,39),(157,48,87,6,0,NULL,39),(158,46,87,6,0,NULL,39),(159,47,87,6,0,NULL,39),(160,70,87,6,0,NULL,39),(161,49,87,6,0,NULL,39),(162,44,87,7,0,NULL,39),(163,45,87,7,0,NULL,39),(164,48,87,7,0,NULL,39),(165,46,87,7,0,NULL,39),(166,47,87,7,0,NULL,39),(167,70,87,7,0,NULL,39),(168,49,87,7,0,NULL,39),(169,44,87,8,0,NULL,39),(170,45,87,8,0,NULL,39),(171,48,87,8,0,NULL,39),(172,46,87,8,0,NULL,39),(173,47,87,8,0,NULL,39),(174,70,87,8,0,NULL,39),(175,49,87,8,0,NULL,39),(176,44,87,9,0,NULL,39),(177,45,87,9,0,NULL,39),(178,48,87,9,0,NULL,39),(179,46,87,9,0,NULL,39),(180,47,87,9,0,NULL,39),(181,70,87,9,0,NULL,39),(182,49,87,9,0,NULL,39),(183,44,87,10,0,NULL,39),(184,45,87,10,0,NULL,39),(185,48,87,10,0,NULL,39),(186,46,87,10,0,NULL,39),(187,47,87,10,0,NULL,39),(188,70,87,10,0,NULL,39),(189,49,87,10,0,NULL,39),(190,44,87,11,0,NULL,39),(191,45,87,11,0,NULL,39),(192,48,87,11,0,NULL,39),(193,46,87,11,0,NULL,39),(194,47,87,11,0,NULL,39),(195,70,87,11,0,NULL,39),(196,49,87,11,0,NULL,39),(197,44,87,12,0,NULL,39),(198,45,87,12,0,NULL,39),(199,48,87,12,0,NULL,39),(200,46,87,12,0,NULL,39),(201,47,87,12,0,NULL,39),(202,70,87,12,0,NULL,39),(203,49,87,12,0,NULL,39),(204,44,87,13,0,NULL,39),(205,45,87,13,0,NULL,39),(206,48,87,13,0,NULL,39),(207,46,87,13,0,NULL,39),(208,47,87,13,0,NULL,39),(209,70,87,13,0,NULL,39),(210,49,87,13,0,NULL,39),(211,44,87,14,0,NULL,39),(212,45,87,14,0,NULL,39),(213,48,87,14,0,NULL,39),(214,46,87,14,0,NULL,39),(215,47,87,14,0,NULL,39),(216,70,87,14,0,NULL,39),(217,49,87,14,0,NULL,39),(218,44,87,15,0,NULL,39),(219,45,87,15,0,NULL,39),(220,48,87,15,0,NULL,39),(221,46,87,15,0,NULL,39),(222,47,87,15,0,NULL,39),(223,70,87,15,0,NULL,39),(224,49,87,15,0,NULL,39),(225,44,87,16,0,NULL,39),(226,45,87,16,0,NULL,39),(227,48,87,16,0,NULL,39),(228,46,87,16,0,NULL,39),(229,47,87,16,0,NULL,39),(230,70,87,16,0,NULL,39),(231,49,87,16,0,NULL,39),(232,44,87,17,0,NULL,39),(233,45,87,17,0,NULL,39),(234,48,87,17,0,NULL,39),(235,46,87,17,0,NULL,39),(236,47,87,17,0,NULL,39),(237,70,87,17,0,NULL,39),(238,49,87,17,0,NULL,39),(239,44,87,18,0,NULL,39),(240,45,87,18,0,NULL,39),(241,48,87,18,0,NULL,39),(242,46,87,18,0,NULL,39),(243,47,87,18,0,NULL,39),(244,70,87,18,0,NULL,39),(245,49,87,18,0,NULL,39),(246,44,87,19,0,NULL,39),(247,45,87,19,0,NULL,39),(248,48,87,19,0,NULL,39),(249,46,87,19,0,NULL,39),(250,47,87,19,0,NULL,39),(251,70,87,19,0,NULL,39),(252,49,87,19,0,NULL,39);
/*!40000 ALTER TABLE `class_grade_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-19 17:10:19