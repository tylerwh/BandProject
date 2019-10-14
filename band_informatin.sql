-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: band_information
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `album` (
  `ALBUM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ALBUM_NAME` varchar(30) NOT NULL,
  `RELEASE_DATE` date DEFAULT NULL,
  `BAND_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ALBUM_ID`),
  KEY `BAND_ID` (`BAND_ID`),
  CONSTRAINT `album_ibfk_1` FOREIGN KEY (`BAND_ID`) REFERENCES `band` (`BAND_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (1,'Waking the Sleepy','2003-08-27',5),(3,'Whatever and Ever Amen','1997-03-18',7),(6,'Mutemath','2006-01-01',10);
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `band`
--

DROP TABLE IF EXISTS `band`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `band` (
  `BAND_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BAND_NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`BAND_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `band`
--

LOCK TABLES `band` WRITE;
/*!40000 ALTER TABLE `band` DISABLE KEYS */;
INSERT INTO `band` VALUES (1,'A7X'),(2,'A7X'),(3,'Avenged 7x'),(4,'Avenged Sevenfold'),(5,'Avenged Sevenfold'),(6,'Ben Folds Five'),(7,'Ben Folds Five'),(10,'Mutemath');
/*!40000 ALTER TABLE `band` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `band_album`
--

DROP TABLE IF EXISTS `band_album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `band_album` (
  `BAND_ID` int(11) NOT NULL,
  `ALBUM_ID` int(11) NOT NULL,
  KEY `BAND_ID` (`BAND_ID`),
  KEY `ALBUM_ID` (`ALBUM_ID`),
  CONSTRAINT `band_album_ibfk_1` FOREIGN KEY (`BAND_ID`) REFERENCES `band` (`BAND_ID`),
  CONSTRAINT `band_album_ibfk_2` FOREIGN KEY (`ALBUM_ID`) REFERENCES `album` (`ALBUM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `band_album`
--

LOCK TABLES `band_album` WRITE;
/*!40000 ALTER TABLE `band_album` DISABLE KEYS */;
/*!40000 ALTER TABLE `band_album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `band_members`
--

DROP TABLE IF EXISTS `band_members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `band_members` (
  `MEMBER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MEMBER_NAME` varchar(30) NOT NULL,
  `BAND_ID` int(11) DEFAULT NULL,
  `MEMBER_ROLE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`MEMBER_ID`),
  KEY `BAND_ID` (`BAND_ID`),
  CONSTRAINT `band_members_ibfk_1` FOREIGN KEY (`BAND_ID`) REFERENCES `band` (`BAND_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `band_members`
--

LOCK TABLES `band_members` WRITE;
/*!40000 ALTER TABLE `band_members` DISABLE KEYS */;
INSERT INTO `band_members` VALUES (3,'Matt Shadows',3,'Frontman'),(4,'Synyster Gates',4,'Guitarist'),(5,'The Rev',5,'Drummer'),(6,'Ben Folds',6,'Singer Song-Writer'),(7,'Ben Folds',7,'Frontman'),(10,'Darren King',10,'Drummer');
/*!40000 ALTER TABLE `band_members` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-14  7:35:03
