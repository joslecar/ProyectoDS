/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectods;

import Controladores.CtrlUsuario;
import Modelos.Administrador;
import Modelos.Gerente;
import Modelos.JefeBodega;
import Modelos.Usuario;
import Modelos.Vendedor;
import Vistas.Complementos.ViewRegistrar;
import Vistas.ViewAdministrador;
import Vistas.ViewGerente;
import Vistas.ViewJefeBodega;
import Vistas.ViewBusquedas;
import Vistas.ViewLogin;
import Vistas.ViewMenu;
import Vistas.ViewVendedor;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author Jose Leonardo
 */
public class ProyectoDS extends Application{

   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewLogin login=new ViewLogin(primaryStage);
        login.showMe();
        
    }
    
}/*
public class AA extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         ViewLogin login=new ViewLogin();
        ViewRegistrar registrar=new ViewRegistrar();
        ViewLocal local= new ViewLocal();
        ViewGerente gerente=new ViewGerente();
        primaryStage.setTitle("Pantalla de prueba");
        primaryStage.setScene(local.getScene());
        primaryStage.show();
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        GUIMosaico mosaico= new GUIMosaico();
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(mosaico.getScene());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}*/
