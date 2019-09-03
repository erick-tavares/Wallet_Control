Modelagem De Tabelas Banco 

*Cadastro
NOME
EMAIL
SENHA

create table cadastro (
id int not null auto_increment primary key,
email varchar(80) not null,
senha varchar(50) not null
);

*Despesas
DESCRICAO
TIPO
VALOR
DATA
REPETITIVO
STATUS

create table desespesa (
id int not null auto_increment primary key,
descricao varchar(80) not null,
categoria varchar(80) not null,
data_venc date not null,
prioridade varchar(50),
status boolean,
parcela int(100)
);


*Entradas
create table renda (
id int not null auto_increment primary key,
descricao varchar(80) not null,
valor double not null
);