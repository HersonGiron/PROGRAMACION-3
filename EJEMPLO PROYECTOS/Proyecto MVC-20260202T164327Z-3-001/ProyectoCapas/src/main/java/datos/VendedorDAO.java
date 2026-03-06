/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class VendedorDAO {

    private static final String SQL_SELECT = "SELECT id_vendedor, nombrevendedor, direvendedor FROM vendedor";
    private static final String SQL_INSERT = "INSERT INTO vendedor(nombrevendedor, direvendedor) VALUES(?, ?)"; //?? son comodines
    private static final String SQL_UPDATE = "UPDATE vendedor SET nombrevendedor=?, direvendedor=? WHERE idvendedor = ?";
    private static final String SQL_DELETE = "DELETE FROM vendedor WHERE idvendedor=?";
    private static final String SQL_QUERY = "SELECT id_vendedor, nombrevendedor, direvendedor FROM vendedor WHERE id_vendedor = ?";

    public List<Vendedor> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vendedor vendedor = null;
        List<Vendedor> vendedores = new ArrayList<Vendedor>();
        
        try {//excepciones
            conn = Conexion.getConnection(); //abre la base de datos
            stmt = conn.prepareStatement(SQL_SELECT); //prepara la instruccion que sera ejecutada en la bd
            rs = stmt.executeQuery(); //record set, conjunto de datos proveniente BD
            while (rs.next()) {
                int id_vendedor = rs.getInt("id_vendedor");
                String nombre = rs.getString("nombrevendedor");
                String direccion = rs.getString("direvendedor");
                
                vendedor = new Vendedor(); //crea un nuevo objeto
                //agrega todo al objeto
                vendedor.setId_vendedor(id_vendedor);
                vendedor.setNombreVendedor(nombre);
                vendedor.setDireVendedor(direccion);
                //se envia el objeto
                vendedores.add(vendedor);
            }

        } catch (SQLException ex) { //excepciones
            ex.printStackTrace(System.out);
        } finally {
            //cierra las conexiones
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return vendedores;
    }

    public int insert(Vendedor vendedor) {
        Connection conn = null; 
        PreparedStatement stmt = null; 
        int rows = 0;
        try {
            conn = Conexion.getConnection();//se crea la conexione
            stmt = conn.prepareStatement(SQL_INSERT);//preparo el comando
            stmt.setString(1, vendedor.getNombreVendedor()); //son para colocarle info stmt
            stmt.setString(2, vendedor.getDireVendedor());  //son para colocarle info stmt


            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate(); //ejecuta insert y coloca registro en BD
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Vendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        //excepcion
        try {
            conn = Conexion.getConnection(); //abre la base de datos
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE); //prepara el comando
            //actualizaciones de java a stmt
            stmt.setString(1, vendedor.getNombreVendedor());
            stmt.setString(2, vendedor.getDireVendedor());
            stmt.setInt(3, vendedor.getId_vendedor());

            rows = stmt.executeUpdate(); //ejecuta update y coloca registro en BD
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) { //excepcion
            ex.printStackTrace(System.out);
        } finally {
            //cierra las conexiones
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Vendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        //excepciones
        try {
            conn = Conexion.getConnection(); //abre la conexion a BD
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE); //prepara el comando delete
            stmt.setInt(1, vendedor.getId_vendedor()); //determino el codigo a borrar en bd
            rows = stmt.executeUpdate(); //actualizo la base de datos, pero en la actualizacion se borro datos
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //cerro conexiones
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Vendedor query(Vendedor vendedor) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Vendedor> vendedores = new ArrayList<Vendedor>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();//abre la conexion a BD
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY); //prepara el comando query
            stmt.setInt(1, vendedor.getId_vendedor());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_vendedor = rs.getInt("id_vendedor");
                String nombre = rs.getString("nombrevendedor");
                String direccion = rs.getString("direvendedor");
                
                vendedor = new Vendedor();
                vendedor.setId_vendedor(id_vendedor);
                vendedor.setNombreVendedor(nombre);
                vendedor.setDireVendedor(direccion);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return vendedor;
    }
        
}
