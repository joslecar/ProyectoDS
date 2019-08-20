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
("JFBOD-100","Jefe de Bodega"),
("REP-1000","Repartidor");

insert into Empleado values("0999657238","Leonardo","Pacheco",'2017-01-01','1998-02-20',"ADMIN-100","joslecar","joseleo123"),
('0989657121','Sebastian','Carrion','2018-01-01','2001-04-04',"JFBOD-100","leonter258","sebas123"),
('0701054777','Leonardo','Carrion','2018-01-01','1959-03-19',"GER-1000","leonardoca","leon1959"),
('0701408361','Sylvia','Pacheco','2018-01-01','1980-03-19',"VEND-1000","prueba","123"),
('0482156123','Juan','Perez','2017-05-05','1990-05-05',"REP-1000","repartidor","123");

insert into TblLocal values("LOCAL-001","Vernaza Norte","Guayaquil","0999657238"),
("LOCAL-002","Ceibos","Guayaquil","0999657238");

insert into Bodega values("BOD0001","0989657121","Vernaza Norte","Guayaquil");

insert into InventarioBodega values(1,"PRDUC-001","BOD0001",20),
(2,"PRDUC-002","BOD0001",20),
(3,"PRDUC-003","BOD0001",20),
(4,"PRDUC-004","BOD0001",20);

insert into InventarioLocal values(1,"PRDUC-001","LOCAL-001",10),
(2,"PRDUC-002","LOCAL-001",10),
(3,"PRDUC-003","LOCAL-002",10),
(4,"PRDUC-004","LOCAL-002",10);

insert into Cotizacion values("COTZ-001","0701408361","CLI-0001",600.0,"2018-04-04"),
("COTZ-002","0701408361","CLI-0002",250.0,"2018-05-04");

insert into ProductosXCotizacion values("COTZ-001","PRDUC-003",1),
("COTZ-001","PRDUC-002",1),
("COTZ-002","PRDUC-003",1);

insert into Pago values("PAG-0001",250),
("PAG-0002",600),
("PAG-0003",25);

insert into PagoPayPal values("PAG-0001","joslecar","Compra de productos",250);

insert into PagoEfectivo values("PAG-0002","2018-05-04","Compra de juegos",600);

insert into PagoTarjeta values("PAG-0003","0123123412341234","2020-05","123","Gastos varios","2018-05-04",25);

insert into Venta values("VTA-0001","0701408361","CLI-0001","PAG-0001","2018-05-04",250),
("VTA-0002","0701408361","CLI-0002","PAG-0002","2018-04-04",600),
("VTA-0003","0701408361","CLI-0003","PAG-0003","2018-05-04",25);

insert into EnvioDomicilio values("ENVI-001","VTA-0001","CLI-0001","0482156123",'entregado',"2018-05-04 13:00:00");

insert into DocumentoElectronico values("DOC-0001","VTA-0001"),
("DOC-0002","VTA-0002");

insert into Factura values("FACT-0001","DOC-0001");

insert into NotaVenta values("NTVTA-001","DOC-0001");

insert into ProductoXVenta values("VTA-0001","PRDUC-003",1),
("VTA-0002","PRDUC-003",1),
("VTA-0002","PRDUC-002",1),
("VTA-0003","PRDUC-004",1);

insert into Reabastecimiento values("REABS-001","PRDUC-001","0482156123","LOCAL-001","2019-05-05","0999657238");

insert into PagoRepartidor values("PAGRE-0001","0482156123",400.0,"2019-05-05");




