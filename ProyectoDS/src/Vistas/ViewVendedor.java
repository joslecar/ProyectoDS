/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelos.Usuario;
import Modelos.Vendedor;
import java.util.Map;
import javafx.stage.Stage;

/**
 *
 * @author SANTOS
 */
public class ViewVendedor extends ViewLogin  implements IView{
    
    public ViewVendedor(Stage stg) {
        super(stg);
    }

     @Override
    protected boolean puedeManejarlo(Usuario manejador) {
        return (manejador instanceof Vendedor);
    }
    
    @Override
    public void setData(Map mapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showMe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
