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
public class MetodoDePago {
    private IMetodoPago metodoPago;
    
    
    
    
    public void setMetodoPago(IMetodoPago mp){
        this.metodoPago=mp;
    }
    
    public boolean realizarPago(){
        return false;
    }
}
