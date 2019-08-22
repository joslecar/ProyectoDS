/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;



import java.sql.Date;

/**
 *
 * @author Jose Leonardo
 */
public class Producto {
    String IDProducto;
    String Nombre;    
    String Descripcion;
    String Categoria;
    int stock;
    Date FechaIngreso; 
    String Marca;
    double PrecioCompra;
    double PrecioVenta;

    public Producto(String IDProducto, String Nombre, String Categoria, String Descripcion,int stock, Date FechaIngreso, String Marca, double PrecioCompra, double PrecioVenta) {
        this.IDProducto = IDProducto;
        this.Nombre = Nombre;
        this.Descripcion=Descripcion;
        this.Categoria = Categoria;
        this.stock = stock;
        this.FechaIngreso = FechaIngreso;
        this.Marca = Marca;
        this.PrecioCompra = PrecioCompra;
        this.PrecioVenta = PrecioVenta;
    }
    
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    public String getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(String IDProducto) {
        this.IDProducto = IDProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public double getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(double PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    @Override
    public String toString() {
        return "Producto{" + "IDProducto=" + IDProducto + ", Nombre=" + Nombre + ", Categoria=" + Categoria + '}';
    }

    
    
   
}
