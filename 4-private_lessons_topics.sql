DROP TABLE IF EXISTS `topics`;
CREATE TABLE `topics` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_teacher` int DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_id_teacher` (`id_teacher`),
  CONSTRAINT `Fk_id_teacher` FOREIGN KEY (`id_teacher`) REFERENCES `teachers` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `topics` WRITE;
/*!40000 ALTER TABLE `topics` DISABLE KEYS */;
INSERT INTO `topics` VALUES (1,3,'ADT');
/*!40000 ALTER TABLE `topics` ENABLE KEYS */;
UNLOCK TABLES;
