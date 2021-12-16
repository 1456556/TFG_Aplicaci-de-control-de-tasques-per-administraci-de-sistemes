-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: localhost    Database: testdb
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Current Database: `testdb`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `testdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;


--
-- Table structure for table `Elements`
--

DROP TABLE IF EXISTS `Elements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Elements` (
  `id_element` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `usuari` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tipus` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `marca` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `model` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `numero_serie` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `estat` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `observacions` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_element`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Elements`
--

LOCK TABLES `Elements` WRITE;
/*!40000 ALTER TABLE `Elements` DISABLE KEYS */;
INSERT INTO `Elements` VALUES (13,'Canon-033','Mateu','Impresora','Canon','FG6876SdFS','Correcte','Correcte','asfasfsadfsadf'),(18,'dsfdf','adfsdfasf','Ordinador','safsaf','asfas','fasfsa','Correcte','dfsafasfasfsaf');
/*!40000 ALTER TABLE `Elements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Grups`
--

DROP TABLE IF EXISTS `Grups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Grups` (
  `id_grup` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tipus` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_grup`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Grups`
--

LOCK TABLES `Grups` WRITE;
/*!40000 ALTER TABLE `Grups` DISABLE KEYS */;
INSERT INTO `Grups` VALUES (36,'grup1',1);
/*!40000 ALTER TABLE `Grups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GrupsUsuaris`
--

DROP TABLE IF EXISTS `GrupsUsuaris`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `GrupsUsuaris` (
  `id_grup` int NOT NULL,
  `id_usuari` int NOT NULL,
  `nomGrup` varchar(50) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `nomUsuari` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tipus` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GrupsUsuaris`
--

LOCK TABLES `GrupsUsuaris` WRITE;
/*!40000 ALTER TABLE `GrupsUsuaris` DISABLE KEYS */;
INSERT INTO `GrupsUsuaris` VALUES (36,265,'grup1','asfasfsaf',1),(36,266,'grup1','asfasf',1),(36,266,'grup1','fasfasfsaf',1);
/*!40000 ALTER TABLE `GrupsUsuaris` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tasques`
--

DROP TABLE IF EXISTS `Tasques`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tasques` (
  `id_tasca` int NOT NULL AUTO_INCREMENT,
  `titol` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `prioritat` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `usuari` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `data` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `estat` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `descripcio` varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `notificacio` tinyint(1) NOT NULL DEFAULT '0',
  `setNotificacio` tinyint(1) NOT NULL DEFAULT '0',
  `repeticioInici` int NOT NULL DEFAULT '0',
  `repeticioFinal` int NOT NULL DEFAULT '0',
  `dataFinal` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `recurrent` tinyint(1) NOT NULL DEFAULT '0',
  `tipus` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `dataProgres` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `diesSetmana` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `idSubtasca` int DEFAULT NULL,
  `grup` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT ' ',
  `array` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT ' ',
  PRIMARY KEY (`id_tasca`)
) ENGINE=InnoDB AUTO_INCREMENT=657 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tasques`
--

LOCK TABLES `Tasques` WRITE;
/*!40000 ALTER TABLE `Tasques` DISABLE KEYS */;
INSERT INTO `Tasques` VALUES (655,'asfasfdasf','Baixa','v','13-12-2021 17:53','Nova','asfasfsafasfsaf',0,0,0,0,'',0,'','','',NULL,'grup1',' '),(656,'safasfasfasf','Baixa','v','13-12-2021 17:55','Nova','safasfasfasfasfasfasf',0,0,0,0,'',0,'','','',NULL,'grup2',' ');
/*!40000 ALTER TABLE `Tasques` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuaris`
--

DROP TABLE IF EXISTS `Usuaris`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuaris` (
  `id_usuari` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `cognom` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `telefon` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `usuari` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `contrassenya` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `nivell` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `estat` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `nomImatge` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `imatge` blob,
  PRIMARY KEY (`id_usuari`)
) ENGINE=InnoDB AUTO_INCREMENT=269 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci COMMENT='Esta tabla es para el registro de usuarios';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuaris`
--

LOCK TABLES `Usuaris` WRITE;
/*!40000 ALTER TABLE `Usuaris` DISABLE KEYS */;
/*!40000 ALTER TABLE `Usuaris` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-15 20:31:38
