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
-- Table structure for table `student_details`
--

DROP TABLE IF EXISTS `student_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_details` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
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
  `joining_class` int(11) NOT NULL,
  `extra_curr_interest` int(11) NOT NULL,
  `mode_of_transport` int(11) NOT NULL,
  `current_class` int(11) NOT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `student_id_UNIQUE` (`student_id`),
  KEY `joining_class_ref_idx` (`joining_class`),
  KEY `current_class_ref_idx` (`current_class`),
  KEY `state_name_ref_idx` (`state`),
  KEY `blood_group_ref_idx` (`blood_group`),
  KEY `mode_of_transport_ref_idx` (`mode_of_transport`),
  KEY `extra_curricular_interest_ref_idx` (`extra_curr_interest`),
  CONSTRAINT `stu_blood_group_ref` FOREIGN KEY (`blood_group`) REFERENCES `reference_data` (`reference_data_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `stu_current_class_ref` FOREIGN KEY (`current_class`) REFERENCES `class_details` (`class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `stu_extra_curricular_interest_ref` FOREIGN KEY (`extra_curr_interest`) REFERENCES `reference_data` (`reference_data_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `stu_joining_class_ref` FOREIGN KEY (`joining_class`) REFERENCES `class_details` (`class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `stu_mode_of_transport_ref` FOREIGN KEY (`mode_of_transport`) REFERENCES `reference_data` (`reference_data_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `stu_state_ref` FOREIGN KEY (`state`) REFERENCES `reference_data` (`reference_data_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='Table to hold all the personal details about student';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_details`
--

LOCK TABLES `student_details` WRITE;
/*!40000 ALTER TABLE `student_details` DISABLE KEYS */;
INSERT INTO `student_details` VALUES (2,'firstname','father','mother','Male','address',31,'city',23434,0,'10/24/2012',12213,'email','234234','',6,'10/24/2012','comments','previousSchool',3,18,24,1),(3,'firstName','father','mother','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,0,'10/24/2012',12,'VISHU.VAAS@GMAIL.COM','2342','hfgf',1,'10/24/2012','comments','hggfg',1,1,24,1),(4,'firstname','father','mother','Male','address',31,'city',23434,0,'10/24/2012',12213,'email','234234',NULL,1,'10/24/2012','comments','previousSchool',1,1,24,1),(5,'firstName','father','mother','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',0,0,'10/24/2012',0,'VISHU.VAAS@GMAIL.COM','0','hfgf',1,'10/24/2012','comments','hggfg',1,1,24,1),(6,'naren','kumar','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,0,'10/24/2012',12323,'VISHU.VAAS@GMAIL.COM','1212','uncle-2323\r\nmother - sdfsdf',1,'12/12/2012','comments','preovi',1,1,24,1),(7,'naren','selvarajan','sarad','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,0,'10/24/2012',12323,'VISHU.VAAS@GMAIL.COM','1212','sdfdsf',1,'12/04/2012','comments','preovi',1,1,24,1),(8,'naren','kumar','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,34,'12/15/2012',12323,'VISHU.VAAS@GMAIL.COM','1212','',1,'12/05/2012','','',1,1,24,1),(9,'new student','kumar','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,23,'12/11/2012',12323,'VISHU.VAAS@GMAIL.COM','1212','',1,'12/11/2012','','',1,1,24,1),(10,'naren kumar','selvarajan','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,34,'12/10/2012',12323,'VISHU.VAAS@GMAIL.COM','1212','',3,'12/04/2012','','',1,4,24,1),(11,'naren','kumar','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,34,'12/12/2012',12323,'VISHU.VAAS@GMAIL.COM','1212','',3,'12/05/2012','','',1,4,24,3),(12,'naren','kumar','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,34,'12/12/2012',12323,'VISHU.VAAS@GMAIL.COM','1212','',3,'12/05/2012','','',1,4,24,3),(13,'naren','kumar','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,34,'12/03/2012',12323,'VISHU.VAAS@GMAIL.COM','1212','',7,'12/11/2012','','',1,2,24,1),(14,'naren','kumar','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,34,'01/15/2013',12323,'VISHU.VAAS@GMAIL.COM','1212','',8,'01/29/2013','','',1,4,24,1),(15,'naren','kumar','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,34,'',12323,'VISHU.VAAS@GMAIL.COM','1212','',8,'01/15/2013','','',1,2,24,1),(16,'naren','kumar','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,34,'',12323,'VISHU.VAAS@GMAIL.COM','1212','',8,'01/15/2013','','',1,2,24,1),(17,'naren','kumar','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,34,'',12323,'VISHU.VAAS@GMAIL.COM','1212','',3,'01/08/2013','','',1,4,24,1),(18,'naren','kumar','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,34,'',12323,'VISHU.VAAS@GMAIL.COM','1212','',3,'01/08/2013','','',1,4,24,1),(19,'naren','kumar','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,34,'',12323,'VISHU.VAAS@GMAIL.COM','1212','',3,'01/08/2013','','',1,4,24,1),(20,'naren','kumar','saradha','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,34,'',12323,'VISHU.VAAS@GMAIL.COM','1212','',3,'01/06/2013','','',1,4,24,1),(21,'new student','father','mother','Male','9757 CLOCKTOWER LN',31,'COLUMBIA',21046,23,'02/05/2013',3244325,'s.naren.kumar@gmail.com','234324','',7,'02/20/2013','','',1,17,24,3),(22,'final test','father','mother','Male','9757 CLOCKTOWER LN',30,'COLUMBIA',21046,23,'02/11/2013',32423423,'s.naren.kumar@gmail.com','234234234','',4,'02/26/2013','','',3,18,24,2);
/*!40000 ALTER TABLE `student_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-23 22:27:52
