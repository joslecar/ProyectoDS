/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Administrador;
import Modelos.Gerente;
import Modelos.JefeBodega;
import Modelos.Producto;
import Modelos.Usuario;
import Modelos.Vendedor;
import Vistas.IManejadorMenu;
import Vistas.ViewMenu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.stage.Stage;

/**
 *
 * @author SANTOS
 */
public class CtrlUsuario  implements IControl{
   Connection cnp=null;
   private ViewMenu login;
   private Usuario user;
   private Stage stg;

    public CtrlUsuario(ViewMenu login,Usuario user,Stage stg) {
        this.login = login;
        this.login.setUser(this);
        this.user = user;
        this.stg=stg;
    }
    
    public void init(){
       this.login.setUser(this);
       this.login.showMe();
    }
    public void setLogin(IManejadorMenu login){
        this.login=(ViewMenu) login;
    }
    
    public String elegirMenu(){
        if(user instanceof Gerente){
            System.out.println("G");
            return "g";
        }else if(user instanceof Administrador){
            System.out.println("A");
            return "a";
        }else if(user instanceof JefeBodega){
            System.out.println("JB");
            return "jb";
        }else if(user instanceof Vendedor){
            System.out.println("V");
            return "v";
        }
        return "";
    }
   
    @Override
    public Event getEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Producto> buscarArticuloNom(String nombre){
              
        return cargarProductos("select * from Producto where Nombre='%"+nombre+"'%");
    }
    public List<Producto> buscarArticuloDescp(String descripcion){
       
        return cargarProductos("select * from Producto where Descripcion='%"+descripcion+"'%");
    }
    public List<Producto> buscarArticuloCat(String categoria){
        
        return cargarProductos("select * from Producto where Categoria='%"+categoria+"'%");
    }
    
    private List<Producto>cargarProductos(String query){
        ConexionMySQL canalSQL=new ConexionMySQL();
        cnp=canalSQL.conectarMySQL("127.0.0.1", "DSdatabase", "root", "secret");
        
        Producto p=null;
        List<Producto>products = null;
        
        try{
            Statement s = cnp.createStatement();
            ResultSet re = s.executeQuery(query);
            while(re.next()){
                p=new Producto(re.getString("IDProducto"),re.getString("Nombre"),re.getString("Descripcion"),re.getString("Categoria"),re.getInt("Stock"),re.getDate("FechaIngreso"),re.getString("Marca"),re.getDouble("PrecioCompra"),re.getDouble("PrecioVenta"));
                products.add(p);
            }
            cnp.close();
            
        } catch (SQLException ex) {
           Logger.getLogger(CtrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
        return products;
        
    }
    
}
