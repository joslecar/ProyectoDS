/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Producto;
import Modelos.Usuario;
import Vistas.IManejadorMenu;
import java.util.List;
import javafx.event.Event;
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
public class CtrlUsuarioTest {
    
    public CtrlUsuarioTest() {
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
     * Test of getCtrlUsuario method, of class CtrlUsuario.
     * Valida el comportamiento si el usuario es una instancia de la calse padre y
     * no de ninguna clase hija.
     */
    @Test
    public void testGetCtrlUsuario() {
        System.out.println("getCtrlUsuario");
        CtrlUsuario instance = null;
        CtrlUsuario expResult = new CtrlUsuario(new Usuario("name", "lastname", "user"));
        CtrlUsuario result = CtrlUsuario.getCtrlUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class CtrlUsuario.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        CtrlUsuario instance = null;
        Usuario expResult = null;
        Usuario result = instance.getUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of init method, of class CtrlUsuario.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        CtrlUsuario instance = null;
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLogin method, of class CtrlUsuario.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        IManejadorMenu mm = null;
        CtrlUsuario instance = null;
        instance.setLogin(mm);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEvent method, of class CtrlUsuario.
     */
    @Test
    public void testGetEvent() {
        System.out.println("getEvent");
        CtrlUsuario instance = null;
        Event expResult = null;
        Event result = instance.getEvent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelEvent method, of class CtrlUsuario.
     */
    @Test
    public void testCancelEvent() {
        System.out.println("cancelEvent");
        CtrlUsuario instance = null;
        instance.cancelEvent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarArticuloNom method, of class CtrlUsuario.
     */
    @Test
    public void testBuscarArticuloNom() {
        System.out.println("buscarArticuloNom");
        String nombre = "";
        CtrlUsuario instance = null;
        List<Producto> expResult = null;
        List<Producto> result = instance.buscarArticuloNom(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarArticuloDescp method, of class CtrlUsuario.
     */
    @Test
    public void testBuscarArticuloDescp() {
        System.out.println("buscarArticuloDescp");
        String descripcion = "";
        CtrlUsuario instance = null;
        List<Producto> expResult = null;
        List<Producto> result = instance.buscarArticuloDescp(descripcion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarArticuloCat method, of class CtrlUsuario.
     */
    @Test
    public void testBuscarArticuloCat() {
        System.out.println("buscarArticuloCat");
        String categoria = "";
        CtrlUsuario instance = null;
        List<Producto> expResult = null;
        List<Producto> result = instance.buscarArticuloCat(categoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CtrlUsuario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CtrlUsuario instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
