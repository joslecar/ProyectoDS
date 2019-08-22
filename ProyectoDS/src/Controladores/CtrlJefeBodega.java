/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Repartidor;
import Modelos.Usuario;
import Vistas.ViewMenu;
import java.util.LinkedList;
import java.util.Queue;
import javafx.stage.Stage;

/**
 *
 * @author SANTOS
 */
public class CtrlJefeBodega extends CtrlUsuario{
    private Queue<Repartidor> repartidores=new LinkedList();
    public CtrlJefeBodega(ViewMenu login, Usuario user, Stage stg) {
        super(login, user, stg);
    }

    public CtrlJefeBodega(Usuario u) {
        super(u);
    }
    
    public void encolarRepartidor(Repartidor r){
        r.setIsDisponible(true);
        repartidores.offer(r);
        
    }
    
    public void desencolarRepartidor(){
        Repartidor r=repartidores.poll();
        r.setIsDisponible(false);
    }
}
