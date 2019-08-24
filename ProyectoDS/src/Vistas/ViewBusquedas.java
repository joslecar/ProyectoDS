/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.CtrlUsuario;
import Modelos.Producto;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author SANTOS
 */
public class ViewBusquedas  implements IView{
    //En realidad son productos pero una View no tiene contacto directo con el Model
    private ListView<Producto> lvProductos;
    
    private TextField txtBuscarNombre;
    private TextField txtBuscarCategoria;
    private TextField txtBuscarDescripcion;
    //setWrapText para multilinea
    private Label lblProductoEncontrado;
    
    private final Button btnBuscarNombre;
    private final Button btnBuscarDescrip;
    private final Button btnBuscarCategoria;
    private Button btnCotizacion;
    private Button btnVenta;
    private Button btnReporteEnvio;
    
    private final HBox columnas;
    private final VBox filas;
    
    private final Scene sc;
    
    private CtrlUsuario user;
    private List<Producto> products;
    
    
    public ViewBusquedas(){
        
        txtBuscarNombre=new TextField();
        txtBuscarDescripcion=new TextField();
        txtBuscarCategoria=new TextField();
        
        btnBuscarNombre=new Button("Buscar por Nombre");
        btnBuscarDescrip=new Button("Buscar por Descripcion");
        btnBuscarCategoria=new Button("Buscar por Categoria");
        
        lblProductoEncontrado=new Label("Producto: ");
        
        
        filas=new VBox();
        filas.getChildren().addAll(txtBuscarNombre,btnBuscarNombre,txtBuscarDescripcion,btnBuscarDescrip,txtBuscarCategoria,btnBuscarCategoria,lblProductoEncontrado);
        columnas=new HBox();
        columnas.getChildren().addAll(lvProductos,filas);                  
        
        createListView(products);
        sc=new Scene(columnas, 500, 500);
        
        btnBuscarNombre.setOnMouseClicked(e -> {
            products = user.buscarArticuloNom(txtBuscarNombre.getText());
            
        });  
        btnBuscarDescrip.setOnMouseClicked(e -> {
            products = user.buscarArticuloNom(txtBuscarDescripcion.getText());
            
        });
        btnBuscarCategoria.setOnMouseClicked(e -> {
            products = user.buscarArticuloNom(txtBuscarCategoria.getText());
            
        });
        
        lvProductos.setOnMouseClicked(e ->  {
            ObservableList<Producto> selectedItems =  lvProductos.getSelectionModel().getSelectedItems();
            for(Producto p : selectedItems){
                System.out.println("selected item " + p);
                lblProductoEncontrado.setText("Producto Seleccionado; " + p);
            }
        });

        
        
    }
    private void createListView(List l){
         // To Creating a Observable List
        ObservableList<Producto> productos = FXCollections.observableArrayList();
        productos.addAll(l);
        // Create a ListView
        lvProductos = new ListView<>(productos);
    }
    
    public Scene getScene(){
        return sc;
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
