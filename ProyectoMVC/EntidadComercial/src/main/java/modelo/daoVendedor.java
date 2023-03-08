/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsVendedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoVendedor {

    private static final String SQL_SELECT = "SELECT codigo_vendedor, nombre_vendedor, direccion_vendedor, telefono_vendedor, nit_vendedor, estatus_vendedor FROM vendedores";
    private static final String SQL_INSERT = "INSERT INTO vendedores(nombre_vendedor, direccion_vendedor, telefono_vendedor, nit_vendedor, estatus_vendedor) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE vendedores SET nombre_vendedor=?, direccion_vendedor=?, telefono_vendedor=?, nit_vendedor=?, estatus_vendedor=? WHERE codigo_vendedor = ?";
    private static final String SQL_DELETE = "DELETE FROM vendedores WHERE codigo_vendedor=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_vendedor, nombre_vendedor, direccion_vendedor, telefono_vendedor, nit_vendedor, estatus_vendedor FROM vendedores WHERE nommbre_vendedor = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_vendedor, nombre_vendedor, direccion_vendedor, telefono_vendedor, nit_vendedor, estatus_vendedor FROM vendedores WHERE codigo_vendedor = ?";    

    public List<clsVendedor> consultaVendedor() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsVendedor> vendedor = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_vendedor");
                String nombre = rs.getString("nombre_vendedor");
                String direccion = rs.getString("direccion_vendedor");
                int telefono = rs.getInt("telefono_vendedor");
                int nit = rs.getInt("nit_vendedor");
                int estatus = rs.getInt("estatus_vendedor");
                //clsVendedor vendedor = new clsVendedor();
                //vendedor.setcodigo_vendedor(id);
                //vendedor.nombre_vendedor(nombre);
                //vendedor.setContrasenaUsuario(contrasena);
                //vendedor.add(vendedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return vendedor;
    }

    public int ingresaVendedor(clsVendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vendedor.getnombre_vendedor());
            stmt.setString(2, vendedor.getdireccion_vendedor());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaVendedor(clsVendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vendedor.getnombre_vendedor());
            stmt.setString(2, vendedor.getdireccion_vendedor());
            stmt.setInt(3, vendedor.getcodigo_vendedor());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarVendedor(clsVendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vendedor.getcodigo_vendedor());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsVendedor consultaVendedorPorNombre(clsVendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + vendedor);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, vendedor.getnombre_vendedor());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_vendedor");
                String nombre = rs.getString("nombre_vendedor");
                String direccion = rs.getString("direccion_vendedor");

                //usuario = new clsUsuario();
                vendedor.setcodigo_vendedor(id);
                vendedor.setnombre_vendedor(nombre);
                vendedor.setdireccion_vendedor(direccion);
                System.out.println(" registro consultado: " + vendedor);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return vendedor;
    }
    public clsVendedor consultaVendedorPorId(clsVendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + vendedor);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, vendedor.getcodigo_vendedor());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_vendedor");
                String nombre = rs.getString("nombre_vendedor");
                String direccion = rs.getString("direccion_vendedor");

                //usuario = new clsUsuario();
                vendedor.setcodigo_vendedor(id);
                vendedor.setnombre_vendedor(nombre);
                vendedor.setdireccion_vendedor(direccion
                );
                System.out.println(" registro consultado: " + vendedor);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return vendedor;
    }    

    public clsVendedor consultaVendedorPorNombre(Object vendedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
