/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Usuario;
import Vistas.ViewLogin;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SANTOS
 */
public class CtrlLoginTest {
    
    public CtrlLoginTest() {
        
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of buscarUsuario method, of class CtrlLogin.
     * Busca dentro de la base de datos si el usuario y el pass son correctos
     */
    @Test
    public void testBuscarUsuario() {
        System.out.println("buscarUsuario");
        String usuario = "leonardoca";
        String pass = "leon1959";
        
        CtrlLogin instance = new CtrlLogin(new ViewLogin(new Stage()));
        Usuario expResult = new Usuario("Leonardo","Carrion", usuario);
        Usuario result = instance.buscarUsuario(usuario, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of comprobarUsuario method, of class CtrlLogin.
     */
    @Test
    public void testComprobarUsuario() {
        System.out.println("comprobarUsuario");
        String usuario = "";
        CtrlLogin instance = null;
        Usuario expResult = null;
        Usuario result = instance.comprobarUsuario(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarUsuario method, of class CtrlLogin.
     * Determina que sucede si se ingresa un nuevo tipo de usuario que aun no se
     * encuentra en la BD
     */
    @Test
    public void testSeleccionarUsuario() {
        System.out.println("seleccionarUsuario");
        Usuario usuario = null;
        String tipo = "CAJ-100";
        CtrlLogin instance = new CtrlLogin(new ViewLogin(new Stage()));
        Usuario expResult = null;
        Usuario result = instance.seleccionarUsuario(usuario, tipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of iniciarViews method, of class CtrlLogin.
     * Valida que sucede si no hay un usuario inicializado y una vista vacia
     */
    @Test
    public void testIniciarViews() {
        System.out.println("iniciarViews");
        Usuario user = null;
        CtrlLogin instance = new CtrlLogin(new ViewLogin(new Stage()));
        instance.iniciarViews(user);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
