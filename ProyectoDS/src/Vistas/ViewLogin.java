/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.CtrlUsuario;
import java.util.Map;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author SANTOS
 */
public class ViewLogin  implements IView,IManejadorMenu{
    private CtrlUsuario user;
    private IManejadorMenu next;
    private Label lblUser;
    private Label lblPass;
    private TextField txtUser;
    private PasswordField passPass;
    private Button btnIniSesion;
    private Scene scene;
    private GridPane panel;
   
    public ViewLogin(){
        lblUser=new Label("Usuario: ");
        lblPass=new Label("Contraseña: ");
        txtUser=new TextField();
        passPass=new PasswordField();
        btnIniSesion= new Button("Iniciar Sesion");
        
        panel=new GridPane();
        panel.add(lblUser, 1,1 );panel.add(txtUser, 2,1 );
        panel.add(lblPass, 1,2 );panel.add(passPass, 2,2 );
        panel.add(btnIniSesion, 1,3, 2,1);
        
        scene=new Scene(panel,300,300);
        
    }
    
    public Scene getScene(){
        return scene;
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

    @Override
    public void setNext(IManejadorMenu mm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IManejadorMenu pedirManejadorMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean puedeManejarlo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
