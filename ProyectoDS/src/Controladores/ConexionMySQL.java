/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Leonardo
 */


public class ConexionMySQL {

    // Librería de MySQL
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static Connection conn;
    private final static String DATABASE = "DSdatabase";
    private final static String HOSTNAME = "192.168.99.100";
    private final static String PORT = "33060";
     // Nombre de usuario
    private final static String USERNAME = "root";

    // Clave de usuario
    
    private final static String PASSMY = "secret";

    // Ruta de nuestra base de datos 
    public final static String URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DATABASE+"?useSSL=false";

    //Metodo para iniciar la conexion
    public static Connection conectarMySQL() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSMY);
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, e);
        }
        return conn;
    }
    //Metodo para cerrar la conexion
    public void desconectar() throws SQLException{
    if (conn != null) {
        conn.close();
  }
    
    }

}