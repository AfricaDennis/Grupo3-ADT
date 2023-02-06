
DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorites` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_student` int DEFAULT NULL,
  `id_teacher` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_student_favorites` (`id_student`),
  KEY `fk_teacher_favorites` (`id_teacher`),
  CONSTRAINT `fk_student_favorites` FOREIGN KEY (`id_student`) REFERENCES `students` (`user_id`),
  CONSTRAINT `fk_teacher_favorites` FOREIGN KEY (`id_teacher`) REFERENCES `teachers` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` VALUES (2,2,3);
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;
