/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelos.Gerente;
import Modelos.Producto;
import Modelos.Usuario;
import java.util.ArrayList;
import java.util.List;
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
    private TextField txtBuscarNombre;
    private TextField txtBuscarCategoria;
    private TextField txtBuscarDescripcion;
    private Button btnBuscarNombre;
    private Button btnBuscarDescrip;
    private Button btnBuscarCategoria;
    private Button btnCotizacion;
    private Button btnVenta;
    private Button btnReporteEnvio;
        private Button btnBuscar;
        private TextField txtBusqueda;
        private ListView lvProductos;

    private VBox derecho;

    public ViewGerente(Stage stg) {
        super(stg);
        txtBuscarNombre=new TextField();
        txtBuscarDescripcion=new TextField();
        txtBuscarCategoria=new TextField();
        
        btnBuscarNombre=new Button("Buscar por Nombre");
        btnBuscarDescrip=new Button("Buscar por Descripcion");
        btnBuscarCategoria=new Button("Buscar por Categoria");
        this.btnAbastecimiento = new Button("Abastecimiento");
        btnAbastecimiento.setVisible(false);
        this.btnAsignarAdmin = new Button("Asignar Admin");
        this.btnUsuarios = new Button("Usuarios");
        this.btnEnvios= new Button("Envios");
        this.btnProductos= new Button("Productos");
        this.btnVentas = new Button("Ventas");
        this.panel = new BorderPane();
        this.derecho= new VBox();
        derecho.getChildren().addAll(btnAsignarAdmin,btnUsuarios,btnEnvios,btnProductos,btnVentas,txtBuscarCategoria,btnBuscarCategoria,txtBuscarNombre,btnBuscarNombre,txtBuscarDescripcion,btnBuscarDescrip,btnAbastecimiento);
        llenarDerecho();
        //llenarCentro();
        super.scene=new Scene(panel,600,500);
        btnBuscarCategoria.setOnAction(e->{
            createListView("Categoria");
        });
        btnBuscarNombre.setOnAction(e->{
            createListView("Nombre");
        });
        btnBuscarDescrip.setOnAction(e->{
            createListView("Descripcion");
        });
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
private void createListView(String tipo){
         // To Creating a Observable List
        ObservableList<Producto> productos = FXCollections.observableArrayList();
        if(tipo.equals("Categoria")){
            productos = FXCollections.observableArrayList(user.buscarArticuloCat(txtBuscarCategoria.getText()));
        }else if(tipo.equals("Nombre")){
            productos = FXCollections.observableArrayList(user.buscarArticuloNom(txtBuscarNombre.getText()));
        }else if(tipo.equals("Descripcion")){
            productos = FXCollections.observableArrayList(user.buscarArticuloNom(txtBuscarDescripcion.getText()));
        }
        
        lvProductos = new ListView<>(productos);
        panel.setCenter(lvProductos);
    }
    public Scene getScene() {
        return scene;
    }
    
    protected boolean puedeManejarlo(Usuario usuario) {
        if(usuario instanceof Gerente){
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
