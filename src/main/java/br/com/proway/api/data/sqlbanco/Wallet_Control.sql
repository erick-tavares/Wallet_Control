CREATE DATABASE exemplo_jdbc;

CREATE TABLE `usuario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(80) CHARACTER SET latin1 NOT NULL,
  `NOME`  varchar(80) NOT NULL,
  `SENHA` varchar(50) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin

CREATE TABLE `despesa` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO_DESPESA` varchar(80) CHARACTER SET latin1 NOT NULL,
  `CATEGORIA` varchar(80) CHARACTER SET latin1 NOT NULL,
  `DATA_VENC` date NOT NULL,
  `VALOR_DESPESA` decimal(10,2) NOT NULL,
  `PRIORIDADE` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `STATUS` tinyint(4) NOT NULL,
  `PARCELA` int(2) DEFAULT NULL,
  `ID_USUARIO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `USUARIO_DESPESA_FK` (`ID_USUARIO`),
  CONSTRAINT `USUARIO_DESPESA_FK` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin

CREATE TABLE `renda` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO_RENDA` varchar(80) NOT NULL,
  `VALOR_RENDA` decimal(10,2) NOT NULL,
  `ID_USUARIO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `USUARIO_RENDA_FK` (`ID_USUARIO`),
  CONSTRAINT `USUARIO_RENDA_FK` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8