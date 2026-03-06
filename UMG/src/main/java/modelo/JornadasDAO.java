/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.Jornadas;
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
public class JornadasDAO {

private static final String SQL_SELECT =
"SELECT JorCodigo, JorNombre FROM Jornadas";
private static final String SQL_INSERT =
"INSERT INTO Jornadas(JorNombre) VALUES(?)";
private static final String SQL_UPDATE =
"UPDATE Jornadas SET JorNombre=? WHERE JorCodigo=?";
private static final String SQL_DELETE =
"DELETE FROM Jornadas WHERE JorCodigo=?";
private static final String SQL_QUERY =
"SELECT JorCodigo, JorNombre FROM Jornadas WHERE JorCodigo=?";


public List<Jornadas> select() {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Jornadas jornada = null;
    List<Jornadas> jornadas = new ArrayList<>();
    try {
        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();

        while (rs.next()) {
            int codigo = rs.getInt("JorCodigo");
            String nombre = rs.getString("JorNombre");

            jornada = new Jornadas();
            jornada.setJorCodigo(codigo);
            jornada.setJorNombre(nombre);

            jornadas.add(jornada);
        }

    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return jornadas;
}


public int insert(Jornadas jornada) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;

    try {
        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_INSERT);

        stmt.setString(1, jornada.getJorNombre());

        rows = stmt.executeUpdate();

    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return rows;
}


public int update(Jornadas jornada) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;

    try {
        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_UPDATE);

        stmt.setString(1, jornada.getJorNombre());
        stmt.setInt(2, jornada.getJorCodigo());

        rows = stmt.executeUpdate();

    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return rows;
}


public int delete(Jornadas jornada) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;

    try {
        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_DELETE);

        stmt.setInt(1, jornada.getJorCodigo());

        rows = stmt.executeUpdate();

    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return rows;
}


public Jornadas query(Jornadas jornada) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {

        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_QUERY);
        stmt.setInt(1, jornada.getJorCodigo());
        rs = stmt.executeQuery();

        while (rs.next()) {

            int codigo = rs.getInt("JorCodigo");
            String nombre = rs.getString("JorNombre");

            jornada.setJorCodigo(codigo);
            jornada.setJorNombre(nombre);
        }

    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return jornada;
}

}

