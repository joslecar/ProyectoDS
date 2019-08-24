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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SANTOS
 */
public class CtrlLogin {
    private final ViewLogin login;
    public static List<Usuario> empleados;
    public CtrlLogin(ViewLogin login){
        this.login=login;
    }
    public Usuario buscarUsuario(String usuario, String pass){
        if(comprobarUsuario(usuario) != null){
            return comprobarUsuario(usuario);
        }else{
            Connection cnp = ConexionMySQL.conectarMySQL();
            Usuario u = null;
            try(Statement s = cnp.createStatement()){
                try (ResultSet re = s.executeQuery("select * from Empleado where usuario ='"+usuario+"' and pass = '"+pass+"'")) { 
                    while(re.next()){
                        u = seleccionarUsuario(new Usuario(re.getString("Nombre"),re.getString("Apellido"),re.getString("usuario")),re.getString("Tipo"));
                    }
                }
            }catch (SQLException ex) {
                Logger.getLogger(CtrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            }
            return u;
        }
    }
    public Usuario comprobarUsuario(String usuario){
        empleados = new ArrayList<>();
        for(Usuario u:empleados){
            if(u.getUsuario().equals(usuario))
                return u;
        }
        return null;
    }
    
    
    public Usuario seleccionarUsuario(Usuario usuario, String tipo){
       switch (tipo) {
           case "VEND-1000":
               return new Vendedor(usuario.getUsuario(),usuario.getApellido(),usuario.getUsuario());
           case "GER-1000":
               return new Gerente(usuario.getNombre(),usuario.getApellido(),usuario.getUsuario());
           case "ADMIN-100":
               return new Administrador(usuario.getNombre(),usuario.getApellido(),usuario.getUsuario());
           case "JFBOD-100":
               return new JefeBodega(usuario.getNombre(),usuario.getApellido(),usuario.getUsuario());
           default:
               break;
       }
        return null;
    }
    
    public void iniciarViews(Usuario user){
        CtrlUsuario usuario = new CtrlUsuario(user);
        ViewMenu gerente=new ViewGerente(login.getStage());
        ViewMenu administrador=new ViewAdministrador(login.getStage());
        ViewMenu jefeBodega=new ViewJefeBodega(login.getStage());
        ViewMenu vendedor=new ViewVendedor(login.getStage());
        gerente.setNext(administrador);
        administrador.setNext(jefeBodega);
        jefeBodega.setNext(vendedor);
        vendedor.setNext(null);
        usuario=CtrlUsuario.getCtrlUsuario();
        System.out.println(usuario.toString());
        IManejadorMenu menuUsuario = gerente.pedirManejador(usuario);
        System.out.println(menuUsuario);
        usuario.setLogin(menuUsuario);
        usuario.init();
    }
}
