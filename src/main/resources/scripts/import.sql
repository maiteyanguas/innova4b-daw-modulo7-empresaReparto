delete from coche where id>0; 
delete from empleado where id>0; 
delete from direccion where id>0; 
delete from empresa where id>0; 

INSERT INTO `empresa` (`id`,`nombre`,`cif`,`telefono`,`email`,`fecha_inicio`) VALUES (1,'DHL','20962451',943751942,'soporte@dhl.com','2010-05-17');
INSERT INTO `empresa` (`id`,`nombre`,`cif`,`telefono`,`email`,`fecha_inicio`) VALUES (2,'MRW','20977824',943556781,'soporte@mrw.com','2010-01-01');
INSERT INTO `empresa` (`id`,`nombre`,`cif`,`telefono`,`email`,`fecha_inicio`) VALUES (3,'Korrika','21172224',943256466,'soporte@korrika.com','2012-01-01');
INSERT INTO `empresa` (`id`,`nombre`,`cif`,`telefono`,`email`,`fecha_inicio`) VALUES (4,'Azkar','23568244',943554426,'soporte@azkar.com','2009-11-11');
INSERT INTO `empresa` (`id`,`nombre`,`cif`,`telefono`,`email`,`fecha_inicio`) VALUES (5,'Rayo','23511561',943441416,'soporte@rayo.com','2009-10-01');

INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`empresa_id`) VALUES (1,'San Francisco Javier',15,NULL,NULL,'Arga Eraikina',36301,'Iruñea',1);
INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`empresa_id`) VALUES (2,'Paseo Butrón',42,2,'D',NULL,20401,'Hondarribia',1);
INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`empresa_id`) VALUES (3,'Paseo Butrón',42,2,'D',NULL,20401,'Hondarribia',2);
INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`empresa_id`) VALUES (4,'Lezo',5,3,'','',20301,'Leitza',2);
INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`empresa_id`) VALUES (5,'Bustitzuri',5,5,'C','',36301,'Iruñea',5);

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

insert into coche(id,empresa_id) values (1,1);
insert into coche(id,empresa_id) values (2,2);
insert into coche(id,empresa_id) values (3,3);
insert into coche(id,empresa_id) values (4,4);
insert into coche(id,empresa_id) values (5,4);
