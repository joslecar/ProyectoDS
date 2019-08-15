/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.util.Map;

/**
 *
 * @author SANTOS
 */
public interface IView {
    void setData(Map mapa);
    Map getData();
    void showMe();
    void close();
}
