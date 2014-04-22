delete from coche where id>0; 
delete from empleado where id>0; 
delete from direccion where id>0; 
delete from empresa where id>0; 

INSERT INTO `empresa` (`id`,`nombre`,`cif`,`telefono`,`email`,`fecha_inicio`) VALUES (1,'DHL','A2096245B',943751942,'soporte@dhl.com','2010-05-17');
INSERT INTO `empresa` (`id`,`nombre`,`cif`,`telefono`,`email`,`fecha_inicio`) VALUES (2,'MRW','C2097782D',943556781,'soporte@mrw.com','2010-01-01');
INSERT INTO `empresa` (`id`,`nombre`,`cif`,`telefono`,`email`,`fecha_inicio`) VALUES (3,'Korrika','F2117222G',943256466,'soporte@korrika.com','2012-01-01');
INSERT INTO `empresa` (`id`,`nombre`,`cif`,`telefono`,`email`,`fecha_inicio`) VALUES (4,'Azkar','Z2356824K',943554426,'soporte@azkar.com','2009-11-11');
INSERT INTO `empresa` (`id`,`nombre`,`cif`,`telefono`,`email`,`fecha_inicio`) VALUES (5,'Rayo','M2351156H',943441416,'soporte@rayo.com','2009-10-01');

INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`empresa_id`,`principal`) VALUES (1,'San Francisco Javier',15,NULL,NULL,'Arga Eraikina',36301,'Iruñea',1,true);
INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`empresa_id`,`principal`) VALUES (2,'Paseo Butrón',42,2,'D',NULL,20401,'Hondarribia',1,false);
INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`empresa_id`,`principal`) VALUES (3,'Paseo Butrón',42,2,'D',NULL,20401,'Hondarribia',2,true);
INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`empresa_id`,`principal`) VALUES (4,'Lezo',5,3,'','',20301,'Leitza',2,false);
INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`empresa_id`,`principal`) VALUES (5,'Bustitzuri',5,5,'C','',36301,'Iruñea',5,true);

insert into empleado(id,usuario,password,rol,empresa_id) values (1,'admin','123456','a',null);
insert into empleado(id,usuario,password,rol,empresa_id) values (2,'aarandia','123456','u',1);
insert into empleado(id,usuario,password,rol,empresa_id) values (3,'jayudarte','123456','u',1);
insert into empleado(id,usuario,password,rol,empresa_id) values (4,'abilbao','123456','u',2);
insert into empleado(id,usuario,password,rol,empresa_id) values (5,'mdejesus','123456','u',2);
insert into empleado(id,usuario,password,rol,empresa_id) values (6,'eesteibar','123456','u',3);
insert into empleado(id,usuario,password,rol,empresa_id) values (7,'dferrero','123456','u',3);
insert into empleado(id,usuario,password,rol,empresa_id) values (8,'mfontao','123456','u',4);
insert into empleado(id,usuario,password,rol,empresa_id) values (9,'jhidalgo','123456','u',4);
insert into empleado(id,usuario,password,rol,empresa_id) values (10,'mmartin','123456','u',4);
insert into empleado(id,usuario,password,rol,empresa_id) values (11,'xmartinez','123456','u',4);
insert into empleado(id,usuario,password,rol,empresa_id) values (12,'iplaza','123456','u',1);
insert into empleado(id,usuario,password,rol,empresa_id) values (13,'ssaenz','123456','u',2);
insert into empleado(id,usuario,password,rol,empresa_id) values (14,'aviteri','123456','u',3);
insert into empleado(id,usuario,password,rol,empresa_id) values (15,'izubia','123456','u',4);
insert into empleado(id,usuario,password,rol,empresa_id) values (16,'mpalacios','123456','u',4);

insert into coche(id, combustible, kms, marca, matricula, modelo, empresa_id) values (1, 'gasoil', 12345, 'ford', '1234www', 'kuga', 1);
insert into coche(id, combustible, kms, marca, matricula, modelo, empresa_id) values (2, 'gasoil', 12345, 'ford', '1234www', 'kuga',2);
insert into coche(id, combustible, kms, marca, matricula, modelo, empresa_id) values (3, 'gasoil', 12345, 'ford', '1234www', 'kuga',3);
insert into coche(id, combustible, kms, marca, matricula, modelo, empresa_id) values (4, 'gasoil', 12345, 'ford', '1234www', 'kuga',4);
insert into coche(id, combustible, kms, marca, matricula, modelo, empresa_id) values (5, 'gasoil', 12345, 'ford', '1234www', 'kuga',4);
