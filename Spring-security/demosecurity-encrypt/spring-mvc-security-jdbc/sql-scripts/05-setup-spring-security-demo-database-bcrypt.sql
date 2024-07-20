USE `employee_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://bcrypt-generator.com/
-- Default passwords here are: test123
--

INSERT INTO `users` 
VALUES 
('john','{bcrypt}$2a$13$jiUTQC8Pt363ei2QtxUAuO4Ajn/dBNOxxUMDyRE45ZS6Cjj9egLLe',1),
('liliya','{bcrypt}$2a$13$jiUTQC8Pt363ei2QtxUAuO4Ajn/dBNOxxUMDyRE45ZS6Cjj9egLLe',1),
('monika','{bcrypt}$2a$13$jiUTQC8Pt363ei2QtxUAuO4Ajn/dBNOxxUMDyRE45ZS6Cjj9egLLe',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('john','ROLE_EMPLOYEE'),
('liliya','ROLE_EMPLOYEE'),
('liliya','ROLE_MANAGER'),
('monika','ROLE_EMPLOYEE'),
('monika','ROLE_MANAGER'),
('monika','ROLE_ADMIN');