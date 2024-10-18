CREATE DATABASE IF NOT EXISTS shoesmall;
USE shoesmall;

-- newschema_cart.sql
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: newschema
-- ------------------------------------------------------
-- Server version	8.4.2

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_cart` (`user_id`),
  KEY `fk_product_cart` (`product_id`),
  CONSTRAINT `fk_product_cart` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `fk_user_cart` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,1,2,3),(2,2,3,2),(3,3,4,1),(4,4,1,5),(5,5,6,4),(6,6,5,2),(7,7,7,3);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-16 17:20:03


-- newschema_category.sql
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: newschema
-- ------------------------------------------------------
-- Server version	8.4.2

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(225) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Nike'),(2,'Adidas'),(3,'Vans'),(4,'ETC');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-16 17:20:03


-- newschema_delivarystatus.sql
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: newschema
-- ------------------------------------------------------
-- Server version	8.4.2

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
-- Table structure for table `delivarystatus`
--

DROP TABLE IF EXISTS `delivarystatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivarystatus` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL DEFAULT 'Preparing' COMMENT '1: Preparing(배송준비),2:Sending(배송중),3:Delivered(배송완료),4:Cancelled(배송취소)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivarystatus`
--

LOCK TABLES `delivarystatus` WRITE;
/*!40000 ALTER TABLE `delivarystatus` DISABLE KEYS */;
INSERT INTO `delivarystatus` VALUES (1,'Preparing'),(2,'Sending'),(3,'Delivered'),(4,'Cancelled');
/*!40000 ALTER TABLE `delivarystatus` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-16 17:20:03


-- newschema_orders.sql
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: newschema
-- ------------------------------------------------------
-- Server version	8.4.2

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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `order_number` char(50) NOT NULL,
  `totalprice` int NOT NULL,
  `addr` text NOT NULL,
  `ordertime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_user_order` (`user_id`),
  CONSTRAINT `fk_user_order` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,'ORD001',150000,'Seoul, Apt 101','2024-10-10 08:43:46'),(2,2,'ORD002',60000,'Busan, Villa 202','2024-10-10 08:43:46'),(3,3,'ORD003',80000,'Incheon, House 303','2024-10-10 08:43:46'),(4,4,'ORD004',50000,'Daegu, Apartment 404','2024-10-10 08:43:46'),(5,5,'ORD005',70000,'Gwangju, Suite 505','2024-10-10 08:43:46'),(6,6,'ORD006',90000,'Daejeon, House 606','2024-10-10 08:43:46'),(7,7,'ORD007',30000,'Ulsan, Room 707','2024-10-10 08:43:46');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-16 17:20:03


-- newschema_orderview.sql
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: newschema
-- ------------------------------------------------------
-- Server version	8.4.2

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
-- Table structure for table `orderview`
--

DROP TABLE IF EXISTS `orderview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderview` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `delivarystatus_id` int NOT NULL DEFAULT '1',
  `delivary_at` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_orderview` (`order_id`),
  KEY `fk_deliveraystatus_id_idx` (`delivarystatus_id`),
  CONSTRAINT `fk_deliveraystatus_orderview` FOREIGN KEY (`delivarystatus_id`) REFERENCES `delivarystatus` (`id`),
  CONSTRAINT `fk_order_orderview` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderview`
--

LOCK TABLES `orderview` WRITE;
/*!40000 ALTER TABLE `orderview` DISABLE KEYS */;
INSERT INTO `orderview` VALUES (1,1,1,'2024-10-10 08:54:23'),(2,2,2,'2024-10-10 08:54:23'),(3,3,3,'2024-10-10 08:54:23'),(4,4,4,'2024-10-10 08:54:23'),(5,5,2,'2024-10-10 08:54:23'),(6,6,3,'2024-10-10 08:54:23'),(7,7,4,'2024-10-10 08:54:23');
/*!40000 ALTER TABLE `orderview` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-16 17:20:03


-- newschema_products.sql
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: newschema
-- ------------------------------------------------------
-- Server version	8.4.2

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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` int NOT NULL,
  `description` text,
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `category_id` int NOT NULL,
  `subcategory_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_id_idx` (`category_id`),
  KEY `fk_subcategory_id_idx` (`subcategory_id`),
  CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_subcategory_id` FOREIGN KEY (`subcategory_id`) REFERENCES `subcategory` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'adistar01',159000,'Adidas Adistar White-Yellow','2024-10-11 08:27:05',2,1),(2,'amplimove01',79000,'Adidas Amplimove White','2024-10-11 08:27:05',2,2),(3,'dropset01',400000,'Adidas Dropset Pink-Black','2024-10-11 08:27:05',2,3),(4,'everyset01',119000,'Adidas Everyset Ivory-Pink','2024-10-11 08:27:05',2,4),(5,'newyork01',129000,'Adidas NewYork Gray-Black','2024-10-11 08:27:05',2,1),(6,'runner01',109000,'Adidas Runner Black-White','2024-10-11 08:27:05',2,2),(7,'running01',69000,'Adidas Running Blue','2024-10-11 08:27:05',2,3),(8,'samba01',139000,'Adidas Samba Black','2024-10-11 08:27:05',2,4),(9,'classic01',69000,'Nike Classic Black','2024-10-11 08:27:08',1,1),(10,'cortez01',129000,'Nike Cortez Brown','2024-10-11 08:27:08',1,2),(11,'dunk01',139000,'Nike Dunk White-Black','2024-10-11 08:27:08',1,3),(12,'picnic01',129000,'Nike Picnic White','2024-10-11 08:27:08',1,4),(13,'uptempo01',209000,'Nike Uptempo Black','2024-10-11 08:27:08',1,1),(14,'v2k01',139000,'Nike V2K Black','2024-10-11 08:27:08',1,2),(15,'vision01',89000,'Nike Vision White','2024-10-11 08:27:08',1,3),(16,'authentic01',105000,'Vans Authentic Gray','2024-10-11 08:27:11',3,4),(17,'checker01',69000,'Vans Checker Orange','2024-10-11 08:27:11',3,1),(18,'skool01',85000,'Vans Skool Gray','2024-10-11 08:27:11',3,2),(19,'upland01',119000,'Vans Upland White','2024-10-11 08:27:11',3,3),(20,'adistar02',159000,'Adidas Adistar White','2024-10-15 07:22:57',2,4),(21,'running02',69000,'Adidas Running White-Black','2024-10-15 07:22:57',2,1),(22,'runner02',109000,'Adidas Runner Black','2024-10-15 07:22:57',2,2),(23,'classic02',69000,'Nike Classic White','2024-10-11 08:27:08',1,3),(24,'classic03',69000,'Nike Classic Black-Brown','2024-10-11 08:27:08',1,4),(25,'cortez02',129000,'Nike Cortez Green','2024-10-11 08:27:08',1,1),(26,'dunk02',139000,'Nike Dunk White','2024-10-11 08:27:08',1,2),(27,'dunk03',139000,'Nike Dunk Ivory-White','2024-10-11 08:27:08',1,3),(29,'uptempo02',209000,'Nike Uptempo White','2024-10-11 08:27:08',1,4),(30,'v2k02',139000,'Nike V2K Obsidian','2024-10-11 08:27:08',1,1),(31,'v2k03',139000,'Nike V2K Silver','2024-10-11 08:27:08',1,2),(32,'v2k04',139000,'Nike V2K Vintagegreen','2024-10-11 08:27:08',1,3),(33,'v2k05',139000,'Nike V2K Wolfgray','2024-10-11 08:27:08',1,4),(34,'adistar02',159000,'Adidas Adistar White','2024-10-15 07:22:57',2,1),(35,'runner02',109000,'Adidas Runner Black','2024-10-15 07:22:57',2,2),(36,'authentic02',105000,'Vans Authentic White','2024-10-15 07:22:57',3,3),(37,'authentic03',105000,'Vans Authentic Black','2024-10-15 07:22:57',3,4),(38,'skool02',85000,'Vans Skool Purple','2024-10-15 07:22:57',3,1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-16 17:20:03


-- newschema_productsize.sql
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: newschema
-- ------------------------------------------------------
-- Server version	8.4.2

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
-- Table structure for table `productsize`
--

DROP TABLE IF EXISTS `productsize`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productsize` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `size` varchar(10) NOT NULL,
  `stock` int NOT NULL DEFAULT '100',
  PRIMARY KEY (`id`),
  KEY `fk_product_id_idx` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=229 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productsize`
--

LOCK TABLES `productsize` WRITE;
/*!40000 ALTER TABLE `productsize` DISABLE KEYS */;
INSERT INTO `productsize` VALUES (1,1,'255',100),(2,1,'260',100),(3,1,'265',100),(4,1,'270',100),(5,1,'275',100),(6,1,'280',100),(7,2,'255',100),(8,2,'260',100),(9,2,'265',100),(10,2,'270',100),(11,2,'275',100),(12,2,'280',100),(13,3,'255',100),(14,3,'260',100),(15,3,'265',100),(16,3,'270',100),(17,3,'275',100),(18,3,'280',100),(19,4,'255',100),(20,4,'260',100),(21,4,'265',100),(22,4,'270',100),(23,4,'275',100),(24,4,'280',100),(25,5,'255',100),(26,5,'260',100),(27,5,'265',100),(28,5,'270',100),(29,5,'275',100),(30,5,'280',100),(31,6,'255',100),(32,6,'260',100),(33,6,'265',100),(34,6,'270',100),(35,6,'275',100),(36,6,'280',100),(37,7,'255',100),(38,7,'260',100),(39,7,'265',100),(40,7,'270',100),(41,7,'275',100),(42,7,'280',100),(43,8,'255',100),(44,8,'260',100),(45,8,'265',100),(46,8,'270',100),(47,8,'275',100),(48,8,'280',100),(49,9,'255',100),(50,9,'260',100),(51,9,'265',100),(52,9,'270',100),(53,9,'275',100),(54,9,'280',100),(55,10,'255',100),(56,10,'260',100),(57,10,'265',100),(58,10,'270',100),(59,10,'275',100),(60,10,'280',100),(61,11,'255',100),(62,11,'260',100),(63,11,'265',100),(64,11,'270',100),(65,11,'275',100),(66,11,'280',100),(67,12,'255',100),(68,12,'260',100),(69,12,'265',100),(70,12,'270',100),(71,12,'275',100),(72,12,'280',100),(73,13,'255',100),(74,13,'260',100),(75,13,'265',100),(76,13,'270',100),(77,13,'275',100),(78,13,'280',100),(79,14,'255',100),(80,14,'260',100),(81,14,'265',100),(82,14,'270',100),(83,14,'275',100),(84,14,'280',100),(85,15,'255',100),(86,15,'260',100),(87,15,'265',100),(88,15,'270',100),(89,15,'275',100),(90,15,'280',100),(91,16,'255',100),(92,16,'260',100),(93,16,'265',100),(94,16,'270',100),(95,16,'275',100),(96,16,'280',100),(97,17,'255',100),(98,17,'260',100),(99,17,'265',100),(100,17,'270',100),(101,17,'275',100),(102,17,'280',100),(103,18,'255',100),(104,18,'260',100),(105,18,'265',100),(106,18,'270',100),(107,18,'275',100),(108,18,'280',100),(109,19,'255',100),(110,19,'260',100),(111,19,'265',100),(112,19,'270',100),(113,19,'275',100),(114,19,'280',100),(115,20,'255',100),(116,20,'260',100),(117,20,'265',100),(118,20,'270',100),(119,20,'275',100),(120,20,'280',100),(121,21,'255',100),(122,21,'260',100),(123,21,'265',100),(124,21,'270',100),(125,21,'275',100),(126,21,'280',100),(127,22,'255',100),(128,22,'260',100),(129,22,'265',100),(130,22,'270',100),(131,22,'275',100),(132,22,'280',100),(133,23,'255',100),(134,23,'260',100),(135,23,'265',100),(136,23,'270',100),(137,23,'275',100),(138,23,'280',100),(139,24,'255',100),(140,24,'260',100),(141,24,'265',100),(142,24,'270',100),(143,24,'275',100),(144,24,'280',100),(145,25,'255',100),(146,25,'260',100),(147,25,'265',100),(148,25,'270',100),(149,25,'275',100),(150,25,'280',100),(151,26,'255',100),(152,26,'260',100),(153,26,'265',100),(154,26,'270',100),(155,26,'275',100),(156,26,'280',100),(157,27,'255',100),(158,27,'260',100),(159,27,'265',100),(160,27,'270',100),(161,27,'275',100),(162,27,'280',100),(163,28,'255',100),(164,28,'260',100),(165,28,'265',100),(166,28,'270',100),(167,28,'275',100),(168,28,'280',100),(169,29,'255',100),(170,29,'260',100),(171,29,'265',100),(172,29,'270',100),(173,29,'275',100),(174,29,'280',100),(175,30,'255',100),(176,30,'260',100),(177,30,'265',100),(178,30,'270',100),(179,30,'275',100),(180,30,'280',100),(181,31,'255',100),(182,31,'260',100),(183,31,'265',100),(184,31,'270',100),(185,31,'275',100),(186,31,'280',100),(187,32,'255',100),(188,32,'260',100),(189,32,'265',100),(190,32,'270',100),(191,32,'275',100),(192,32,'280',100),(193,33,'255',100),(194,33,'260',100),(195,33,'265',100),(196,33,'270',100),(197,33,'275',100),(198,33,'280',100),(199,34,'255',100),(200,34,'260',100),(201,34,'265',100),(202,34,'270',100),(203,34,'275',100),(204,34,'280',100),(205,35,'255',100),(206,35,'260',100),(207,35,'265',100),(208,35,'270',100),(209,35,'275',100),(210,35,'280',100),(211,36,'255',100),(212,36,'260',100),(213,36,'265',100),(214,36,'270',100),(215,36,'275',100),(216,36,'280',100),(217,37,'255',100),(218,37,'260',100),(219,37,'265',100),(220,37,'270',100),(221,37,'275',100),(222,37,'280',100),(223,38,'255',100),(224,38,'260',100),(225,38,'265',100),(226,38,'270',100),(227,38,'275',100),(228,38,'280',100);
/*!40000 ALTER TABLE `productsize` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-16 17:20:03


-- newschema_review.sql
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: newschema
-- ------------------------------------------------------
-- Server version	8.4.2

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
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `product_id` int NOT NULL,
  `comment` text NOT NULL,
  `title` varchar(50) NOT NULL,
  `star_rate` int NOT NULL,
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_user_review` (`user_id`),
  KEY `fk_product_review` (`product_id`),
  CONSTRAINT `fk_product_review` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `fk_user_review` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,1,1,'Great quality!','Very satisfied',5,'2024-10-10 08:53:21'),(2,2,2,'Comfortable and stylish','Good purchase',4,'2024-10-10 08:53:21'),(3,3,3,'Not what I expected','Disappointed',2,'2024-10-10 08:53:21'),(4,4,4,'Excellent shoes','Highly recommend',5,'2024-10-10 08:53:21'),(5,5,5,'Pretty good','Worth the price',4,'2024-10-10 08:53:21'),(6,6,6,'Not bad','Could be better',3,'2024-10-10 08:53:21'),(7,7,7,'Great for the price','Satisfied',4,'2024-10-10 08:53:21');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-16 17:20:03


-- newschema_subcategory.sql
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: newschema
-- ------------------------------------------------------
-- Server version	8.4.2

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
-- Table structure for table `subcategory`
--

DROP TABLE IF EXISTS `subcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subcategory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcategory`
--

LOCK TABLES `subcategory` WRITE;
/*!40000 ALTER TABLE `subcategory` DISABLE KEYS */;
INSERT INTO `subcategory` VALUES (1,'lifestyle'),(2,'running'),(3,'acivity'),(4,'etc');
/*!40000 ALTER TABLE `subcategory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-16 17:20:03


-- newschema_user.sql
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: newschema
-- ------------------------------------------------------
-- Server version	8.4.2

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `uid` varchar(50) NOT NULL,
  `pw` varchar(225) NOT NULL,
  `tel` char(15) NOT NULL,
  `addrf` int NOT NULL,
  `addrs` varchar(225) NOT NULL,
  `addrt` varchar(225) NOT NULL,
  `addrl` varchar(225) DEFAULT NULL,
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `level` int NOT NULL,
  `grade` int NOT NULL,
  `email` varchar(100) DEFAULT NULL COMMENT '이메일',
  `gender` varchar(15) DEFAULT NULL COMMENT '성별',
  `birthday` int DEFAULT NULL COMMENT '생년월일\nYYYYMMDD',
  `ezcoin` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Admin','Admin','password123','01012345678',1,'Seoul','Apt 101',NULL,'2024-10-10 08:43:00',99,99,'admin@admin.com','allsex',99991231,100000),(2,'Bob','bob02','password456','01087654321',2,'Busan','Villa 202',NULL,'2024-10-10 08:43:00',1,2,'bob@bob.com','male',19800101,100000),(3,'Charlie','charlie03','password789','01011223344',1,'Incheon','House 303',NULL,'2024-10-10 08:43:00',1,4,'charlie@charlie.com','male',19800101,100000),(4,'David','david04','password321','01099887766',2,'Daegu','Apartment 404',NULL,'2024-10-10 08:43:00',1,1,'david@david.com','male',19800101,100000),(5,'Eve','eve05','password654','01055667788',3,'Gwangju','Suite 505',NULL,'2024-10-10 08:43:00',1,2,'eve@eve.com','female',19800101,100000),(6,'Frank','frank06','password987','01044332211',1,'Daejeon','House 606',NULL,'2024-10-10 08:43:00',1,3,'frank@frank.com','male',19800101,100000),(7,'Grace','grace07','password111','01066778899',2,'Ulsan','Room 707',NULL,'2024-10-10 08:43:00',1,4,'grace@grace.com','male',19800101,100000);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-16 17:20:03


