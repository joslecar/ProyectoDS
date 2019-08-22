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
public class RutaDeEntrega {
    private String descripcion;
    private List<Envio> envios;

    public RutaDeEntrega(String descripcion, List<Envio> envios) {
        this.descripcion = descripcion;
        this.envios = envios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(List<Envio> envios) {
        this.envios = envios;
    }
}
