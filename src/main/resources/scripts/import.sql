delete from coche where id>0; 
delete from empleado where id>0; 
delete from direccion where id>0; 
delete from empresa where id>0;
delete from incidencia where id>0;

INSERT INTO `empresa` (`id`,`nombre`,`cif`,`telefono`,`email`,`fecha_inicio`) VALUES (1,'DHL','A2096245B',943751942,'soporte@dhl.com','2010-05-17');
INSERT INTO `empresa` (`id`,`nombre`,`cif`,`telefono`,`email`,`fecha_inicio`) VALUES (2,'MRW','C2097782D',943556781,'soporte@mrw.com','2010-01-01');
INSERT INTO `empresa` (`id`,`nombre`,`cif`,`telefono`,`email`,`fecha_inicio`) VALUES (3,'Korrika','F2117222G',943256466,'soporte@korrika.com','2012-01-01');
INSERT INTO `empresa` (`id`,`nombre`,`cif`,`telefono`,`email`,`fecha_inicio`) VALUES (4,'Azkar','Z2356824K',943554426,'soporte@azkar.com','2009-11-11');
INSERT INTO `empresa` (`id`,`nombre`,`cif`,`telefono`,`email`,`fecha_inicio`) VALUES (5,'Rayo','M2351156H',943441416,'soporte@rayo.com','2009-10-01');

INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`empresa_id`,`principal`) VALUES (1,'San Francisco Javier',15,NULL,NULL,'Arga Eraikina',36301,'Irunea',1,true);
INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`empresa_id`,`principal`) VALUES (2,'Paseo Butron',42,2,'D',NULL,20401,'Hondarribia',1,false);
INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`empresa_id`,`principal`) VALUES (3,'Paseo Butron',42,2,'D',NULL,20401,'Hondarribia',2,true);
INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`empresa_id`,`principal`) VALUES (4,'Lezo',5,3,'','',20301,'Leitza',2,false);
INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`empresa_id`,`principal`) VALUES (5,'Bustitzuri',5,5,'C','',36301,'Irunea',5,true);

insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe ,empresa_id) values (1,'admin','123456','a',  1, '99966699X', 'Master', 'And', 'Commander', '2009-10-01', '943333333','maite@innova4b.com', null ,null);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe ,empresa_id) values (2,'aarandia','123456','u', 1, '99988811X', 'Aritz', 'arandia', 'lol', '2009-10-01', '943333333','aarandia@sadkf.com', null ,1);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe ,empresa_id) values (3,'jayudarte','123456','u', 1, '99988822X', 'Jose', 'ayudarte', 'lol', '2009-10-01', '943333333','jayudarte@sadkf.com', null ,1);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe ,empresa_id) values (4,'abilbao','123456','u', 1, '99988833X', 'Aitor', 'bilbao', 'lol', '2009-10-01', '943333333','abilbao@sadkf.com', null ,2);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe ,empresa_id) values (5,'mdejesus','123456','u', 1, '99988844X', 'Maider', 'dejesus', 'lol', '2009-10-01', '943333333','mdejesus@sadkf.com', null ,2);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe ,empresa_id) values (6,'eesteibar','123456','u', 1, '99988855X', 'Endika', 'esteibar', 'lol', '2009-10-01', '943333333','eesteibar@sadkf.com', null ,3);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe ,empresa_id) values (7,'dferrero','123456','u', 1, '99988866X', 'David', 'ferrero', 'lol', '2009-10-01', '943333333','dferrero@sadkf.com', null ,3);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe ,empresa_id) values (8,'mfontao','123456','u', 1, '99988877X', 'Mikel', 'fontao', 'lol', '2009-10-01', '943333333','mfontao@sadkf.com', null ,4);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe ,empresa_id) values (9,'jhidalgo','123456','u', 1, '99988888X', 'Javier', 'hidalgo', 'lol', '2009-10-01', '943333333','jhidalgo@sadkf.com', null ,4);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe, empresa_id) values (10,'mmartin','123456','u', 1, '99988899X', 'Maite', 'martin', 'lol', '2009-10-01', '943333333','mmartin@sadkf.com', null ,4);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe, empresa_id) values (11,'xmartinez','123456','u', 1, '99988800X', 'Xabier', 'martinez', 'lol', '2009-10-01', '943333333','xmartinez@sadkf.com', null ,4);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe, empresa_id) values (12,'iplaza','123456','u', 1, '99988812X', 'Ivan', 'plaza', 'lol', '2009-10-01', '943333333','iplaza@sadkf.com', null ,1);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe, empresa_id) values (13,'ssaenz','123456','u', 1, '99988845X', 'Sergio', 'saenz', 'lol', '2009-10-01', '943333333','ssaenz@sadkf.com', null ,2);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe, empresa_id) values (14,'aviteri','123456','u', 1, '99988867X', 'Ane', 'viteri', 'lol', '2009-10-01', '943333333','aviteri@sadkf.com', null ,3);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe, empresa_id) values (15,'izubia','123456','u', 1, '99988878X', 'Inigo', 'zubia', 'lol', '2009-10-01', '943333333','izubia@sadkf.com', null ,4);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe, empresa_id) values (16,'mpalacios','123456','u', 1, '99988889X', 'Maria', 'palacios', 'lol', '2009-10-01', '943333333','mpalacios@sadkf.com', null ,4);
insert into empleado(id,usuario,password,rol, activo, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, email, jefe ,empresa_id) values (17,'admin2','123456','a', 1, '99988899X', 'Maite', 'Yanguas', 'Amatriain', '2009-10-01', '943333333','maite_yan@hotmail.com', null ,null);

