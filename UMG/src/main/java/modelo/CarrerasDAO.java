/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.Carreras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *
 * @author giron
 */
// Declaración de la clase CarrerasDAO que se encarga de realizar las operaciones CRUD en la BD
public class CarrerasDAO {


// Consulta SQL para seleccionar todas las carreras de la tabla carreras
private static final String SQL_SELECT = 
"SELECT CarCodigo, CarNombre, CarEstatus FROM carreras";
// Consulta SQL para insertar una nueva carrera en la tabla carreras
// Los signos ? son comodines que se llenaran despues
private static final String SQL_INSERT = 
"INSERT INTO carreras(CarNombre, CarEstatus) VALUES(?,?)";
// Consulta SQL para actualizar el nombre y estatus de una carrera según el código de carrera
private static final String SQL_UPDATE = 
"UPDATE carreras SET CarNombre=?, CarEstatus=? WHERE CarCodigo=?";
// Consulta SQL para eliminar una carrera según su código
private static final String SQL_DELETE = 
"DELETE FROM carreras WHERE CarCodigo=?";
// Consulta SQL para buscar una carrera específica según su código
private static final String SQL_QUERY = 
"SELECT CarCodigo, CarNombre, CarEstatus FROM carreras WHERE CarCodigo=?";


   // Método que obtiene todas las carreras de la base de datos
   public List<Carreras> select() {
    // Variable para manejar la conexión a la base de datos
    Connection conn = null;
    // Objeto que permite ejecutar instrucciones SQL con parámetros
    PreparedStatement stmt = null;
    // Objeto que almacena los resultados de una consulta SQL
    ResultSet rs = null;
    // Objeto temporal para almacenar una carrera
    Carreras carrera = null;
    // Lista que almacenará todas las carreras obtenidas de la base de datos
    List<Carreras> carreras = new ArrayList<>();
    try {
        // Obtiene la conexión a la base de datos
        conn = Conexion.getConnection();
        // Prepara la consulta SQL para seleccionar carreras
        stmt = conn.prepareStatement(SQL_SELECT);
        // Ejecuta la consulta y obtiene los resultados
        rs = stmt.executeQuery();
        // Recorre cada registro obtenido en la consulta
        while (rs.next()) {
            // Obtiene el código de la carrera del resultado
            int codigo = rs.getInt("CarCodigo");
            // Obtiene el nombre de la carrera
            String nombre = rs.getString("CarNombre");
            // Obtiene el estatus de la carrera
            int estatus = rs.getInt("CarEstatus");
            // Crea un nuevo objeto Carreras
            carrera = new Carreras();
            // Asigna el código obtenido al objeto
            carrera.setCodigoCarrera(codigo);
            // Asigna el nombre obtenido al objeto
            carrera.setNombreCarrera(nombre);
            // Asigna el estatus obtenido al objeto
            carrera.setEstatus(estatus);
            // Agrega el objeto carrera a la lista
            carreras.add(carrera);
        }
    // Captura errores de SQL si ocurren durante la ejecución
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    // Bloque finally que siempre se ejecuta para cerrar recursos
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }
    // Retorna la lista con todas las carreras
    return carreras;
}

// Método que inserta una nueva carrera en la base de datos
public int insert(Carreras carrera) {
    // Variable para la conexión
    Connection conn = null;
    // Objeto para ejecutar la consulta SQL
    PreparedStatement stmt = null;
    // Variable que guarda la cantidad de filas afectadas
    int rows = 0;
    try {
        // Obtiene la conexión a la base de datos
        conn = Conexion.getConnection();
        // Prepara la consulta SQL de inserción
        stmt = conn.prepareStatement(SQL_INSERT);
        // Asigna el nombre de la carrera al primer parámetro
        stmt.setString(1, carrera.getNombreCarrera());
        // Asigna el estatus de la carrera al segundo parámetro
        stmt.setInt(2, carrera.getEstatus());
        // Ejecuta la inserción en la base de datos
        rows = stmt.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(stmt);
        Conexion.close(conn);
    }
    // Retorna el número de registros insertados
    return rows;
}

// Método para actualizar una carrera existente
public int update(Carreras carrera) {
    Connection conn = null;
    PreparedStatement stmt = null;
    // Variable que guarda el número de registros modificados
    int rows = 0;

    try {
        // Obtiene la conexión
        conn = Conexion.getConnection();
        // Prepara la consulta SQL de actualización
        stmt = conn.prepareStatement(SQL_UPDATE);
        // Asigna el nuevo nombre de la carrera
        stmt.setString(1, carrera.getNombreCarrera());
        // Asigna el nuevo estatus
        stmt.setInt(2, carrera.getEstatus());
        // Indica qué carrera se actualizará mediante su código
        stmt.setInt(3, carrera.getCodigoCarrera());
        // Ejecuta la actualización
        rows = stmt.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(stmt);
        Conexion.close(conn);
    }
    // Retorna el número de registros actualizados
    return rows;
}

// Método para eliminar una carrera de la base de datos
public int delete(Carreras carrera) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;
    try {
        // Obtiene la conexión
        conn = Conexion.getConnection();
        // Prepara la consulta SQL de eliminación
        stmt = conn.prepareStatement(SQL_DELETE);
        // Indica qué carrera eliminar según su código
        stmt.setInt(1, carrera.getCodigoCarrera());
        // Ejecuta la eliminación
        rows = stmt.executeUpdate();

    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(stmt);
        Conexion.close(conn);
    }
    // Retorna el número de registros eliminados
    return rows;
}


// Método para buscar una carrera específica por su código
public Carreras query(Carreras carrera) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {

        // Obtiene la conexión
        conn = Conexion.getConnection();
        // Prepara la consulta SQL
        stmt = conn.prepareStatement(SQL_QUERY);
        // Establece el código de la carrera a buscar
        stmt.setInt(1, carrera.getCodigoCarrera());
        // Ejecuta la consulta
        rs = stmt.executeQuery();

        // Recorre el resultado obtenido
        while (rs.next()) {

            // Obtiene los datos de la base de datos
            int codigo = rs.getInt("CarCodigo");
            String nombre = rs.getString("CarNombre");
            int estatus = rs.getInt("CarEstatus");

            // Asigna los valores al objeto carrera
            carrera.setCodigoCarrera(codigo);
            carrera.setNombreCarrera(nombre);
            carrera.setEstatus(estatus);
        }

    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    //ciera las conexiones
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }
    // Retorna la carrera encontrada
    return carrera;
}

}