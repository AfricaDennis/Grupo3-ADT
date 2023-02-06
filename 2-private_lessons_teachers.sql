DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers` (
  `description` varchar(500) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `photo` varchar(5000) DEFAULT NULL,
  `shift` varchar(50) DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FKb8dct7w2j1vl1r2bpstw5isc0` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES ('Soy la mejor profesora del mundo, me quiere todo el mundo','Bilbao','ninguna','mañana',3);
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;
