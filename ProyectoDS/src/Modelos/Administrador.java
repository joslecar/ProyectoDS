/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Jose Leonardo
 */
public class Administrador extends Usuario{
    private Local local;
    public Administrador(String usuario) {
        super(usuario);
    }
    public boolean CREATE(){
        return false;
    }
    public boolean READ(){
        return false;
    }
    
    public boolean UPDATE(){
        return false;
    }
    public void UpdateStock(Producto produc, int cant){
      
    }
    public void UpdatePrecio(Producto product, float prec){
        
    }
    public boolean DELETE_LOGIC(){
        return false;
    }
}
