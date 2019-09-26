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
  `STATUS` varchar(20) CHARACTER SET latin1 NOT NULL,
  `PARCELA` int(2) DEFAULT NULL,
  `ID_USUARIO` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `USUARIO_DESPESA_FK` (`ID_USUARIO`),
  CONSTRAINT `USUARIO_DESPESA_FK` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin

CREATE TABLE `renda` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO_RENDA` varchar(80) NOT NULL,
  `VALOR_RENDA` decimal(10,2) NOT NULL,
  `ID_USUARIO` int(11) NOT NULL,
  `DATA_RENDA` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `USUARIO_RENDA_FK` (`ID_USUARIO`),
  CONSTRAINT `USUARIO_RENDA_FK` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE

) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8

--------------------------- INSERTS -------------------------------------

insert into usuario (EMAIL, NOME, SENHA) values ("rafa@gmail.com", "Rafael", "1234");
insert into usuario (EMAIL, NOME, SENHA) values ("lucas@gmail.com", "Lucas", "abc");
insert into usuario (EMAIL, NOME, SENHA) values ("gabriel@gmail.com", "Gabriel", "senhaAPI")

insert into renda (DESCRICAO_RENDA, VALOR_RENDA, ID_USUARIO, DATA_RENDA) values ("salario", 1000, 1, "2010-12-10");
insert into renda (DESCRICAO_RENDA, VALOR_RENDA, ID_USUARIO, DATA_RENDA) values ("venda do PC", 6000, 1, "2010-12-20");
insert into renda (DESCRICAO_RENDA, VALOR_RENDA, ID_USUARIO, DATA_RENDA) values ("salario", 1000, 2, "2010-12-10");
insert into renda (DESCRICAO_RENDA, VALOR_RENDA, ID_USUARIO, DATA_RENDA) values ("aluguel", 500, 2, "2010-12-20");
insert into renda (DESCRICAO_RENDA, VALOR_RENDA, ID_USUARIO, DATA_RENDA) values ("salario", 3000, 3, "2010-12-15");
insert into renda (DESCRICAO_RENDA, VALOR_RENDA, ID_USUARIO, DATA_RENDA) values ("auber", 2000, 3, "2010-12-15");

insert into despesa (DESCRICAO_DESPESA, CATEGORIA, DATA_VENC, VALOR_DESPESA, PRIORIDADE, STATUS, PARCELA, ID_USUARIO) values ("compra notebook", "lazer", "2015-12-23", 1800, "alta", "PAGO", 1, 1);
insert into despesa (DESCRICAO_DESPESA, CATEGORIA, DATA_VENC, VALOR_DESPESA, PRIORIDADE, STATUS, PARCELA, ID_USUARIO) values ("compras", "alimentação", "2015-12-20", 250, "alta", "PAGO", 1, 1);
insert into despesa (DESCRICAO_DESPESA, CATEGORIA, DATA_VENC, VALOR_DESPESA, PRIORIDADE, STATUS, PARCELA, ID_USUARIO) values ("gasolina", "transporte", "2015-12-15", 300, "alta", "PAGO", 2, 1);
insert into despesa (DESCRICAO_DESPESA, CATEGORIA, DATA_VENC, VALOR_DESPESA, PRIORIDADE, STATUS, PARCELA, ID_USUARIO) values ("compra geladeira", "lazer", "2015-10-11", 2200, "alta", "PENDENTE", 24, 2);
insert into despesa (DESCRICAO_DESPESA, CATEGORIA, DATA_VENC, VALOR_DESPESA, PRIORIDADE, STATUS, PARCELA, ID_USUARIO) values ("parcela moto", "transporte", "2015-12-20", 400, "alta", "ATRASADO", 36, 2);
insert into despesa (DESCRICAO_DESPESA, CATEGORIA, DATA_VENC, VALOR_DESPESA, PRIORIDADE, STATUS, PARCELA, ID_USUARIO) values ("gasolina", "transporte", "2015-12-15", 100, "alta", "PAGO", 1, 2);
insert into despesa (DESCRICAO_DESPESA, CATEGORIA, DATA_VENC, VALOR_DESPESA, PRIORIDADE, STATUS, PARCELA, ID_USUARIO) values ("compras mercado", "alimentação", "2015-09-11", 45, "média", "PAGO", 1, 3);
insert into despesa (DESCRICAO_DESPESA, CATEGORIA, DATA_VENC, VALOR_DESPESA, PRIORIDADE, STATUS, PARCELA, ID_USUARIO) values ("passes ônibus", "transporte", "2015-08-20", 100, "alta", "PENDENTE", 1, 3);
insert into despesa (DESCRICAO_DESPESA, CATEGORIA, DATA_VENC, VALOR_DESPESA, PRIORIDADE, STATUS, PARCELA, ID_USUARIO) values ("lanche", "alimentação", "2015-12-15", 50, "média", "PAGO", 1, 3);
