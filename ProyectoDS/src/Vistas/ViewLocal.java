/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelos.Producto;
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
public class ViewLocal  implements IView{
    //En realidad son productos pero una View no tiene contacto directo con el Model
    private ListView<String> lvProductos;
    private TextField txtBusqueda;
    //setWrapText para multilinea
    private Label lblProductoEncontrado;
    private Button btnBuscar;
    private Button btnCotizacion;
    private Button btnVenta;
    private Button btnReporteEnvio;
    
    private HBox columnas;
    private VBox filas;
    private Scene sc;
    
    public ViewLocal(){
        createListView();
        txtBusqueda=new TextField();
        btnBuscar=new Button("Buscar");
        lblProductoEncontrado=new Label("Producto: ");
        btnCotizacion=new Button("Cotizacion");
        btnVenta=new Button("Venta");
        btnReporteEnvio=new Button("Reporte/Envio");
        
        filas=new VBox();
        filas.getChildren().addAll(txtBusqueda,btnBuscar,lblProductoEncontrado,btnCotizacion,btnVenta,btnReporteEnvio);
        columnas=new HBox();
        columnas.getChildren().addAll(lvProductos,filas);
        
        sc=new Scene(columnas, 500, 500);
        
        
    }
    private void createListView(){
         // To Creating a Observable List
        ObservableList<String> productos = FXCollections.observableArrayList(
                "P1", "P2","P3","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4"
                ,"P1","P2","P3","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4","P4");
 
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
