/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.CtrlUsuario;
import java.util.Map;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author SANTOS
 */
public class ViewLogin  extends ViewMenu{
  
    private Label lblUser;
    private Label lblPass;
    private TextField txtUser;
    private PasswordField passPass;
    private Button btnIniSesion;
    private GridPane panel;
   
    public ViewLogin( Stage stg){
        super(stg);
        
        lblUser=new Label("Usuario: ");
        lblPass=new Label("Contraseña: ");
        txtUser=new TextField();
        passPass=new PasswordField();
        btnIniSesion= new Button("Iniciar Sesion");
        
        panel=new GridPane();
        panel.add(lblUser, 1,1 );panel.add(txtUser, 2,1 );
        panel.add(lblPass, 1,2 );panel.add(passPass, 2,2 );
        panel.add(btnIniSesion, 1,3, 2,1);
        
        super.scene=new Scene(panel,300,300);
        
    }
    
    @Override
    public void showMe(){
        //super.scene=new Scene(panel,300,300);
        stg.setTitle("Bienvenido! ");
        stg.setScene(super.scene);
        stg.show();
        try{
            btnIniSesion.setOnAction((e)->{
                user.buscarUsuario(txtUser.getText(), passPass.getText());
 
                    System.out.println("Elegir Menu GAJBV");
                    IManejadorMenu m=pedirManejador(user);
                    user.setLogin(m);
                    user.init();
 

            });
        }catch(Exception ex){
            System.err.println("EXCEPCION btnIniSesion");
        }
    }
    
    public Scene getScene(){
        return scene;
    }
    
    
    
    
 
    
}
