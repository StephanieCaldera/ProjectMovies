# Proyecto: creando un gestor de películas

- Se realizará una aplicación en lenguaje Java que permitirá buscar películas por su género,  mostrando al usuario el título y código de un listado de películas;
- Se permitirá al usuario ingresar el código de una película a su elección y se mostrarán todos los datos correspondientes (código, título, género, url de la página oficial y ruta de la imagen promocional);

## Tecnología utilizada
1. Lenguajes Java y SQL: el primero orientado a objetos y el segundo de base de datos relacional.
1. Patrón DAO (Data Accsess Object): permitirá que una clase o varias de ellas realicen operaciones de persistencia contra la tabla de datos inserta en MySQL Workbench, tales como: crear base de datos y tabla correspondiente, buscar registro, crearlo, actualizarlo, eliminarlo y listarlo.
1. Repositorio Maven: herramienta para gestionar proyectos;

###### #### Versión Java
- java 8

### Diagrama de frecuencia

![](https://github.com/StephanieCaldera/ProjectMovies/blob/create-java-app/BusquedaPorGenero%20diagrama%20clase.png?raw=true)

### #Diagrama de clase
![](https://github.com/StephanieCaldera/ProjectMovies/blob/create-java-app/project%20movies%20Class%20diagram.png?raw=true)

#### Sript de la Base de Datos
---sql
 CCREATE DATABASE  IF NOT EXISTS `cinema` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `cinema`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)

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
---
#### Autor
- StephanieCaldera- 

###Red Social

[Linkedin StephanieCaldera](https://www.linkedin.com/in/stephanie-alfonzina-caldera-pazmi%C3%B1o-528a99154/?otpToken=MTQwNzFkZTcxNTJiYzBjNmI0MjQwNGVjNGYxOWU1Yjc4YWNlZDU0NTlmYWI4NjYxNzdjMzA0NjY0ZjVhNWNmNGY1ZDdkZmExNTdmYWIwZmQ1NGE3Y2Q5MzlmMGZmMTFhOTQyN2UyMjU5NDNlMjM0NGQzMGMxYiwxLDE%3D&midSig=20ZwZeIjQiEqY1&eid=abdokw-lnp5vucu-ge&midToken=AQFfKV2jhC7abg&trkEmail=eml-email_network_conversations_01-header-0-profile_glimmer-null-abdokw%7Elnp5vucu%7Ege-null-null&trk=eml-email_network_conversations_01-header-0-profile_glimmer&originalSubdomain=ar)
