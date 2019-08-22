/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Administrador;
import Modelos.Producto;
import Modelos.Usuario;
import Vistas.ViewMenu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;

/**
 *
 * @author Jose Leonardo
 */
public class CtrlGerente extends CtrlUsuario{
    
    public CtrlGerente(ViewMenu login, Usuario user, Stage stg) {
        super(login, user, stg);
    }
    public CtrlGerente(Usuario user){
        super(user);
    }
    
    public List<Usuario> buscarEmpleados(){
        ConexionMySQL canalSQL=new ConexionMySQL();
        cnp=canalSQL.conectarMySQL();
        Usuario u;
        List<Usuario> usuarios = new ArrayList<>();
        String query = "select * from Empleado";
        try{
            Statement s = cnp.createStatement();
            ResultSet re = s.executeQuery(query);
            while(re.next()){
                u =new Usuario(re.getString("Nombre"),re.getString("Apellido"),re.getString("usuario"));
                System.out.println(u.toString());
                usuarios.add(u);
            }
            cnp.close();
        } catch (SQLException ex) {
           Logger.getLogger(CtrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
        return usuarios;
        
    }
    public void asignarAdmin(Usuario usuario){
        usuario = new Administrador(usuario.getNombre(),usuario.getApellido(),usuario.getUsuario());
    }
    
}
