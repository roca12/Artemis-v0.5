create database Artemis;
use Artemis;
CREATE TABLE eventos (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    fechainicio DATETIME NOT NULL,
    fechafinal DATETIME NOT NULL,
    descripcion VARCHAR(500)
);
CREATE TABLE cuentas (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    primernombre VARCHAR(30) NOT NULL,
    segundonombre VARCHAR(30),
    primerapellido VARCHAR(30) NOT NULL,
    segundoapellido VARCHAR(30),
    username VARCHAR(50) UNIQUE KEY NOT NULL,
    pass VARCHAR(50) NOT NULL,
    rango INT NOT NULL,
    correo VARCHAR(50) NOT NULL
);


insert into cuentas values (null,'Diego','Fernando','Rodriguez','Castañeda','admin','CQD6G3Q2uPPsJ+zROkYjMg==',0,'roca12@gmail.ocm');
insert into cuentas values (null,'Edwin','','Villarraga','','admin2','q0bYFxjCQNKMPnPnTbECDw==',0,'');

SELECT 
    *
FROM
    eventos;
    
SELECT 
    *
FROM
    cuentas;
    
CREATE TABLE auditoriaacceso (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(30),
    fechaentrada DATETIME,
    hosturl VARCHAR(400)
);


CREATE TABLE visitaspormesanio (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    anio INTEGER NOT NULL UNIQUE KEY,
    enero INTEGER NOT NULL,
    febrero INTEGER NOT NULL,
    marzo INTEGER NOT NULL,
    abril INTEGER NOT NULL,
    mayo INTEGER NOT NULL,
    junio INTEGER NOT NULL,
    julio INTEGER NOT NULL,
    agosto INTEGER NOT NULL,
    septiembre INTEGER NOT NULL,
    octubre INTEGER NOT NULL,
    noviembre INTEGER NOT NULL,
    diciembre INTEGER NOT NULL
);
insert into visitaspormesanio values (null,2019,1,3,5,0,5,0,5,0,3,0,3,0);
insert into visitaspormesanio values (null,2020,0,0,0,0,0,0,0,0,0,0,0,0);


CREATE TABLE archivosayuda (
    ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FILE_NAME VARCHAR(50) NOT NULL,
    FILE_DATA longblob NOT NULL,
    FILE_EXTENSION VARCHAR(20) NOT NULL,
    DESCRIPTION VARCHAR(255)
);

drop table archivosayuda;


