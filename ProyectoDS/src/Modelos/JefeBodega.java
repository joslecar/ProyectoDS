/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Controladores.ConexionMySQL;
import Controladores.CtrlUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Leonardo
 */
public class JefeBodega extends Usuario{
    private Queue<Repartidor> repartidores;
    Connection cnr=null;
    
    public JefeBodega(String nombre,String apellido,String usuario) {
        super(nombre,apellido,usuario);
    }
    
     private List<Repartidor> cargarRepartidores(){
        ConexionMySQL canalSQL=new ConexionMySQL();
        cnr=canalSQL.conectarMySQL();
        Repartidor r;
        List<Repartidor>repartidores = new ArrayList<>();
        
        try{
            Statement s = cnr.createStatement();
            ResultSet re = s.executeQuery("select * from Repartidor");
            while(re.next()){
                r=new Repartidor(re.getString("Nombre"),re.getString("Apellido"),re.getString("Cedula"),null,true);
                System.out.println(r.toString());
                repartidores.add(r);
            }
            cnr.close();
        } catch (SQLException ex) {
           Logger.getLogger(CtrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
        return repartidores;
        
    }
   
}
