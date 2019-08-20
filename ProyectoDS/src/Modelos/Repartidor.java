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
    private boolean isDisponible;
    
    public Repartidor(String nombre, String apellidos, String cedula) {
        super(nombre, apellidos, cedula);
    }

    
    
}
