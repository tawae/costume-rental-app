-- MySQL dump 10.13  Distrib 8.0.40, for macos14 (arm64)
--
-- Host: localhost    Database: costume_rental
-- ------------------------------------------------------
-- Server version	9.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tblbill`
--

DROP TABLE IF EXISTS `tblbill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblbill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `returnDate` date DEFAULT NULL,
  `depositReturn` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  `clientid` int DEFAULT NULL,
  `borrowTicketid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `clientid` (`clientid`),
  KEY `borrowTicketid` (`borrowTicketid`),
  CONSTRAINT `tblbill_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `tblUser` (`id`),
  CONSTRAINT `tblbill_ibfk_2` FOREIGN KEY (`clientid`) REFERENCES `tblClient` (`id`),
  CONSTRAINT `tblbill_ibfk_3` FOREIGN KEY (`borrowTicketid`) REFERENCES `tblBorrowTicket` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblbill`
--

LOCK TABLES `tblbill` WRITE;
/*!40000 ALTER TABLE `tblbill` DISABLE KEYS */;
INSERT INTO `tblbill` VALUES (1,'2025-01-05',180,2,1,1),(2,'2025-01-10',90,2,2,2),(3,'2025-03-04',180,2,3,3),(4,'2025-01-15',180,2,4,4),(5,'2025-01-22',90,2,5,5);
/*!40000 ALTER TABLE `tblbill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblBorrowCostume`
--

DROP TABLE IF EXISTS `tblBorrowCostume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblBorrowCostume` (
  `id` int NOT NULL AUTO_INCREMENT,
  `selloff` float DEFAULT NULL,
  `borrowTicketid` int DEFAULT NULL,
  `costumeid` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `isReturned` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `borrowTicketid` (`borrowTicketid`),
  KEY `costumeid` (`costumeid`),
  CONSTRAINT `tblborrowcostume_ibfk_1` FOREIGN KEY (`borrowTicketid`) REFERENCES `tblBorrowTicket` (`id`),
  CONSTRAINT `tblborrowcostume_ibfk_2` FOREIGN KEY (`costumeid`) REFERENCES `tblCostume` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblBorrowCostume`
--

