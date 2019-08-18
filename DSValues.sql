use DSdatabase;
#drop database DSdatabase;
#drop table Producto;
insert into Producto values("PRDUC-001","Limpieza","PinoClean",20,"2018-01-01","Unilevel",1.50,2.00),
("PRDUC-002","Juegos","Playstation",20,"2018-01-01","Sony",300.0,350.0),
("PRDUC-003","Tecnologia","Core i7",20,"2018-02-01","Microsoft",200.0,250.0),
("PRDUC-004","Tecnologia","Mouse",20,"2018-01-01","Genius",20.0,25.0);

insert into Cliente values("CLI-0001","Jose","Carrion"),
("CLI-0002","Adriana","Murrieta"),
("CLI-0003","Bryan","Santos");

insert into TipoEmpleado values("VEND-1000","Vendedor"),
("GER-1000","Gerente"),
("ADMIN-100","Administrador"),
("JFBOD-100","Jefe de Bodega");

insert into Empleado values("0999657238","Leonardo","Pacheco",'2017-01-01','1998-02-20',"ADMIN-100","joslecar","joseleo123"),
('0989657121','Sebastian','Carrion','2018-01-01','2001-04-04',"JFBOD-100","leonter258","sebas123");

insert into TblLocal values("LOCAL-001","Vernaza Norte","Guayaquil","0999657238"),
("LOCAL-002","Ceibos","Guayaquil","0999657238");

insert into Bodega values("BOD0001","0989657121","Vernaza Norte","Guayaquil");

insert into InventarioBodega values(1,"PRDUC-001","BOD0001",10),
(2,"PRDUC-002","BOD0001",10),
(3,"PRDUC-003","BOD0001",10),
(4,"PRDUC-004","BOD0001",10);

insert into InventarioLocal values(1,"PRDUC-001","LOCAL-001",10),
(2,"PRDUC-001","LOCAL-001",10),
(3,"PRDUC-001","LOCAL-001",10),
(4,"PRDUC-001","LOCAL-001",10);



