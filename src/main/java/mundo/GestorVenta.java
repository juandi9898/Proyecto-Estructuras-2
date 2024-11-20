/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static mundo.Conexion.obtenerConexion;

/**
 *
 * @author juand
 */
public class GestorVenta {


    PreparedStatement ps;
    ResultSet rs;

    private GestorVenta() {}

    private static GestorVenta instance;

    public static synchronized GestorVenta getInstance() {
        if (instance == null) {
            instance = new GestorVenta();
        }
        return instance;
    }

    
      public ArrayList<Venta> listarParaAdmin() {
        Connection conexion = obtenerConexion();
        ArrayList<Venta> listaVentas = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT * FROM historial_ventas");
            
            rs = ps.executeQuery();

            while (rs.next()) {
               
                Venta venta=new Venta();
                venta.setIdVenta(rs.getInt("id"));
                venta.setIdUsuario(rs.getInt("usuario_id"));
                venta.setIdJuego(rs.getInt("videojuego_id"));
                venta.setFechaVenta(rs.getDate("fecha_venta"));
                venta.setCantidadVender(rs.getInt("cantidad"));
                venta.setIdVendedor(rs.getInt("vendedor_id"));
                
                
        
               listaVentas.add(venta);
            }

        } catch (Exception ex) {
            System.err.println("Error al listar videojuegos: " + ex);
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        return listaVentas;
    }
    
    public ArrayList<Venta> listarParaVendedor(int idVendedor) {
        Connection conexion = obtenerConexion();
        ArrayList<Venta> listaVentas = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT * FROM historial_ventas WHERE vendedor_id=?");
            ps.setInt(1, idVendedor);
            
            rs = ps.executeQuery();

            while (rs.next()) {
               
                Venta venta=new Venta();
                venta.setIdVenta(rs.getInt("id"));
                venta.setIdUsuario(rs.getInt("usuario_id"));
                venta.setIdJuego(rs.getInt("videojuego_id"));
                venta.setFechaVenta(rs.getDate("fecha_venta"));
                venta.setCantidadVender(rs.getInt("cantidad"));
                venta.setIdVendedor(rs.getInt("vendedor_id"));
                
                
        
               listaVentas.add(venta);
            }

        } catch (Exception ex) {
            System.err.println("Error al listar videojuegos: " + ex);
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        return listaVentas;
    }
    
    
    
    public ArrayList<Venta> listarParaUsuario(int usuarioId) {
        Connection conexion = obtenerConexion();
        ArrayList<Venta> listaVentas = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT * FROM historial_ventas WHERE usuario_id=?");
            ps.setInt(1, usuarioId);
            rs = ps.executeQuery();

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getInt("id"));
                venta.setIdUsuario(rs.getInt("usuario_id"));
                venta.setIdJuego(rs.getInt("videojuego_id"));
                venta.setCantidadVender(rs.getInt("cantidad"));
                venta.setFechaVenta(rs.getDate("fecha_venta"));
                venta.setIdVendedor(rs.getInt("vendedor_id"));

                listaVentas.add(venta);
            }
        } catch (Exception ex) {
            System.err.println("Error al listar ventas: " + ex);
        } finally {
            try {
                if (conexion != null) conexion.close();
            } catch (Exception ex) {
                System.err.println("Error al cerrar la conexión: " + ex);
            }
        }
        return listaVentas;
    }

    public boolean insertar(Venta venta) {
        Connection conexion = obtenerConexion();
        try {
            ps = conexion.prepareStatement("CALL registrar_venta(?,?,?,?)");
            ps.setInt(1, venta.getIdUsuario());
            ps.setInt(2, venta.getIdJuego());
            ps.setInt(3, venta.getCantidadVender());
            ps.setInt(4, venta.getIdVendedor());

            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (Exception ex) {
            System.err.println("Error al insertar Venta: " + ex);
            return false;
        } finally {
            try {
                if (conexion != null) conexion.close();
            } catch (Exception ex) {
                System.err.println("Error al cerrar la conexión: " + ex);
            }
        }
    }
    
    
}

    

