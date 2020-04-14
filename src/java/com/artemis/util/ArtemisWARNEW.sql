create database Artemis;
use Artemis;
create table eventos(
id integer primary key not null auto_increment,
titulo varchar(200) not null,
fechainicio datetime not null,
fechafinal datetime not null,
descripcion varchar(500)
); 
create table cuentas(
id integer primary key not null auto_increment,
primernombre varchar(30) not null,
segundonombre varchar(30),
primerapellido varchar(30) not null,
segundoapellido varchar(30),
username varchar(50) unique key not null,
pass varchar(50) not null,
rango int not null,
correo varchar(50) not null  
);


insert into eventos values (null,'prueba','2020-04-13 11:00:00','2020-04-13 12:00:00','prueba descripcion');
insert into eventos values (null,'Entrenamiento JSF','2020-04-14 18:00:00','2020-04-14 20:00:00','JSF');
insert into cuentas values (null,'diego',null,'rodriguez',null,'roca12','piroloco2112',0,'roca12@gmail.ocm');
select * from eventos;
select * from cuentas;
