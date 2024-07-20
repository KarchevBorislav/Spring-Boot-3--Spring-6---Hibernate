USE `employee_directory`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
                           `user_id` varchar(50) NOT NULL,
                           `pw` char(68) NOT NULL,
                           `active` tinyint NOT NULL,
                           PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `members`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://bcrypt-generator.com/
-- Default passwords here are: test123
--

INSERT INTO `members`
VALUES
    ('john','{bcrypt}$2a$13$jiUTQC8Pt363ei2QtxUAuO4Ajn/dBNOxxUMDyRE45ZS6Cjj9egLLe',1),
    ('liliya','{bcrypt}$2a$13$jiUTQC8Pt363ei2QtxUAuO4Ajn/dBNOxxUMDyRE45ZS6Cjj9egLLe',1),
    ('monika','{bcrypt}$2a$13$jiUTQC8Pt363ei2QtxUAuO4Ajn/dBNOxxUMDyRE45ZS6Cjj9egLLe',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `roles` (
                         `user_id` varchar(50) NOT NULL,
                         `role` varchar(50) NOT NULL,
                         UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
                         CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `roles`
--

INSERT INTO `roles`
VALUES
    ('john','ROLE_EMPLOYEE'),
    ('liliya','ROLE_EMPLOYEE'),
    ('liliya','ROLE_MANAGER'),
    ('monika','ROLE_EMPLOYEE'),
    ('monika','ROLE_MANAGER'),
    ('monika','ROLE_ADMIN');
