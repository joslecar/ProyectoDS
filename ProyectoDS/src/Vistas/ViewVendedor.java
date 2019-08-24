/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.CtrlUsuario;
import Controladores.CtrlVendedor;
import java.util.Map;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author SANTOS
 */
public class ViewVendedor extends ViewMenu  {
    private final Button btnSalir;
    private final BorderPane panel;
    private ViewLogin login;
    
    public ViewVendedor(Stage stg) {
        super(stg);
        panel = new BorderPane();
        btnSalir = new Button("Salir");
        panel.setBottom(btnSalir);
        btnSalir.setOnAction(e->{
            login = new ViewLogin(stg);
            login.showMe();
        });
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
