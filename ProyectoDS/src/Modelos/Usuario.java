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
public class Usuario {
    
    protected String usuario;
    protected String contrasena;
    public Usuario(String usuario) {
        this.usuario = usuario;
    }
    public IUsuario createUsuario(){
        return null;
    }
    
    public boolean volverOnline(){
        return false;
    }
    
}
