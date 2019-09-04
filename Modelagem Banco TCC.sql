Modelagem De Tabelas Banco 

create database wallet_control;

create table cadastro (
id int not null auto_increment primary key,
email varchar(80) not null,
senha varchar(50) not null
);

create table desespesa (
id int not null auto_increment primary key,
descricao varchar(80) not null,
categoria varchar(80) not null,
data_venc date not null,
prioridade varchar(50),
status boolean,
parcela int(100)
);

create table renda (
id int not null auto_increment primary key,
descricao varchar(80) not null,
valor double not null
);