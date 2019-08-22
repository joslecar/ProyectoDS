/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.CtrlJefeBodega;
import Controladores.CtrlUsuario;
import Modelos.JefeBodega;
import Modelos.Usuario;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author SANTOS
 */
public class ViewJefeBodega extends ViewMenu{
    private Button crearRuta;
    private Button novEnvio;
    private Button btnSalir;
    private VBox botones;
    private BorderPane panel;
    private ListView<String> lvEnvios;
    private ViewLogin login;
            
    public ViewJefeBodega( Stage stg) {
        super( stg);
       createListView();
        crearRuta= new Button("Crear Ruta");
        novEnvio= new Button("Novedades de Envio");
        btnSalir = new Button("Salir");
        botones=new VBox();
        panel=new BorderPane();
        setRigth();
        setCenter();
        setBottom();
        super.scene=new Scene(panel,300,300);
    }
    
    private void setRigth(){
        botones.getChildren().addAll(crearRuta,novEnvio);
        botones.setPadding(new Insets(10,10,10,10));
        panel.setRight(botones);
    }
    
    private void setCenter(){
        panel.setCenter(lvEnvios);
    }
    private void setBottom(){
        panel.setBottom(btnSalir);
        btnSalir.setOnAction(e->{
            login = new ViewLogin(stg);
            login.showMe();
        });
    }
    private void createListView(){
         // To Creating a Observable List
        ObservableList<String> envios = FXCollections.observableArrayList(
                "P1", "P2","P3","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4"
                ,"P1","P2","P3","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4");
 
        // Create a ListView
        lvEnvios = new ListView<>(envios);
    }
     @Override
    protected boolean puedeManejarlo(CtrlUsuario manejador) {
        return (manejador instanceof CtrlJefeBodega);
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
        this.setUser(super.user);
        System.out.println("JEFE BODEGA");
        super.stg.setTitle("Jefe Bodega! "+super.user);
        super.stg.setScene(super.scene);
        super.stg.show();    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
