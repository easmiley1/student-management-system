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
-- Table structure for table `class_student_details`
--

DROP TABLE IF EXISTS `class_student_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_student_details` (
  `class_student_details_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `roll_no` int(11) DEFAULT NULL,
  `comments` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`class_student_details_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_student_details`
--

LOCK TABLES `class_student_details` WRITE;
/*!40000 ALTER TABLE `class_student_details` DISABLE KEYS */;
INSERT INTO `class_student_details` VALUES (1,1,16,NULL,'comments'),(2,1,17,NULL,'comments'),(3,1,18,NULL,'comments'),(4,2,15,NULL,'comments'),(5,2,19,NULL,'comments'),(6,2,20,NULL,'comments'),(7,2,21,NULL,'comments'),(8,2,22,NULL,'comments'),(9,29,23,NULL,'comments'),(10,39,2,NULL,'Quaterly Exam : good results , except social studies. \r\nSecond Assesment:'),(11,39,3,NULL,'comments'),(12,39,4,NULL,'comments'),(13,39,5,NULL,'comments'),(14,39,6,NULL,'comments'),(15,39,7,NULL,'comments'),(16,39,8,NULL,'comments'),(17,39,9,NULL,'comments'),(18,39,10,NULL,'comments'),(19,39,11,NULL,'comments'),(20,39,12,NULL,'comments'),(21,39,13,NULL,'comments'),(22,39,14,NULL,'comments');
/*!40000 ALTER TABLE `class_student_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-12 17:14:12
