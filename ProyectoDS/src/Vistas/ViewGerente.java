/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.util.Map;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author SANTOS
 */
public class ViewGerente extends ViewMenu{
    private BorderPane panel;
    private Scene scene;
    private Button btnAbastecimiento;
    private Button btnAsignarAdmin;
    private Button btnUsuarios;
    private Button btnEnvios;
    private Button btnProductos;
    private Button btnVentas;
    private VBox derecho;

    public ViewGerente(Stage stg) {
        super(stg);
        this.btnAbastecimiento = new Button("Abzastecimiento");
        this.btnAsignarAdmin = new Button("Asignar Admin");
        this.btnUsuarios = new Button("Usuarios");
        this.btnEnvios= new Button("Envios");
        this.btnProductos= new Button("Productos");
        this.btnVentas = new Button("Ventas");
        this.panel = new BorderPane();
        this.derecho= new VBox();
        derecho.getChildren().addAll(btnAsignarAdmin,btnAbastecimiento,btnUsuarios,btnEnvios,btnProductos,btnVentas);
        llenarDerecho();
        scene= new Scene(panel,600,500);
    }
    
    private void llenarDerecho(){
        derecho.setPadding(new Insets(5, 5, 5, 5));
        // Set margin for left area.
        BorderPane.setMargin(derecho, new Insets(10, 10, 10, 10));
        panel.setRight(derecho);

    }

    public Scene getScene() {
        return scene;
    }
    
     @Override
    protected boolean puedeManejarlo(String manejador) {
        if(manejador.toLowerCase().equals("g")){
            return true;
        }
        return false;
    }
    
   @Override
    public void showMe(){
        System.out.println("GERENTEEEEE");
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
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
