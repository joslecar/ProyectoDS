/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
        private Button btnBuscar;
        private TextField txtBusqueda;
        private ListView lvProductos;

    private VBox derecho;

    public ViewGerente(Stage stg) {
        super(stg);
        this.btnBuscar=new Button("Buscar");
        this.txtBusqueda=new TextField();
        this.btnAbastecimiento = new Button("Abzastecimiento");
        btnAbastecimiento.setVisible(false);
        this.btnAsignarAdmin = new Button("Asignar Admin");
        this.btnUsuarios = new Button("Usuarios");
        this.btnEnvios= new Button("Envios");
        this.btnProductos= new Button("Productos");
        this.btnVentas = new Button("Ventas");
        this.panel = new BorderPane();
        this.derecho= new VBox();
        derecho.getChildren().addAll(btnAsignarAdmin,btnUsuarios,btnEnvios,btnProductos,btnVentas,txtBusqueda,btnBuscar,btnAbastecimiento);
        llenarDerecho();
        llenarCentro();
        super.scene=new Scene(panel,600,500);
    }
    
    private void llenarDerecho(){
        derecho.setPadding(new Insets(5, 5, 5, 5));
        // Set margin for left area.
        BorderPane.setMargin(derecho, new Insets(10, 10, 10, 10));
        panel.setRight(derecho);

    }
private void llenarCentro(){
    panel.setCenter(lvProductos);
}
private void createListView(){
         // To Creating a Observable List
        ObservableList<String> productos = FXCollections.observableArrayList(
                "P1", "P2","P3","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4"
                ,"P1","P2","P3","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4");
 
        // Create a ListView
        lvProductos = new ListView<>(productos);
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
        this.setUser(user);
        super.stg.setTitle("Gerente! "+super.user);
        super.stg.setScene(super.scene);
        super.stg.show();
    }
    
}
