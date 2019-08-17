/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Complementos;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
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
public class ViewRegistrar {
    private Label lblNombre;
    private Label lblApellido;
    private Label lblCedula;
    private Label lblUsuario;
    private Label lblContraseña;
    private TextField txtNombre;
    private TextField txtApellido;
    private TextField txtCedula;
    private TextField txtUsuario;
    private PasswordField passPass;
    private Button btnRegistrar;
    private GridPane panel;
    private Scene sc;
    
    public ViewRegistrar(){
        lblNombre=new Label("Nombres: ");txtNombre=new TextField();
        lblApellido= new Label("Apellidos: ");txtApellido=new TextField();
        lblCedula=new Label("Cedula: ");txtCedula=new TextField();
        lblUsuario=new Label("Usuario: ");txtUsuario= new TextField();
        lblContraseña=new Label("Contraseña: ");passPass= new PasswordField();
        btnRegistrar= new Button("Registrar");
        
        panel=new GridPane();
        panel.add(lblNombre, 0, 0);panel.add(txtNombre, 1, 0);
        panel.add(lblApellido, 0, 1);panel.add(txtApellido, 1, 1);
        panel.add(lblCedula, 0, 2);panel.add(txtCedula, 1, 2);
        panel.add(lblUsuario, 0, 3);panel.add(txtUsuario, 1, 3);
        panel.add(lblContraseña, 0, 4);panel.add(passPass, 1, 4);
        panel.add(btnRegistrar, 0, 5,2,1);
        GridPane.setHalignment(btnRegistrar, HPos.CENTER);
        panel.setPadding(new Insets(30));
        panel.setVgap(15);panel.setHgap(15);
        sc=new Scene(panel,300,350);
        
    }

    public Scene getScene() {
        return sc;
    }
    
    
    
}
