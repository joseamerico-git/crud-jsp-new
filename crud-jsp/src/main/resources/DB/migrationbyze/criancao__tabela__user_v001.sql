

#
#CRIAÇÃO DO SCRIPT

#GERANDO A BASE DE DADOS ........
#CREATE DATABSE jsp;

#GERANDO A TABELA DE USUÁRIO ....

CREATE TABLE USUARIO(
ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
LOGIN VARCHAR(50),
PASSWORD VARCHAR(50),
ROLE VARCHAR(20)
);

#INSERINDO O PRIMEIRO USUÁRIO....

INSERT INTO USUARIO (LOGIN, PASSWORD,ROLE) VALUES ("doiche","123","ROLE_ADMIN"); #"ROLE_USER"