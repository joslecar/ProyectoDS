/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.CtrlGerente;
import Controladores.CtrlUsuario;
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
    private final BorderPane panel;
    private Scene scene;
    private final Button btnAbastecimiento;
    private final Button btnAsignarAdmin;
    private final Button btnUsuarios;
    private final Button btnEnvios;
    private final Button btnProductos;
    private final Button btnVentas;
    private final TextField txtBuscarNombre;
    private final TextField txtBuscarCategoria;
    private final TextField txtBuscarDescripcion;
    private final Button btnBuscarNombre;
    private final Button btnBuscarDescrip;
    private final Button btnBuscarCategoria;
    private final Button btnSalir;
    private ListView lvProductos;
    private ListView<Usuario> lvUsuarios;
    private final VBox derecho;
    private ViewLogin login;
    public ViewGerente(Stage stg) {
        super(stg);
        txtBuscarNombre=new TextField();
        txtBuscarDescripcion=new TextField();
        txtBuscarCategoria=new TextField();
        btnSalir = new Button("Salir");
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
        //controladorger = new CtrlGerente(user.getUsuario());
        derecho.getChildren().addAll(btnAsignarAdmin,btnUsuarios,btnEnvios,btnProductos,btnVentas,txtBuscarCategoria,btnBuscarCategoria,txtBuscarNombre,btnBuscarNombre,txtBuscarDescripcion,btnBuscarDescrip,btnAbastecimiento);
        llenarDerecho();
        panel.setBottom(btnSalir);
        //llenarCentro();
        super.scene=new Scene(panel,600,500);
        manejarBotones(stg);
        
 
    }
    private void manejarBotones(Stage stg){
        btnBuscarCategoria.setOnAction(e->{
            createListView("Categoria");
        });
        btnBuscarNombre.setOnAction(e->{
            createListView("Nombre");
        });
        btnBuscarDescrip.setOnAction(e->{
            createListView("Descripcion");
        });
        
        btnAsignarAdmin.setOnAction(e->{
            createListViewEmpleados();
            
        });
        btnSalir.setOnAction(e->{
            login = new ViewLogin(stg);
            login.showMe();
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
    private void createListViewEmpleados(){
        System.out.println(user.toString());
        CtrlGerente gerente = new CtrlGerente(user.getUsuario());
        gerente.buscarEmpleados();
        ObservableList<Usuario> usuarios = FXCollections.observableArrayList(gerente.buscarEmpleados());
        lvUsuarios = new ListView<>(usuarios);
        panel.setCenter(lvUsuarios);
        lvUsuarios.setOnMouseClicked(e->{
            gerente.asignarAdmin(lvUsuarios.getSelectionModel().getSelectedItem());
        });
        
    }
    public Scene getScene() {
        return scene;
    }
    
    @Override
    protected boolean puedeManejarlo(CtrlUsuario usuario) {
        return usuario instanceof CtrlGerente;
    }
    
   @Override
    public void showMe(){
        System.out.println("GERENTEEEEE");
        this.setUser(super.user);
        super.stg.setTitle("Gerente! "+super.user);
        super.stg.setScene(super.scene);
        super.stg.show();
    }
    
}
