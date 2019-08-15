/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javafx.event.Event;

/**
 *
 * @author SANTOS
 */
public interface IControl {
    Event getEvent();
    void cancelEvent();
}
