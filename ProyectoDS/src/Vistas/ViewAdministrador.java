/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.CtrlAdministrador;
import Controladores.CtrlUsuario;
import Modelos.Administrador;
import Modelos.Usuario;
import java.util.Map;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author SANTOS
 */
public class ViewAdministrador extends ViewMenu{
    private final Button ingStock;
    private final Button ingPVP;
    private final Button btnSalir;
    private final VBox botones;
    private final BorderPane panel;
    private ViewLogin login;
    public ViewAdministrador( Stage stg) {
        super( stg);
       
        ingStock= new Button("Ingresar Stock");
        ingPVP= new Button("Ingresar PVP");
        btnSalir = new Button("Salir");
        botones=new VBox();
        panel=new BorderPane();
        setRigth();
        setBottom();
        super.scene=new Scene(panel,300,300);
        
    }
    
    private void setRigth(){
        botones.getChildren().addAll(ingStock,ingPVP);
        panel.setRight(botones);
    }
    private void setBottom(){
        panel.setBottom(btnSalir);
        btnSalir.setOnAction(e->{
            login = new ViewLogin(stg);
            login.showMe();
        });
    }
     @Override
    protected boolean puedeManejarlo(CtrlUsuario manejador) {
        return (manejador instanceof CtrlAdministrador);
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
            this.setUser(user);
            System.out.println("ADMINISTRADOOORRR");
            super.stg.setTitle("Administrador! "+super.user);
            super.stg.setScene(super.scene);
            super.stg.show();

    }
    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
