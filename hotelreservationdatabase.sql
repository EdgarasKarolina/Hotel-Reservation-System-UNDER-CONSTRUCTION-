-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: hotelreservation
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookings` (
  `bookingid` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `ifbooked` int(11) DEFAULT '0',
  `appartmentid` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookingid`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (14,'2016-08-15',0,2),(15,'2016-08-16',0,2),(16,'2016-08-17',0,2),(17,'2016-08-18',0,2),(18,'2016-08-18',0,4),(19,'2016-08-23',0,2),(20,'2016-08-23',0,2),(21,'2016-08-24',0,2),(22,'2016-08-25',0,2),(23,'2016-08-25',0,2),(24,'2016-08-24',0,6),(25,'2016-08-25',0,2),(26,'2016-08-24',0,6),(27,'2016-08-25',0,2),(28,'2016-08-25',0,2),(29,'2016-08-24',0,6),(30,'2016-08-25',0,2),(31,'2016-08-23',0,2),(32,'2016-08-25',0,6),(33,'2016-08-26',0,6),(34,'2016-08-27',0,6),(35,'2016-09-12',0,2),(36,'2016-09-19',0,2),(37,'2016-09-20',0,7),(38,'2016-08-22',0,1),(39,'2016-08-23',0,1),(40,'2016-08-24',0,1),(41,'2016-08-29',0,1),(42,'2016-08-30',0,1),(43,'2016-08-29',0,3),(44,'2016-08-30',0,3),(45,'2016-08-29',0,1),(46,'2016-08-30',0,1),(47,'2016-08-29',0,3),(48,'2016-08-30',0,3),(49,'2016-09-05',0,7),(50,'2016-09-06',0,7),(51,'2016-09-07',0,7),(52,'2016-09-08',0,7),(53,'2016-09-09',0,7),(54,'2016-09-10',0,7),(55,'2016-09-11',0,7),(56,'2016-08-08',0,1),(57,'2016-08-26',0,2),(58,'2016-08-27',0,2),(59,'2016-08-28',0,2),(60,'2016-08-01',0,1),(61,'2016-08-02',0,1),(62,'2016-08-03',0,1),(63,'2016-08-26',0,1),(64,'2016-08-27',0,1),(65,'2016-08-23',0,3),(66,'2016-08-24',0,3),(67,'2016-07-18',0,1),(68,'2016-07-19',0,1),(69,'2016-07-20',0,1),(70,'2016-08-31',0,3),(71,'2016-09-02',0,3),(72,'2016-09-03',0,3),(73,'2016-09-03',0,1),(74,'2016-09-02',0,1),(75,'2016-09-01',0,1),(76,'2016-08-31',0,3),(77,'2016-09-01',0,3);
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookings2`
--

DROP TABLE IF EXISTS `bookings2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookings2` (
  `booking2id` int(11) NOT NULL AUTO_INCREMENT,
  `clientsname` varchar(45) DEFAULT NULL,
  `clientssurname` varchar(45) DEFAULT NULL,
  `clientsphonenumber` varchar(45) DEFAULT NULL,
  `clientsemail` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `appartment2id` int(11) DEFAULT NULL,
  PRIMARY KEY (`booking2id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings2`
--

LOCK TABLES `bookings2` WRITE;
/*!40000 ALTER TABLE `bookings2` DISABLE KEYS */;
INSERT INTO `bookings2` VALUES (1,'sdf','sd','sf','sdf','2016-08-22',3),(2,'sdfsdf','ffffffff','ssssssss','ffffffff','2016-09-04',3),(3,'sdfsdf','ffffffff','ssssssss','ffffffff','2016-09-04',1),(4,'sdfsdf','ffffffff','ssssssss','ffffffff','2016-08-31',1),(5,'sd','asd','asd','asd','2016-09-08',1),(6,'sd','asd','asd','asd','2016-09-09',1),(7,'sd','asd','asd','asd','2016-09-10',1),(8,'sd','asd','asd','asd','2016-09-10',3),(9,'sd','asd','asd','asd','2016-09-09',3),(10,'sd','asd','asd','asd','2016-09-08',3),(11,'ffffffff','fffffffffff','fffffffffff','fffffffffff','2016-09-05',1),(12,'ffffffff','fffffffffff','fffffffffff','fffffffffff','2016-09-06',1),(13,'ffffffff','fffffffffff','fffffffffff','fffffffffff','2016-09-07',1),(14,'ccccc','ccccccc','cccc','ccc','2016-09-19',1),(15,'ccccc','ccccccc','cccc','ccc','2016-09-20',1),(16,'ccccc','ccccccc','cccc','ccc','2016-09-21',1),(17,'ccccc','ccccccc','cccc','ccc','2016-09-21',3),(18,'ccccc','ccccccc','cccc','ccc','2016-09-20',3),(19,'ccccc','ccccccc','cccc','ccc','2016-09-19',3),(20,'dsf','dsf','dsf','dsf','2016-09-16',1),(21,'dsf','dsf','dsf','dsf','2016-09-17',1),(22,'dsf','dsf','dsf','dsf','2016-09-16',3),(23,'dsf','dsf','dsf','dsf','2016-09-16',3),(24,'k','y','u','b','2016-09-13',1),(25,'k','y','u','b','2016-09-14',1),(26,'k','y','u','b','2016-09-15',1),(27,'sdf','sdf','sdfsdf','sdfsdf','2016-09-14',3),(28,'sdf','sdf','sdfsdf','sdfsdf','2016-09-15',3),(29,'sdf','sdf','sdfsdf','sdfsdf','2016-09-13',3),(30,'sdf','sdf','sdf','sdf','2016-09-12',3),(31,'sdf','sdf','sdf','sdf','2016-09-12',1),(32,'dsf','sdfsdf','sdfsdf','sdf','2016-09-17',3),(33,'df','dfg','dfg','dfg','2016-09-18',1),(34,'sdf','dsf','dfg','dfg','2016-10-21',2),(35,'df','dfg','dfg','dfg','2016-09-18',3),(36,'d','g','dfg','dfg','2016-09-12',2),(37,'fd','g','dfg','dfg','2016-09-12',4),(38,'','','','','2016-09-15',2),(39,'ert','ert','ert','ret','2016-09-14',2),(40,'ert','ert','ert','ret','2016-09-14',4),(41,'','','','','2016-09-15',4),(42,'','','','','2016-09-15',6),(43,'f','','','','2016-09-16',3),(44,'','','','','2016-09-16',3);
/*!40000 ALTER TABLE `bookings2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rooms` (
  `appartmentId` int(11) NOT NULL AUTO_INCREMENT,
  `appartmentname` varchar(45) DEFAULT NULL,
  `nrofrooms` int(11) DEFAULT NULL,
  `nrofguests` int(11) DEFAULT NULL,
  `whichfloor` int(11) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `roominfo` longtext,
  PRIMARY KEY (`appartmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (1,'Luxury Nr1',1,2,45,45,'gfh'),(2,'bb',2,2,54,5,'g'),(3,'cc',1,2,5,5,'f'),(4,'dd',2,1,4,4,'g'),(5,'ee',3,2,5,5,'h'),(6,'ff',2,5,4,4,'f'),(7,'sf',5,6,4,5,'u');
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'edga','kkkk','petras','jonaitis'),(2,'gtd','uyuy','ll','jij'),(3,'dfg','dfg','sef','dfg'),(4,'1','1','sdf','fdgdfg'),(5,'','','',''),(6,'edga','kazlas','Edgaras','Kazlauskas');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-11 17:12:15
