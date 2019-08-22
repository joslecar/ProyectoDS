#create database DSdatabase;

use DSdatabase;
#select * from Empleado;
create table if not exists Producto(IDProducto varchar(10) PRIMARY KEY, 
					Categoria varchar(20), 
					Nombre varchar(50),
                    Descripcion varchar(300),
                    Stock int,
                    FechaIngreso DateTime,
                    Marca varchar(20),
                    PrecioCompra float,
                    PrecioVenta float);
create table if not exists Cliente(IDCliente varchar(10) PRIMARY KEY,
					Nombre varchar(100),
                    Apellido varchar(100));
                    
create table if not exists TipoEmpleado(IDTipo varchar(10) PRIMARY KEY,
						TipoEmpleado varchar(50));

create table if not exists Empleado(IDEmpleado varchar(10) PRIMARY KEY,
					Nombre varchar(100),
                    Apellido varchar(100),
					FechaIngreso date,
                    FechaNacimiento date,
                    Tipo varchar(10),
                    usuario varchar(100),
                    pass varchar(100),
                    foreign key (Tipo) references TipoEmpleado(IDTipo)
                    );
create table if not exists TblLocal(IDLocal varchar(10) PRIMARY KEY,
					Ubicacion varchar(200),
                    Ciudad varchar(100),
                    Administrador varchar(10),
                    foreign key (Administrador) references Empleado(IDEmpleado)
                    );
create table if not exists Bodega(IDBodega varchar(10) PRIMARY KEY,
				IDAdministrador varchar(10),
                Ubicacion varchar(200),
                Ciudad varchar(100),
                foreign key (IDAdministrador) references Empleado(IDEmpleado));
create table if not exists InventarioBodega(IDCountProducBod int PRIMARY KEY,
								IDProducto varchar(10),
                                IDBodega varchar(10),
                                StockXBodega int,
                                foreign key (IDProducto) references Producto(IDProducto),
                                foreign key (IDBodega) references Bodega(IDBodega));
create table if not exists InventarioLocal(IDCountProduct int PRIMARY KEY,
							IDProducto varchar(10),
                            IDLocal varchar(10),
                            StockXLocal int,
                            foreign key (IDProducto) references Producto(IDProducto),
                            foreign key (IDLocal) references TblLocal(IDLocal));
create table if not exists Cotizacion(IDCotizacion varchar(10) PRIMARY KEY,
						IDEmpleado varchar(10),
                        IDCliente varchar(10),
                        Valor float,
                        Fecha DateTime,
                        foreign key (IDEmpleado) references Empleado(IDEmpleado),
                        foreign key (IDCliente) references Cliente(IDCliente));
create table if not exists ProductosXCotizacion(IDCotizacion varchar(10),
								IDProducto varchar(10),
                                cantidadProduc int,
                                PRIMARY KEY(IDCotizacion,IDProducto),
                                foreign key (IDCotizacion) references Cotizacion(IDCotizacion),
                                foreign key (IDProducto) references Producto(IDProducto));
create table if not exists Pago(IDPago varchar(10) PRIMARY KEY,
				Total float);
create table if not exists PagoPayPal(IDPago varchar(10),
						Cuenta varchar(30) NOT NULL,
                        Detalle varchar(200),
                        Total float,
                        PRIMARY KEY(IDPago,Cuenta),
                        foreign key (IDPago) references Pago(IDPago));
                        
create table if not exists PagoEfectivo(IDPago varchar(10) PRIMARY KEY,
						Fecha datetime,
                        Detalle varchar(200),
                        Total float,
                        foreign key (IDPago) references Pago(IDPago));
create table if not exists PagoTarjeta(IDPago varchar(10),
						IDTarjeta varchar(16) NOT NULL,
                        FechaExp varchar(7) NOT NULL,
                        CVV varchar(3) NOT NULL,
                        Detalle varchar(200),
                        Fecha Datetime,
                        Total float,
                        foreign key (IDPago) references Pago(IDPago),
                        PRIMARY KEY(IDPago, IDTarjeta));
create table if not exists Venta(IDVenta varchar(10) PRIMARY KEY,
					IDEmpleado varchar(10),
                    IDCliente varchar(10),
                    IDPago varchar(10),
                    Fecha datetime,
                    Total float,
                    foreign key (IDEmpleado) references Empleado(IDEmpleado),
                    foreign key (IDCliente) references Cliente(IDCliente),
                    foreign key (IDPago) references Pago(IDPago)
                    );
create table if not exists EnvioDomicilio(IDEnvio varchar(10) PRIMARY KEY,
							IDVenta varchar(10),
                            IDCliente varchar(10),
                            IDRepartidor varchar(10),
                            Estado enum('entregado','cancelado','proceso'), #Falta revisar este enum
                            Fecha DateTime,
                            foreign key (IDVenta) references Venta(IDVenta),
                            foreign key (IDCliente) references Cliente(IDCliente),
                            foreign key (IDRepartidor) references Empleado(IDEmpleado)
                            );
create table if not exists DocumentoElectronico(IDDocumento varchar(10) PRIMARY KEY,
								IDVenta varchar(10),
                                foreign key (IDVenta) references Venta(IDVenta));
create table if not exists Factura(IDFactura varchar(10) PRIMARY KEY,
					IDDocumento varchar(10),
                    foreign key (IDDocumento) references DocumentoElectronico(IDDocumento));
create table if not exists NotaVenta(IDNotaVenta varchar(10) PRIMARY KEY,
						IDDocumento varchar(10),
                        foreign key (IDDocumento) references DocumentoElectronico(IDDocumento));
create table if not exists ProductoXVenta(IDVenta varchar(10),
							IDProducto varchar(10),
                            CantidadProduc int,
                            foreign key (IDVenta) references Venta(IDVenta),
                            foreign key (IDProducto) references Producto(IDProducto),
                            PRIMARY KEY(IDVenta,IDProducto));
create table if not exists Reabastecimiento(IDEntrega varchar(10) PRIMARY KEY,
							IDProducto varchar(10),
                            IDRepartidor varchar(10),
                            IDLocal varchar(10),
                            Fecha datetime,
                            SolicitadoPor varchar(10),
                            foreign key (IDProducto) references Producto(IDProducto),
                            foreign key (IDRepartidor) references Empleado(IDEmpleado),
                            foreign key (IDLocal) references TblLocal(IDLocal),
                            foreign key (SolicitadoPor) references Empleado(IDEmpleado));
create table if not exists PagoRepartidor(IDPagoRep varchar(10) PRIMARY KEY,
							IDRepartidor varchar(10),
                            Total float,
                            Fecha datetime,
                            foreign key (IDRepartidor) references Empleado(IDEmpleado));
             