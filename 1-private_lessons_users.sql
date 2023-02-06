DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `admin` tinyint(1) DEFAULT '0',
  `email` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(5000) DEFAULT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `users` WRITE;

INSERT INTO `users` VALUES (2,0,'rodrigo@gmail.com','Rodrigo','hola','688757110','Armoa Fernandez'),(3,0,'dela@gmail.com','Dela','hola','652300736','Dennis Munoz'),(4,1,'admin@gmail.com','Administrador','$2a$10$yGGBRLWeBqnGMlXfyrzjNek9XhthsL14CSaKJXuFSixYnrk0AAi9C','666666666','Todo Poderoso'),(24,0,'rodrigo4@gmail.com','Rodrigo4','hola4','688757110','Armoa4 Fernandez4'),(27,0,'rodrigo433@gmail.com','Rodrigo43','12345678','688757110','Armoa43 Fernandez43'),(28,0,'marta@gmail.com','Marta','12345678','688757110','Lopez Autenetxea'),(29,0,'jueln@gmail.com','Julebn','12345678','688757110','julenn Autenetxea');
