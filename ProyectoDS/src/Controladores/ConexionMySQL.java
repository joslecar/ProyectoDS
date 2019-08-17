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
    public String driver = "com.mysql.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "databaseDS";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos 
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "rootpass1";
    
    public Connection conn;
    //Metodo para iniciar la conexion
    public Connection conectarMySQL() {
        conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        return conn;
    }
    
    public Connection conectarMySQL(String hostname, String database, String username, String password) {
        conn = null;
        String url = "jdbc:sqlserver://"+ hostname +":1433;databaseName="+database+";user="+username+";password="+password;
        try {
            Class.forName(driver);
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