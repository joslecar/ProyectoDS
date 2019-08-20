/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.CtrlUsuario;
import Controladores.CtrlVendedor;
import Modelos.Usuario;
import Modelos.Vendedor;
import java.util.Map;
import javafx.stage.Stage;

/**
 *
 * @author SANTOS
 */
public class ViewVendedor extends ViewMenu  {
    
    public ViewVendedor(Stage stg) {
        super(stg);
    }

     @Override
    protected boolean puedeManejarlo(CtrlUsuario manejador) {
        return (manejador instanceof CtrlVendedor);
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
