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
########################   NG    #########################

create table auditoriaacceso (
id integer primary key not null auto_increment,
username varchar(30),
fechaentrada datetime,
hosturl varchar(400) 
);


create table visitaspormesanio(
id integer primary key not null auto_increment,
anio integer not null unique key,
enero integer not null,
febrero integer not null,
marzo integer not null,
abril integer not null,
mayo integer not null,
junio integer not null,
julio integer not null,
agosto integer not null,
septiembre integer not null,
octubre integer not null,
noviembre integer not null,
diciembre integer not null
);
insert into visitaspormesanio values (null,2019,1,3,5,0,5,0,5,0,3,0,3,0);
insert into visitaspormesanio values (null,2020,0,0,0,0,0,0,0,0,0,0,0,0);


