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
    public String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    // Nombre de la base de datos
    public String database = "Sysapplog";

    // Host
//<<<<<<< HEAD
   //public String hostname = "169.254.127.21";
//=======
//>>>>>>> a837ff43041664401c12801dbb61fb286b8317c8*/
    public String hostname = "SYSWEBSERVICE\\SQLEXPRESS";

    // Puerto 1403
    public String port = "1433";

    
     // Nombre de usuario
    public String username = "sa";

    // Clave de usuario
    
    public String password = "Rootpass1";
    
    // Ruta de nuestra base de datos 
    public String url = "jdbc:sqlserver://" + hostname + ":" + port + ";databaseName=" + database+";user="+username +";password="+password;

   
    
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
    //Metodo para cerrar la conexion
    public void desconectar() throws SQLException{
    if (conn != null) {
        conn.close();
  }
    
    }

}