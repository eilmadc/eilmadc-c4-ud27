use data;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS suministra;
DROP TABLE IF EXISTS piezas;
DROP TABLE IF EXISTS proveedores;

/* Tabla de usuarios */
CREATE TABLE users(
	id int NOT NULL AUTO_INCREMENT,
	username char(15) DEFAULT NULL,
	email char(15) DEFAULT NULL,
	password char(254) DEFAULT NULL,
	rol char(15) DEFAULT NULL,
	PRIMARY KEY(id)
);

INSERT INTO users (username, email, password,rol) VALUES('elena', elena@elena.es, '$2a$10$YaDn67aiuREW5yz39IWC1eNpdg2aPLPUJ8jjxvCcca4vUOhZlEbLK','admin');

/* Tabla de roles */
CREATE TABLE roles (
	id int NOT NULL AUTO_INCREMENT,
	rol char(15) DEFAULT NULL,
    PRIMARY KEY(id)
);

INSERT INTO roles (rol) VALUES('admin'),('manager'),('techical'),('user');

/* Tabla de usuario_rol 
CREATE TABLE user_roles (
 	id int NOT NULL AUTO_INCREMENT,
	user_id int,
	role_id int,
	PRIMARY KEY(id),
	FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE ON UPDATE CASCADE
);*/

INSERT INTO user_roles (user_id,role_id) VALUES (1,2),(1,4),(1,3);


CREATE TABLE piezas (
	codigo int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre char(100) DEFAULT NULL
);

CREATE TABLE proveedores (
	id char(4) PRIMARY KEY,
    nombre char(100) DEFAULT NULL
);


CREATE TABLE suministra (
 	id int NOT NULL AUTO_INCREMENT,
	codigo_pieza int ,
	id_proveedor char(4),
	precio int,
	PRIMARY KEY(id),
	FOREIGN KEY (codigo_pieza) REFERENCES piezas (codigo) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (id_proveedor) REFERENCES proveedores (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO piezas (nombre) VALUES 
	('Amortiguador'), 
	('Caja cambios'), 
	('Disco freno'), 
	('Bujia'), 
	('Luz delantera'), 
	('Luz trasera'), 
	('Intermitente'), 
	('Pneumatico'), 
	('Retrovisor'), 
	('Escape');

INSERT INTO proveedores VALUES 
	('yama','Yamaha'), 
	('hond','Honda'), 
	('duca','Ducati'), 
	('apri','Aprilia'), 
	('kawa','Kawasaki'),
	('bmw','BMW'),
	('audi','Audi'),
	('opel','Opel'),
	('ford','Ford'),
	('chev','Chevrolet');

INSERT INTO suministra (codigo_pieza, id_proveedor,precio) VALUES 
	(1, 'yama', 1250),
	(2, 'duca', 750),
    	(3, 'hond', 150),
    	(4, 'kawa', 35),
    	(5, 'apri', 980),
    	(7, 'opel', 1980),
	(8, 'ford', 950),
	(9, 'ford', 70),
	(9, 'bmw', 85),
	(6, 'hond', 430);