LOCK TABLES `tblBorrowCostume` WRITE;
/*!40000 ALTER TABLE `tblBorrowCostume` DISABLE KEYS */;
INSERT INTO `tblBorrowCostume` VALUES (1,NULL,1,1,2,1),(2,NULL,2,1,1,1),(3,NULL,3,1,1,1),(4,NULL,3,2,1,1),(5,NULL,4,2,2,1),(6,NULL,5,3,1,1),(7,NULL,6,3,1,0);
/*!40000 ALTER TABLE `tblBorrowCostume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblborrowticket`
--

DROP TABLE IF EXISTS `tblborrowticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblborrowticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `borrowDate` date DEFAULT NULL,
  `userid` int DEFAULT NULL,
  `clientid` int DEFAULT NULL,
  `depositAmount` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `clientid` (`clientid`),
  CONSTRAINT `tblborrowticket_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `tblUser` (`id`),
  CONSTRAINT `tblborrowticket_ibfk_2` FOREIGN KEY (`clientid`) REFERENCES `tblClient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblborrowticket`
--

LOCK TABLES `tblborrowticket` WRITE;
/*!40000 ALTER TABLE `tblborrowticket` DISABLE KEYS */;
INSERT INTO `tblborrowticket` VALUES (1,'2025-01-04',2,1,200),(2,'2025-01-09',2,2,100),(3,'2025-03-03',2,3,200),(4,'2025-01-15',2,4,200),(5,'2025-01-21',2,5,100),(6,'2025-05-19',2,5,NULL);
/*!40000 ALTER TABLE `tblborrowticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblclient`
--

DROP TABLE IF EXISTS `tblclient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblclient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblclient`
--

LOCK TABLES `tblclient` WRITE;
/*!40000 ALTER TABLE `tblclient` DISABLE KEYS */;
INSERT INTO `tblclient` VALUES (1,'Nguyen A','123456','a@gmail.com'),(2,'Vu B','122333','b@gmail.com'),(3,'Phan C','293682','c@gmail.com'),(4,'D','723462','d@gmail.com'),(5,'E','974735','e@gmail.com');
/*!40000 ALTER TABLE `tblclient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblcostume`
--

DROP TABLE IF EXISTS `tblcostume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcostume` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `size` varchar(10) DEFAULT NULL,
  `des` varchar(50) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `borrowCount` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `tblcostume_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `tblUser` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcostume`
--

LOCK TABLES `tblcostume` WRITE;
/*!40000 ALTER TABLE `tblcostume` DISABLE KEYS */;
INSERT INTO `tblcostume` VALUES (1,'Ao dai','Truyen thong','S','Mau do',100,5,4,2),(2,'Suon xam','Truyen thong','M','Mau xanh',100,5,3,2),(3,'Kimono','Truyen thong','L','Mau tim',100,5,1,2),(4,'quan bo','tre trung','XL','Mau hong',100,5,0,2);
/*!40000 ALTER TABLE `tblcostume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblDamageCostume`
--

DROP TABLE IF EXISTS `tblDamageCostume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblDamageCostume` (
  `id` int NOT NULL AUTO_INCREMENT,
  `note` varchar(50) DEFAULT NULL,
  `actualPenalty` int DEFAULT NULL,
  `returnCostumeId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `returnCostumeId` (`returnCostumeId`),
  CONSTRAINT `tbldamagecostume_ibfk_1` FOREIGN KEY (`returnCostumeId`) REFERENCES `tblReturnCostume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblDamageCostume`
--

LOCK TABLES `tblDamageCostume` WRITE;
/*!40000 ALTER TABLE `tblDamageCostume` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblDamageCostume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblDamageIssue`
--

DROP TABLE IF EXISTS `tblDamageIssue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblDamageIssue` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(50) DEFAULT NULL,
  `penaltyAmount` int DEFAULT NULL,
  `borrowCostumeid` int DEFAULT NULL,
  `returnCostumeid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `borrowCostumeid` (`borrowCostumeid`),
  KEY `returnCostumeid` (`returnCostumeid`),
  CONSTRAINT `tbldamageissue_ibfk_1` FOREIGN KEY (`borrowCostumeid`) REFERENCES `tblBorrowCostume` (`id`),
  CONSTRAINT `tbldamageissue_ibfk_2` FOREIGN KEY (`returnCostumeid`) REFERENCES `tblReturnCostume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblDamageIssue`
--

LOCK TABLES `tblDamageIssue` WRITE;
/*!40000 ALTER TABLE `tblDamageIssue` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblDamageIssue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblreturncostume`
--

DROP TABLE IF EXISTS `tblreturncostume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblreturncostume` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `billid` int DEFAULT NULL,
  `borrowCostumeid` int DEFAULT NULL,
  `rentalfee` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `billid` (`billid`),
  KEY `borrowCostumeid` (`borrowCostumeid`),
  CONSTRAINT `tblreturncostume_ibfk_1` FOREIGN KEY (`billid`) REFERENCES `tblBill` (`id`),
  CONSTRAINT `tblreturncostume_ibfk_3` FOREIGN KEY (`borrowCostumeid`) REFERENCES `tblBorrowCostume` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblreturncostume`
--

LOCK TABLES `tblreturncostume` WRITE;
/*!40000 ALTER TABLE `tblreturncostume` DISABLE KEYS */;
INSERT INTO `tblreturncostume` VALUES (1,2,1,1,20),(2,1,2,2,10),(3,1,3,3,10),(4,1,3,4,10),(5,2,4,5,20),(6,1,5,6,10);
/*!40000 ALTER TABLE `tblreturncostume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblUser`
--

DROP TABLE IF EXISTS `tblUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblUser` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblUser`
--

LOCK TABLES `tblUser` WRITE;
/*!40000 ALTER TABLE `tblUser` DISABLE KEYS */;
INSERT INTO `tblUser` VALUES (1,'manager','manager','manager','manager'),(2,'receptionist','receptionist','receptionist','receptionist');
/*!40000 ALTER TABLE `tblUser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-14 11:45:56
