CREATE DATABASE exemplo_jdbc;

CREATE TABLE `exemplo_jdbc`.`chamado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `assunto` VARCHAR(45) NOT NULL,
  `mensagem` VARCHAR(255) NOT NULL,
  `status` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`));
