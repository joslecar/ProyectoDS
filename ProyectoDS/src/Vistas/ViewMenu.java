/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.CtrlUsuario;
import java.util.Map;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author SANTOS
 */
public class ViewMenu implements IManejadorMenu,IView{
    protected IManejadorMenu next;
    protected CtrlUsuario user;
    protected Stage stg;
    protected Scene scene;

    public ViewMenu(Stage stg) {
        
        this.stg = stg;
        this.scene=null;
        this.next=null;
    }
    
    @Override
    public void setNext(IManejadorMenu mm) {
        this.next=mm;
    }
    
    public void setUser(CtrlUsuario user) {
        this.user=user;
    }

    @Override
    public IManejadorMenu pedirManejador(CtrlUsuario user) {
        if(this.puedeManejarlo(user.elegirMenu())){return this;}
        if(this.next==null){return null;}
        
        return this.next.pedirManejador(user);
    }

    @Override
    public void showMe() {
        System.out.println("Muestra la pantalla");
    }

    protected boolean puedeManejarlo(String manejador) {
                System.out.println("Menu no puede manejarlo");
        return false;
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
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
