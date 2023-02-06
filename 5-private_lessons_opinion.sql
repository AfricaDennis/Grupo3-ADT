DROP TABLE IF EXISTS `opinion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opinion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `assesment` varchar(50) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `id_students` int DEFAULT NULL,
  `id_teacher` int DEFAULT NULL,
  `opinion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_student_opinions` (`id_students`),
  KEY `fk_teacher_opinions` (`id_teacher`),
  CONSTRAINT `fk_student_opinions` FOREIGN KEY (`id_students`) REFERENCES `students` (`user_id`),
  CONSTRAINT `fk_teacher_opinions` FOREIGN KEY (`id_teacher`) REFERENCES `teachers` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `opinion` WRITE;
/*!40000 ALTER TABLE `opinion` DISABLE KEYS */;
INSERT INTO `opinion` VALUES (1,'5','03/02/2023',29,3,'Explica muy bien');
/*!40000 ALTER TABLE `opinion` ENABLE KEYS */;
UNLOCK TABLES;