insert into coche(combustible, kms, marca, matricula, modelo, empresa_id) values ('gasoil', 12345, 'ford', '1234www', 'kuga', 1);
insert into coche(combustible, kms, marca, matricula, modelo, empresa_id) values ('gasoil', 12345, 'ford', '6748ABC', 'kuga',2);
insert into coche(combustible, kms, marca, matricula, modelo, empresa_id) values ('gasoil', 12345, 'ford', '4468TTY', 'kuga',2);
insert into coche(combustible, kms, marca, matricula, modelo, empresa_id) values ('gasoil', 12345, 'ford', '8468TTY', 'kuga',2);
insert into coche(combustible, kms, marca, matricula, modelo, empresa_id) values ('gasoil', 12345, 'ford', '2468TTY', 'kuga',2);
insert into coche(combustible, kms, marca, matricula, modelo, empresa_id) values ('gasoil', 12345, 'ford', '6683KJU', 'kuga',3);
insert into coche(combustible, kms, marca, matricula, modelo, empresa_id) values ('gasoil', 12345, 'ford', '7835IYT', 'kuga',4);
insert into coche(combustible, kms, marca, matricula, modelo, empresa_id) values ('gasoil', 12345, 'ford', '3468TTY', 'kuga',4);

insert into incidencia (id, descripcion, fechaCreacion, fechaResolucion, resuelta, coche_id, idUsuarioCreacion, idUsuarioResolucion, resolucion) values (1, 'Se ha pinchado la rueda', '2014-04-09', '2014-04-10', 1, 1, 1, 13, 'Se ha cambiado la rueda');
insert into incidencia (id, descripcion, fechaCreacion, fechaResolucion, resuelta, coche_id, idUsuarioCreacion, idUsuarioResolucion, resolucion) values (2, 'Fallo del embrague', '2009-06-07', null, 0, 2, 1, null, null);
insert into incidencia (id, descripcion, fechaCreacion, fechaResolucion, resuelta, coche_id, idUsuarioCreacion, idUsuarioResolucion, resolucion) values (3, 'Rotura de lunas', '2004-04-09', '2005-04-10', 1, 2, 1, 7, 'Hemos ido a Carglass');
insert into incidencia (id, descripcion, fechaCreacion, fechaResolucion, resuelta, coche_id, idUsuarioCreacion, idUsuarioResolucion, resolucion) values (4, 'Fallo de arranque', '2007-09-09', '2007-10-10', 1, 3, 1, 9, 'Cambio de bateria/bujias/aceite');

insert into reserva (id, fecha_devolucion, fecha_devolucion_prevista, fecha_inicio, fecha_inicio_prevista, kmFinales, kmIniciales, coche_id, empleado_id) values (1, NULL, '2014-05-15', '2014-05-07', '2014-05-07', 0, 1200, 1, 5);
insert into reserva (id, fecha_devolucion, fecha_devolucion_prevista, fecha_inicio, fecha_inicio_prevista, kmFinales, kmIniciales, coche_id, empleado_id) values (2, NULL, '2014-05-15', '2014-05-07', '2014-05-07', 0, 1200, 1, 5);
insert into reserva (id, fecha_devolucion, fecha_devolucion_prevista, fecha_inicio, fecha_inicio_prevista, kmFinales, kmIniciales, coche_id, empleado_id) values (3, '2014-05-07', '2014-05-15', '2014-05-07', '2014-05-07', 0, 1200, 1, 7);
insert into reserva (id, fecha_devolucion, fecha_devolucion_prevista, fecha_inicio, fecha_inicio_prevista, kmFinales, kmIniciales, coche_id, empleado_id) values (4, NULL, '2014-08-15', NULL, '2014-08-15', 0, 1200, 1, 7);
insert into reserva (id, fecha_devolucion, fecha_devolucion_prevista, fecha_inicio, fecha_inicio_prevista, kmFinales, kmIniciales, coche_id, empleado_id) values (5, NULL, '2014-08-15', NULL, '2014-06-15', 0, 1200, 1, 7);
