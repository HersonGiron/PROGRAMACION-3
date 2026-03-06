/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author giron
 */

    // Declaración de la clase Conexion
    public class Conexion {

    // URL de conexión JDBC para conectarse a la base de datos 
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/umg?useSSL=false&serverTimezone=UTC";
    // Usuario de la base de datos 
    private static final String JDBC_USER = "hersongiron";
    // Contraseña del usuario de la base de datos
    private static final String JDBC_PASS = "123456";
   
    
    // Método estático que devuelve un objeto Connection para conectarse a la base de datos
    public static Connection getConnection() throws SQLException {
        // Utiliza DriverManager para establecer la conexión usando la URL, usuario y contraseña
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    

    // Método para cerrar un objeto ResultSet (resultado de una consulta)
    public static void close(ResultSet rs){
        // Bloque try para intentar cerrar el ResultSet
        try {
            // Cierra el ResultSet para liberar recursos de la base de datos
            rs.close();
        // Captura la excepción si ocurre un error al cerrar el ResultSet
        } catch (SQLException ex) {
            // Imprime el error en la consola
            ex.printStackTrace(System.out);
        }
    }
    

    // Método para cerrar un objeto PreparedStatement
    public static void close(PreparedStatement stmt){
        // Bloque try para intentar cerrar el PreparedStatement
        try {
            // Cierra el PreparedStatement para liberar recursos
            stmt.close();
        // Captura la excepción si ocurre un error al cerrar el statement
        } catch (SQLException ex) {
            // Imprime el error en la consola
            ex.printStackTrace(System.out);
        }
    }
    

    // Método para cerrar una conexión a la base de datos
    public static void close(Connection conn){
        // Bloque try para intentar cerrar la conexión
        try {
            // Cierra la conexión a la base de datos
            conn.close();
        // Captura la excepción si ocurre un error al cerrar la conexión
        } catch (SQLException ex) {
           // Imprime el error en la consola
           ex.printStackTrace(System.out);
        }
    }
}
