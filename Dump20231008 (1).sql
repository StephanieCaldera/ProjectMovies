CREATE DATABASE  IF NOT EXISTS `cinema` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `cinema`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cinema
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

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
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `mov_codigo` int(11) NOT NULL AUTO_INCREMENT,
  `mov_titulo` varchar(255) DEFAULT NULL,
  `mov_genero` enum('terror','suspenso','comedia','romance','ficcion','accion','aventura') DEFAULT NULL,
  `mov_url` varchar(255) DEFAULT NULL,
  `mov_imagen` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mov_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Dumbo','aventura','https://www.multiplex.com.ar/peliculas/dumbo/?comp=0&dia=0&frm=0','C:\\Datos\\Poster_DUMBO-280x400-1.jpg'),(2,'Una Flor en el Barro','romance','https://www.atlascines.com/#!/pelicula/230928232C','C:\\Datos\\una+flor+en+el+barro+web.jpg'),(4,'Oppenheimer','accion','https://www.atlascines.com/#!/pelicula/230720221S','C:\\Datos\\oppenheimer+web.jpg'),(5,'La Monja 2','terror','https://www.cinemarkhoyts.com.ar/pelicula/LA-MONJA-2','C:\\Datos\\laMonja.jpg'),(6,'Hazme el favor','comedia','https://www.cinepolis.com.ar/peliculas/hazme-el-favor','C:\\Datos\\Hazme el favoe.jpg'),(7,'Trolls 3','comedia','https://www.cinemarkhoyts.com.ar/proximamente/TROLLS-3','C:\\Datos\\Trolls3.jpg'),(8,'As Bestas','suspenso','https://www.cinemarkhoyts.com.ar/pelicula/AS-BESTAS','C:\\Datos\\AsBestas.jpg'),(9,'hhhhh','romance','gggggg','C:\\\\Datos\\\\AsBestas.jpg');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-08 20:16:45
