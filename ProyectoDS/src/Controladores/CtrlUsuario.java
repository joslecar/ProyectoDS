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
import java.util.ArrayList;
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
   private ViewMenu menu;
   private static Usuario user;
   private Stage stg;

    public CtrlUsuario(ViewMenu login,Usuario user,Stage stg) {
        this.menu = login;
        this.menu.setUser(this);
        this.user = user;
        this.stg = stg;
    }
    public CtrlUsuario(Usuario u){
        this.user=u;
    }
    public static CtrlUsuario getCtrlUsuario(){
        Usuario userC=CtrlUsuario.user;
        if(userC!=null){
        if(userC instanceof Administrador){
            return new CtrlAdministrador(userC);
        }else if(userC instanceof Gerente){
            return new CtrlGerente(userC);
        }else if(userC instanceof JefeBodega){
            return new CtrlJefeBodega(userC);
        }else if (userC instanceof Vendedor){
            return new CtrlVendedor(userC);
        }
        }
        return null;
        
    }
    public Usuario getUsuario(){
        return user;
    }
    public void init(){
        this.menu.setUser(this);
        this.menu.showMe();
    }
    public void setLogin(IManejadorMenu mm){
        this.menu=(ViewMenu) mm;
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
              
        return cargarProductos("select * from Producto where Nombre like '%"+nombre+"%';");
    }
   public List<Producto> buscarArticuloDescp(String descripcion){
       
        return cargarProductos("select * from Producto where Descripcion like '%"+descripcion+"%';");
    }
    public List<Producto> buscarArticuloCat(String categoria){
        
        return cargarProductos("select * from Producto where Categoria like '%"+categoria+"%';");
    }
    
    private List<Producto> cargarProductos(String query){
        cnp=ConexionMySQL.conectarMySQL();
        Producto p;
        List<Producto>products = new ArrayList<>();
        
        try(Statement s = cnp.createStatement()){
            try (ResultSet re = s.executeQuery(query)) {
                while(re.next()){
                    p=new Producto(re.getString("IDProducto"),re.getString("Nombre"),re.getString("Categoria"),re.getString("Descripcion"),re.getInt("Stock"),re.getDate("FechaIngreso"),re.getString("Marca"),re.getDouble("PrecioCompra"),re.getDouble("PrecioVenta"));
                    System.out.println(p.toString());
                    products.add(p);
                }
            }
        } catch (SQLException ex) {
           Logger.getLogger(CtrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
        return products;
        
    }
   @Override
    public String toString(){
        return "Controlador :"+user.toString();
    }
    
}
