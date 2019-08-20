/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

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
    private Button ingStock;
    private Button ingPVP;
    private VBox botones;
    private BorderPane panel;
    
    public ViewAdministrador( Stage stg) {
        super( stg);
       
        ingStock= new Button("Ingresar Stock");
        ingPVP= new Button("Ingresar PVP");
        botones=new VBox();
        panel=new BorderPane();
        setRigth();
        super.scene=new Scene(panel,300,300);
    }
    
    private void setRigth(){
        botones.getChildren().addAll(ingStock,ingPVP);
        panel.setRight(botones);
    }

     @Override
    protected boolean puedeManejarlo(Usuario manejador) {
        return (manejador instanceof Administrador);
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
