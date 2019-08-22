/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author CltControl
 */
public class Repartidor extends Persona{
    
    private RutaDeEntrega ruta;
    private boolean disponible;
    
    public Repartidor(String nombre, String apellidos, String cedula, RutaDeEntrega ruta, boolean isDisponible) {
        super(nombre, apellidos, cedula);
        this.ruta=ruta;
        this.disponible=isDisponible;
    }

    public RutaDeEntrega getRuta() {
        return ruta;
    }

    public void setRuta(RutaDeEntrega ruta) {
        this.ruta = ruta;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setIsDisponible(boolean isDisponible) {
        this.disponible = isDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    
    
}
