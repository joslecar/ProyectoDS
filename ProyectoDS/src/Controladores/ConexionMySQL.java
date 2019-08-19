/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jose Leonardo
 */


public class ConexionMySQL {

    // Librería de MySQL
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static Connection conn;
    
    //Metodo para iniciar la conexion
    public Connection conectarMySQL(String hostname, String port,String database, String username, String password) {
        conn = null;
        String url = "jdbc:mysql://"+ hostname +":"+port+"/"+database+"?useSSL=false";
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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