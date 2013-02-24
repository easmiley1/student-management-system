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
-- Table structure for table `teacher_details`
--

DROP TABLE IF EXISTS `teacher_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_details` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `father_name` varchar(100) NOT NULL,
  `mother_name` varchar(100) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` varchar(255) NOT NULL,
  `state` int(11) NOT NULL,
  `city` varchar(45) NOT NULL,
  `zip_code` int(10) NOT NULL,
  `age` int(3) NOT NULL,
  `date_of_birth` varchar(12) NOT NULL,
  `contact_no` int(15) NOT NULL,
  `contact_email` varchar(100) DEFAULT NULL,
  `emergency_contact_no` varchar(15) NOT NULL,
  `other_contact_info` varchar(255) DEFAULT NULL,
  `blood_group` int(11) NOT NULL,
  `date_of_joining` varchar(12) NOT NULL,
  `comments` varchar(600) DEFAULT NULL,
  `previous_school` varchar(100) DEFAULT NULL,
  `previous_occupation` varchar(45) DEFAULT NULL,
  `experience` int(3) DEFAULT NULL,
  `education` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  UNIQUE KEY `teacher_id_UNIQUE` (`teacher_id`),
  KEY `teacher_state_ref_idx` (`state`),
  KEY `teacher_blood_group_ref_idx` (`blood_group`),
  CONSTRAINT `teacher_blood_group_ref` FOREIGN KEY (`blood_group`) REFERENCES `reference_data` (`reference_data_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teacher_state_ref` FOREIGN KEY (`state`) REFERENCES `reference_data` (`reference_data_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='Table to store all the personal details of teachers';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_details`
--

LOCK TABLES `teacher_details` WRITE;
/*!40000 ALTER TABLE `teacher_details` DISABLE KEYS */;
INSERT INTO `teacher_details` VALUES (1,'naren','kumar','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,34,'12/19/2012',12323,'VISHU.VAAS@GMAIL.COM','1212','',8,'12/18/2012','','','Teaching',4,'B.A'),(2,'naren','kumar','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,34,'12/11/2012',12323,'VISHU.VAAS@GMAIL.COM','1212','',3,'12/11/2012','','','teaching',3,'B.A'),(3,'Vishnu','Ramadoss','Kala','Female','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,29,'02/07/2013',140238065,'s.naren.kumar@gmail.com','140238065','',4,'02/26/2013','','','teaching',4,'B.A'),(4,'asdf','sdf','sdfsdf','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,23,'02/06/2013',234,'s.naren.kumar@gmail.com','234234','',4,'02/26/2013','','','23423',23,'sdfsdf'),(5,'stella','Joseph','Mary','Female','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,28,'02/05/2013',234234324,'s.naren.kumar@gmail.com','234234234','',4,'02/25/2013','','','Teacher',5,'B.A'),(6,'temp teacher','father','mother','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,234,'02/12/2013',234234234,'s.naren.kumar@gmail.com','432545','',4,'02/27/2013','','','teaching',5,'B.A');
/*!40000 ALTER TABLE `teacher_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-23 22:27:57
