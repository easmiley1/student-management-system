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
-- Table structure for table `reference_data`
--

DROP TABLE IF EXISTS `reference_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reference_data` (
  `reference_data_id` int(11) NOT NULL AUTO_INCREMENT,
  `reference_data_name` varchar(100) NOT NULL,
  `reference_data_type` varchar(45) NOT NULL,
  `reference_additional_data` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`reference_data_id`),
  UNIQUE KEY `reference_data_id_UNIQUE` (`reference_data_id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8 COMMENT='table that contains all the reference data';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reference_data`
--

LOCK TABLES `reference_data` WRITE;
/*!40000 ALTER TABLE `reference_data` DISABLE KEYS */;
INSERT INTO `reference_data` VALUES (1,'O-','BloodGroup',NULL),(2,'O+','BloodGroup',NULL),(3,'A-','BloodGroup',NULL),(4,'A+','BloodGroup',NULL),(5,'B-','BloodGroup',NULL),(6,'B+','BloodGroup',NULL),(7,'AB-','BloodGroup',NULL),(8,'AB+','BloodGroup',NULL),(9,'Sunday','DayofWeek','0'),(10,'Monday','DayofWeek','8'),(11,'Tuesday','DayofWeek','8'),(12,'Wednesday','DayofWeek','8'),(13,'Thursday','DayofWeek','8'),(14,'Friday','DayofWeek','8'),(15,'Saturday','DayofWeek','4'),(16,'Basketball','ExtraCurricularInterest',NULL),(17,'Cricket','ExtraCurricularInterest',NULL),(18,'Football','ExtraCurricularInterest',NULL),(19,'Music','ExtraCurricularInterest',NULL),(20,'Others(comments)','ExtraCurricularInterest',NULL),(21,'Tennis','ExtraCurricularInterest',NULL),(23,'Bicycle','Transportation',NULL),(24,'Motorcycle','Transportation',NULL),(25,'Parents','Transportation',NULL),(26,'Public Transport','Transportation',NULL),(27,'School Bus','Transportation',NULL),(28,'Walking','Transportation',NULL),(30,'ASSAM','StateName','AS'),(31,'TAMILNADU','StateName','TN'),(33,'Botany','SubjectName',NULL),(34,'Chemistry','SubjectName',NULL),(35,'English','SubjectName',NULL),(36,'Maths','SubjectName',NULL),(37,'Physics','SubjectName',NULL),(38,'Science','SubjectName',NULL),(39,'Social Studies','SubjectName',NULL),(40,'Tamil','SubjectName',NULL),(41,'Zoology','SubjectName',NULL),(42,'N/A','SubjectName',NULL),(43,'First Assessment','Exam',NULL),(44,'Quaterly Exam','Exam',NULL),(45,'Second Assessments','Exam',NULL),(46,'Half Yearly Exam','Exam',NULL),(47,'Third Assessments','Exam',NULL),(48,'Annual Exam','Exam',NULL),(49,'LKG A','ClassName',NULL),(50,'LKG B','ClassName',NULL),(51,'UKG A','ClassName',NULL),(52,'UKG B','ClassName',NULL),(53,'1 A','ClassName',NULL),(54,'1 B','Class Name',NULL),(55,'1 C','ClassName',NULL),(56,'2 A','ClassName',NULL),(57,'2 B','ClassName',NULL),(58,'2 C','ClassName',NULL),(59,'3 A','ClassName',NULL),(60,'3 B','ClassName',NULL),(61,'3 C','ClassName',NULL),(62,'4 A','ClassName',NULL),(63,'4 B','ClassName',NULL),(64,'5 A','ClassName',NULL),(65,'5 B','ClassName',NULL),(66,'6 A','ClassName',NULL),(67,'6 B','ClassName',NULL),(68,'7 A','ClassName',NULL),(69,'7 B','ClassName',NULL),(70,'8 A','ClassName',NULL),(71,'8 B','ClassName',NULL),(72,'9 A','ClassName',NULL),(73,'9 B','ClassName',NULL),(74,'10 A','ClassName',NULL),(75,'10 B','ClassName',NULL),(76,'11 A','ClassName',NULL),(77,'11 B','ClassName',NULL),(78,'12 A ','ClassName',NULL),(79,'12 B','ClassName',NULL);
/*!40000 ALTER TABLE `reference_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-08-07 15:08:07
