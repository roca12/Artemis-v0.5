create database Artemis;
use Artemis;
create table eventos(
id int primary key not null auto_increment,
titulo varchar(200) not null,
fechainicio datetime not null,
fechafinal datetime not null,
descripcion varchar(500)
); 

insert into eventos values (null,'prueba','2020-04-13 11:00:00','2020-04-13 12:00:00','prueba descripcion');
insert into eventos values (null,'Entrenamiento JSF','2020-04-14 18:00:00','2020-04-14 20:00:00','JSF');
select * from eventos;
