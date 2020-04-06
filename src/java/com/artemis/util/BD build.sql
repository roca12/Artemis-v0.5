drop database artemis;
create database if not exists artemis;
use artemis;

create table if not exists  rangos(
ID int primary key auto_increment not null,
nombre_rango varchar(60) not null
);

create table if not exists universidad(
ID int primary key auto_increment not null,
nombre_universidad varchar(200) not null,
ciudad varchar(100) not null,
abreviatura varchar(10) not null
);

create table if not exists estudiante(
ID int primary key auto_increment not null,
nombres varchar(60) not null,
apellidos varchar(60) not null,
usuario varchar(30) not null,
contraseña varchar(30) not null,
codigo_est  varchar(30) not null,
documento   varchar(30) not null,
carrera     varchar(100),
semestre   int,
fecha_nacimiento date not null,
fecha_inicio_estudios date,
correo_electronico varchar(200) not null,
universidad varchar(200) not null,
rango int not null
);

create table if not exists equipo(
ID int primary key auto_increment not null,
nombre varchar(100) not null,
universidad int, #(id universidad)
ciudad varchar(60) not null,
participante1 int not null,#(id estudiate) 
participante2 int,#(id estudiate) 
participante3 int #(id estudiate) 
);



create table if not exists profesores(
ID int primary key auto_increment not null,
nombres varchar(60) not null,
apellidos varchar(60) not null,
usuario varchar(30) not null,
contraseña varchar(30) not null,
universidad int not null,
documento varchar(30) not null,
correo_electronico varchar(100) not null,
rango int not null
);

create table if not exists  clasificacion(
ID int primary key auto_increment not null,
id_team int not null, #id team
intentos int,
resueltos int,
fecha_ultima_participación date
);

create table if not exists competencias(
ID int primary key auto_increment not null, 
nombre_competencia varchar(200) not null,
cant_teams int not null,
cant_problemas int not null,
fecha_realizacion date not null,
hora_inicio time not null,
hora_fin time not null
);

create table if not exists inscripcion(
ID int primary key auto_increment not null,
idteam  int not null, #id team
fecha_inscripcion date  not null,
id_competencia int not null #id competencia
);

create table if not exists  admins(
ID int primary key auto_increment not null,
nombres varchar(60) not null,
apellidos  varchar(60) not null,
usuario varchar(60) not null,
contraseña varchar(30) not null,
documento varchar(30) not null,
correo varchar(100) not null,
rango int not null,
fecha_primer_acceso date not null,
fecha_ultimo_acceso date not null
);



create table if not exists  iniciosesiondom(
ID int primary key auto_increment not null,
idteam int not null,
username varchar(30) not null,
passwordkey varchar(30) not null
);

create table if not exists biblioteca(
ID int primary key auto_increment not null,
nombre_tema varchar(100) not null,
texto text not null,
img1 mediumblob,
img2 mediumblob,
img3 mediumblob,
link_video text,
referencias text,
link1ejercicio text,
link2ejercicio text,
link3ejercicio text
);




ALTER TABLE equipo
add CONSTRAINT FK_Participante1 FOREIGN KEY (participante1)
REFERENCES estudiante(ID),
add CONSTRAINT FK_Participante2 FOREIGN KEY (participante2)
REFERENCES estudiante(ID),
add CONSTRAINT FK_Participante3 FOREIGN KEY (participante3)
REFERENCES estudiante(ID),
add CONSTRAINT FK_Universidadequipo FOREIGN KEY (universidad)
REFERENCES universidad(ID);

alter table profesores
add CONSTRAINT FK_universidadprofesores FOREIGN KEY (universidad)
REFERENCES universidad(ID),
add CONSTRAINT FK_rangoprofesores FOREIGN KEY (rango)
REFERENCES rangos(ID);



alter table clasificacion
add CONSTRAINT FK_id_teamclasificacion FOREIGN KEY (id_team)
REFERENCES equipo(ID);

alter table inscripcion
add CONSTRAINT FK_idteaminscripcion FOREIGN KEY (idteam)
REFERENCES equipo(ID),
add CONSTRAINT FK_id_competenciainscripcion FOREIGN KEY (id_competencia)
REFERENCES competencias(ID);

alter table admins 
add CONSTRAINT FK_rangoadmins FOREIGN KEY (rango)
REFERENCES rangos(ID);

alter table iniciosesiondom
add CONSTRAINT FK_idteamDOM FOREIGN KEY (idteam)
REFERENCES equipo(ID);


insert into rangos values (null,"Administrador");
insert into rangos values (null,"Profesor");
insert into rangos values (null,"Estudiante");
insert into rangos values (null,"Observador");
insert into rangos values (null,"Editor");
insert into universidad values (null,"Universidad ECCI","Bogota","UECCI");
insert into universidad values (null,"Konrad Lorenz","Bogota","KL");
insert into universidad values (null,"Universidad Distrital Francisco Jose de Caldas","Bogota","UD");
insert into universidad values (null,"Universidad Nacional de Colombia","Bogota","UN");
insert into universidad values (null,"Universidad de los Andes","Bogota","Andes");
insert into universidad values (null,"Universidad ICESI","Calí","ISECI");
insert into estudiante values (null,"Diego Fernando","Rodriguez Castañeda","roca12","12345","38990","1013675511","Ingenieria de Sistemas",9,"1997/08/19","2015/02/02","diegoelite97@hotmail.com","Universidad ECCI",1);
insert into estudiante values (null,"Diego Fernando","Rodriguez Castañeda","roca12","12345","38990","1013675511","Ingenieria de Sistemas",9,"1997/08/19","2015/02/02","diegoelite97@hotmail.com","Universidad ECCI",1);
insert into estudiante values (null,"Diego Fernando","Rodriguez Castañeda","roca12","12345","38990","1013675511","Ingenieria de Sistemas",9,"1997/08/19","2015/02/02","diegoelite97@hotmail.com","Universidad ECCI",1);
insert into equipo values(null,"NMA",1,"Bogota",1,2,3);

create table datos as 
SELECT equipo.nombre,universidad.nombre_universidad where equipo.universidad=equipo.universidad,estudiante.ID,estudiante.nombres,estudiante.apellidos
FROM equipo
INNER JOIN estudiante;