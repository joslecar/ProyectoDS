/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.util.Map;
import javafx.stage.Stage;

/**
 *
 * @author SANTOS
 */
public class ViewAdministrador extends ViewMenu{
    public ViewAdministrador( Stage stg) {
        super( stg);
    }

     @Override
    protected boolean puedeManejarlo(String manejador) {
        if(manejador.toLowerCase().equals("a")){
            return true;
        }
        return false;
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
        System.out.println("ADMINISTRADOOORRR");
        }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
