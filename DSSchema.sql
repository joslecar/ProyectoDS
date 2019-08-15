create database DSdatabase;

use DSdatabase;

create table Producto(IDProducto varchar(10) PRIMARY KEY, 
					Categoria varchar(20), 
					Nombre varchar(50),
                    Stock int,
                    FechaIngreso DateTime,
                    Marca varchar(20),
                    PrecioCompra float,
                    PrecioVenta float);
create table Cliente(IDCliente varchar(10) PRIMARY KEY,
					Nombre varchar(100),
                    Apellido varchar(100));
                    
create table TipoProducto(IDTipo varchar(10) PRIMARY KEY,
						TipoEmpleado varchar(50));

create table Empleado(IDEmpleado varchar(10) PRIMARY KEY,
					Nombre varchar(100),
                    Apellido varchar(100),
					FechaIngreso datetime,
                    FechaNacimietno date,
                    Tipo varchar(10),
                    usuario varchar(100),
                    pass varchar(100),
                    foreign key (Tipo) references TipoProducto(IDTipo)
                    );
create table TblLocal(IDLocal varchar(10) PRIMARY KEY,
					Ubicacion varchar(200),
                    Ciudad varchar(100),
                    Administrador varchar(10),
                    foreign key (Administrador) references Empleado(IDEmpleado)
                    );
create table Bodega(IDBodega varchar(10) PRIMARY KEY,
				IDAdministrador varchar(10),
                Ubicacion varchar(200),
                Ciudad varchar(100),
                foreign key (IDAdministrador) references Empleado(IDEmpleado));
create table InventarioBodega(IDCountProducBod int PRIMARY KEY,
								IDProducto varchar(10),
                                IDBodega varchar(10),
                                StockXBodega int,
                                foreign key (IDProducto) references Producto(IDProducto),
                                foreign key (IDBodega) references Bodega(IDBodega));
create table InventarioLocal(IDCountProduct int PRIMARY KEY,
							IDProducto varchar(10),
                            IDLocal varchar(10),
                            StockXLocal int,
                            foreign key (IDProducto) references Producto(IDProducto),
                            foreign key (IDLocal) references TblLocal(IDLocal));
create table Cotizacion(IDCotizacion varchar(10) PRIMARY KEY,
						IDEmpleado varchar(10),
                        IDCliente varchar(10),
                        Valor float,
                        Fecha DateTime,
                        foreign key (IDEmpleado) references Empleado(IDEmpleado),
                        foreign key (IDCliente) references Cliente(IDCliente));
create table ProductosXCotizacion(IDCotizacion varchar(10),
								IDProducto varchar(10),
                                cantidadProduc int,
                                PRIMARY KEY(IDCotizacion,IDProducto),
                                foreign key (IDCotizacion) references Cotizacion(IDCotizacion),
                                foreign key (IDProducto) references Producto(IDProducto));
create table Pago(IDPago varchar(10) PRIMARY KEY,
				Total float);
create table PagoPayPal(IDPago varchar(10) PRIMARY KEY,
						Cuenta varchar(30) PRIMARY KEY,
                        Detalle varchar(200),
                        Total float,
                        foreign key (IDPago) references Pago(IDPago));
create table PagoEfectivo(IDPago varchar(10) PRIMARY KEY,
						Fecha datetime,
                        Detalle varchar(200),
                        Total float,
                        foreign key (IDPago) references Pago(IDPago));
create table PagoTarjeta(IDPago varchar(10) PRIMARY KEY,
						IDTarjeta varchar(10) PRIMARY KEY,
                        FechaExp varchar(7),
                        CVV varchar(3),
                        Detalle varchar(200),
                        Fecha Datetime,
                        Total float,
                        foreign key (IDPago) references Pago(IDPago));
create table Venta(IDVenta varchar(10) PRIMARY KEY,
					IDEmpleado varchar(10),
                    IDCliente varchar(10),
                    IDPago varchar(10),
                    Fecha datetime,
                    Total float,
                    foreign key (IDEmpleado) references Empleado(IDEmpleado),
                    foreign key (IDCliente) references Cliente(IDCliente),
                    foreign key (IDPago) references Pago(IDPago)
                    );
create table EnvioDomicilio(IDEnvio varchar(10) PRIMARY KEY,
							IDVenta varchar(10),
                            IDCliente varchar(10),
                            IDRepartidor varchar(10),
                            Estado enum('entregado','cancelado','proceso'), #Falta revisar este enum
                            Fecha DateTime,
                            foreign key (IDVenta) references Venta(IDVenta),
                            foreign key (IDCliente) references Cliente(IDCliente),
                            foreign key (IDRepartidor) references Empleado(IDCliente)
                            );
create table DocumentoElectronico(IDDocumento varchar(10) PRIMARY KEY,
								IDVenta varchar(10),
                                foreign key (IDVenta) references Venta(IDVenta));
create table Factura(IDFactura varchar(10) PRIMARY KEY,
					IDDocumento varchar(10),
                    foreign key (IDDocumento) references DocumentoElectronico(IDDocumento));
create table NotaVenta(IDNotaVenta varchar(10) PRIMARY KEY,
						IDDocumento varchar(10),
                        foreign key (IDDocumento) references Documento(IDDocumento));
create table ProductoXVenta(IDVenta varchar(10) PRIMARY KEY,
							IDProducto varchar(10) PRIMARY KEY,
                            CantidadProduc int,
                            foreign key (IDVenta) references Venta(IDVenta),
                            foreign key (IDProducto) references Producto(IDProducto));
create table Reabastecimiento(IDEntrega varchar(10) PRIMARY KEY,
							IDProducto varchar(10),
                            IDRepartidor varchar(10),
                            IDLocal varchar(10),
                            Fecha datetime,
                            SolicitadoPor varchar(10),
                            foreign key (IDProducto) references Producto(IDProducto),
                            foreign key (IDRepartidor) references Empleado(IDEmpleado),
                            foreign key (IDLocal) references TblLocal(IDLocal),
                            foreign key (SolicitadoPor) references Empleado(IDEmpleado));
create table PagoRepartidor(IDPagoRep varchar(10),
							IDRepartidor varchar(10),
                            Total float,
                            Fecha datetime,
                            foreign key (IDRepartidor) references IDEmpleado(IDRepartidor));
                    
