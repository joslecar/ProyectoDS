/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.CtrlUsuario;


/**
 *
 * @author CltControl
 */
public interface IManejadorMenu {
    
    void setNext(IManejadorMenu mm);
    IManejadorMenu pedirManejador(CtrlUsuario user);
}
