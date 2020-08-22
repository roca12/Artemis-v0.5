CREATE DATABASE  IF NOT EXISTS `artemis` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `artemis`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: artemis
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `archivosayuda`
--

DROP TABLE IF EXISTS `archivosayuda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `archivosayuda` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `FILE_NAME` varchar(50) NOT NULL,
  `FILE_DATA` blob NOT NULL,
  `FILE_EXTENSION` varchar(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archivosayuda`
--

LOCK TABLES `archivosayuda` WRITE;
/*!40000 ALTER TABLE `archivosayuda` DISABLE KEYS */;
/*!40000 ALTER TABLE `archivosayuda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditoriaacceso`
--

DROP TABLE IF EXISTS `auditoriaacceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditoriaacceso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `fechaentrada` datetime DEFAULT NULL,
  `hosturl` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoriaacceso`
--

LOCK TABLES `auditoriaacceso` WRITE;
/*!40000 ALTER TABLE `auditoriaacceso` DISABLE KEYS */;
INSERT INTO `auditoriaacceso` VALUES (1,'roca12','2020-08-19 01:02:06','http://localhost:7001/Artemis-war/login.xhtml'),(2,'roca12','2020-08-19 01:26:42','0:0:0:0:0:0:0:1'),(3,'roca12','2020-08-19 02:01:54','0:0:0:0:0:0:0:1'),(4,'roca12','2020-08-19 02:12:13','0:0:0:0:0:0:0:1'),(5,'roca12','2020-08-19 02:19:25','0:0:0:0:0:0:0:1'),(6,'roca12','2020-08-19 02:20:32','0:0:0:0:0:0:0:1'),(7,'roca12','2020-08-19 13:43:19','0:0:0:0:0:0:0:1'),(8,'roca12','2020-08-19 13:45:03','0:0:0:0:0:0:0:1'),(9,'roca12','2020-08-19 13:46:25','0:0:0:0:0:0:0:1'),(10,'roca12','2020-08-20 16:31:13','0:0:0:0:0:0:0:1'),(11,'roca12','2020-08-20 18:23:07','0:0:0:0:0:0:0:1'),(12,'roca12','2020-08-20 20:49:40','0:0:0:0:0:0:0:1'),(13,'roca12','2020-08-20 21:23:39','0:0:0:0:0:0:0:1'),(14,'roca12','2020-08-20 21:37:52','0:0:0:0:0:0:0:1'),(15,'roca12','2020-08-20 21:48:35','0:0:0:0:0:0:0:1'),(16,'roca12','2020-08-20 22:37:30','0:0:0:0:0:0:0:1'),(17,'roca12','2020-08-20 22:40:25','0:0:0:0:0:0:0:1'),(18,'roca12','2020-08-20 22:43:00','0:0:0:0:0:0:0:1');
/*!40000 ALTER TABLE `auditoriaacceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `primernombre` varchar(30) NOT NULL,
  `segundonombre` varchar(30) DEFAULT NULL,
  `primerapellido` varchar(30) NOT NULL,
  `segundoapellido` varchar(30) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `rango` int NOT NULL,
  `correo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` VALUES (1,'diego',NULL,'rodriguez',NULL,'roca12','piroloco2112',0,'roca12@gmail.ocm'),(8,'paula','','Rosero','','lamasbella','12345678',5,'a@a.com');
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(200) NOT NULL,
  `fechainicio` datetime NOT NULL,
  `fechafinal` datetime NOT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES (4,'awdwadwa','2020-08-20 22:43:00','2020-08-20 22:43:00','wdada');
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitaspormesanio`
--

DROP TABLE IF EXISTS `visitaspormesanio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitaspormesanio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `anio` int NOT NULL,
  `enero` int NOT NULL,
  `febrero` int NOT NULL,
  `marzo` int NOT NULL,
  `abril` int NOT NULL,
  `mayo` int NOT NULL,
  `junio` int NOT NULL,
  `julio` int NOT NULL,
  `agosto` int NOT NULL,
  `septiembre` int NOT NULL,
  `octubre` int NOT NULL,
  `noviembre` int NOT NULL,
  `diciembre` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `anio` (`anio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitaspormesanio`
--

LOCK TABLES `visitaspormesanio` WRITE;
/*!40000 ALTER TABLE `visitaspormesanio` DISABLE KEYS */;
INSERT INTO `visitaspormesanio` VALUES (1,2019,1,3,5,0,5,0,5,0,3,0,3,0),(2,2020,0,0,0,0,0,0,5,11,0,0,0,0);
/*!40000 ALTER TABLE `visitaspormesanio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'artemis'
--

--
-- Dumping routines for database 'artemis'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-20 18:13:30
