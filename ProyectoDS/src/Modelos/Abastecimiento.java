/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.List;

/**
 *
 * @author Jose Leonardo
 */
class Abastecimiento extends Envio{
    
    public Abastecimiento(List<Producto> products, boolean estado) {
        super(products, estado);
    }
    
}
