/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Usuario;
import Vistas.ViewMenu;
import javafx.stage.Stage;

/**
 *
 * @author Jose Leonardo
 */
public class CtrlGerente extends CtrlUsuario{
    
    public CtrlGerente(ViewMenu login, Usuario user, Stage stg) {
        super(login, user, stg);
    }
    public CtrlGerente(Usuario user){
        super(user);
    }
}
