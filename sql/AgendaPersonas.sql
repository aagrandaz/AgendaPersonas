DROP DATABASE `agenda`;
CREATE DATABASE `agenda`;
USE agenda;
CREATE TABLE `persona`
(
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(20),
  `cumpleaños` varchar(20),
  `nombreLocalidad` int(11) NOT NULL,
  `nombreCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idPersona`),
  FOREIGN KEY (`idLocalidad`) REFERENCES localidad (`idLocalidad`),
  FOREIGN KEY (`idCategoria`) REFERENCES categoria (`idCategoria`),
);
CREATE TABLE `localidad`
(
  `idLocalidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idLocalidad`)
);
CREATE TABLE `categoria`
(
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategoria`)
);
