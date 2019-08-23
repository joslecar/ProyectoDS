/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.List;

/**
 *
 * @author CltControl
 */
public class Envio {

   private List<Producto>products;
   private boolean estado;  

    public Envio(List<Producto> products, boolean estado) {
        this.products = products;
        this.estado = estado;
    }

    public List<Producto> getProducts() {
        return products;
    }

    public void setProducts(List<Producto> products) {
        this.products = products;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
