/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Administrador;
import Modelos.Gerente;
import Modelos.JefeBodega;
import Modelos.Usuario;
import Modelos.Vendedor;
import Vistas.IManejadorMenu;
import Vistas.ViewAdministrador;
import Vistas.ViewGerente;
import Vistas.ViewJefeBodega;
import Vistas.ViewLogin;
import Vistas.ViewMenu;
import Vistas.ViewVendedor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SANTOS
 */
public class CtrlLogin {
    private ViewLogin login;
    
    public CtrlLogin(ViewLogin login){
        this.login=login;
    }
    public Usuario buscarUsuario(String usuario, String pass){
        ConexionMySQL conexion = new ConexionMySQL();
        Connection cnp = conexion.conectarMySQL();
//cnp = conexion.conectarMySQL("192.168.99.100","33060", "DSdatabase", "root", "secret");

        Usuario u = null;
        try{
            Statement s = cnp.createStatement();
            ResultSet re = s.executeQuery("select * from Empleado where usuario ='"+usuario+"' and pass = '"+pass+"'"); 
                while(re.next()){
                    u = seleccionarUsuario(new Usuario(re.getString("usuario")),re.getString("Tipo"));
                }
            cnp.close();
        } catch (SQLException ex) {
           Logger.getLogger(CtrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
        return u;
    }
    
    
    public Usuario seleccionarUsuario(Usuario usuario, String tipo){
       switch (tipo) {
           case "VEND-1000":
               return new Vendedor(usuario.getUsuario());
           case "GER-1000":
               return new Gerente(usuario.getUsuario());
           case "ADMIN-100":
               return new Administrador(usuario.getUsuario());
           case "JFBOD-100":
               return new JefeBodega(usuario.getUsuario());
           default:
               break;
       }
        return null;
    }
    
    public void iniciarViews(Usuario user){
        
        ViewMenu gerente=new ViewGerente(login.getStage());
        ViewMenu administrador=new ViewAdministrador(login.getStage());
        ViewMenu jefeBodega=new ViewJefeBodega(login.getStage());
        ViewMenu vendedor=new ViewVendedor(login.getStage());
        gerente.setNext(administrador);administrador.setNext(jefeBodega);jefeBodega.setNext(vendedor);vendedor.setNext(null);
        CtrlUsuario usuario = new CtrlUsuario(user);
        usuario=usuario.getUsuario();
        IManejadorMenu menuUsuario = gerente.pedirManejador(usuario);
        System.out.println(menuUsuario);
        usuario.setLogin(menuUsuario);
        usuario.init();
    }
}