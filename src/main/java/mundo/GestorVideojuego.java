/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import static mundo.Conexion.obtenerConexion;


public class GestorVideojuego {
       PreparedStatement ps;
    ResultSet rs;

    private GestorVideojuego() {

    }

    private static GestorVideojuego instance;

    public static synchronized GestorVideojuego getInstance() {
        if (instance == null) {
            instance = new GestorVideojuego();
        }
        return instance;
    }

    
     public ArrayList<Videojuego> listarParaVendedor(int idVendedor) {
        Connection conexion = obtenerConexion();
        ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("Select * from videojuegos where idVendedor=?");
            ps.setInt(1, idVendedor);
            
            rs = ps.executeQuery();

            while (rs.next()) {
                Videojuego videojuego = new Videojuego();
                videojuego.setIdVideojuego(rs.getInt("id"));
                videojuego.setTitulo(rs.getString("titulo"));
                videojuego.setDescripcion(rs.getString("descripcion"));
                videojuego.setGenero(rs.getString("genero"));
                videojuego.setPlataforma(rs.getString("plataforma"));
                videojuego.setPrecio(rs.getDouble("precio"));
                videojuego.setFechaLanzamiento(rs.getDate("fecha_lanzamiento"));
                videojuego.setCantUDisp(rs.getInt("unidades_disponibles"));
                videojuego.setIdVendedor(idVendedor);
                
        
                listaVideojuegos.add(videojuego);
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
        return listaVideojuegos;
    }
    
    
    
    
    
    public ArrayList<Videojuego> listarParaUsuario() {
        Connection conexion = obtenerConexion();
        ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("Select * from videojuegos");
            rs = ps.executeQuery();

            while (rs.next()) {
                Videojuego videojuego = new Videojuego();
                videojuego.setIdVideojuego(rs.getInt("id"));
                videojuego.setTitulo(rs.getString("titulo"));
                videojuego.setDescripcion(rs.getString("descripcion"));
                videojuego.setGenero(rs.getString("genero"));
                videojuego.setPlataforma(rs.getString("plataforma"));
                videojuego.setPrecio(rs.getDouble("precio"));
                videojuego.setFechaLanzamiento(rs.getDate("fecha_lanzamiento"));
                videojuego.setCantUDisp(rs.getInt("unidades_disponibles"));
                videojuego.setIdVendedor(rs.getInt("idVendedor"));
                
        
                listaVideojuegos.add(videojuego);
            }

        } catch (Exception ex) {
            System.err.println("Error al listar usuarios: " + ex);
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        return listaVideojuegos;
    }

    public boolean insertar(Videojuego videojuego) {
        Connection conexion = obtenerConexion();
        try {
            ps = conexion.prepareStatement("INSERT INTO videojuegos (titulo, descripcion, genero, plataforma, precio, fecha_lanzamiento, unidades_disponibles, idVendedor)  VALUES (?, ?, ?,?, ?, ?, ?, ?)");
            
            
            ps.setString(1, videojuego.getTitulo());
            ps.setString(2, videojuego.getDescripcion());
            ps.setString(3, videojuego.getGenero());
            ps.setString(4,videojuego.getPlataforma());
            ps.setDouble(5, videojuego.getPrecio());
            ps.setDate(6, videojuego.getFechaLanzamiento());
            ps.setInt(7, videojuego.getCantUDisp());
            ps.setInt(8, videojuego.getIdVendedor());
            
            
            
            
            /*ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getContraseña());
            ps.setInt(5, usuario.getIdRol());
            */

            int resultado = ps.executeUpdate();

            return resultado > 0;

        } catch (Exception ex) {
            System.err.println("Error al insertar Videojuego: " + ex);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
    }
    
       public boolean eliminar(int idVideojuego) {
        Connection conexion = obtenerConexion();
        try {
            ps = conexion.prepareStatement("delete from videojuegos where id=? ");
            ps.setInt(1, idVideojuego);

            int resultado = ps.executeUpdate();

            return resultado > 0;

        } catch (Exception ex) {
            System.err.println("Error al eliminar videojuego: " + ex);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
    }
       
  public Videojuego buscarPorId(int idVideojuego) {
        Connection conexion = obtenerConexion();
        try {
            ps = conexion.prepareStatement("select * from videojuegos where id=?");
            ps.setInt(1, idVideojuego);

            rs = ps.executeQuery();

            if (rs.next()) {
               Videojuego videojuego = new Videojuego();
                videojuego.setIdVideojuego(rs.getInt("id"));
                videojuego.setTitulo(rs.getString("titulo"));
                videojuego.setDescripcion(rs.getString("descripcion"));
                videojuego.setGenero(rs.getString("genero"));
                videojuego.setPlataforma(rs.getString("plataforma"));
                videojuego.setPrecio(rs.getDouble("precio"));
                videojuego.setFechaLanzamiento(rs.getDate("fecha_lanzamiento"));
                videojuego.setCantUDisp(rs.getInt("unidades_disponibles"));
                videojuego.setIdVendedor(rs.getInt("idVendedor"));
                return videojuego;
            } else {
                return null;
            }

        } catch (Exception ex) {
            System.err.println("Error al buscar usuario: " + ex);

        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        return null;
    }       
       
        public boolean modificar(Videojuego videojuego) {
        Connection conexion = obtenerConexion();
        try {
            ps = conexion.prepareStatement("call actualizar_videojuego(?,?,?,?,?,?,?,?,?)");
            
            
            
            ps.setInt(1, videojuego.getIdVideojuego());
            ps.setString(2, videojuego.getTitulo());
            ps.setString(3, videojuego.getDescripcion());
            ps.setString(4, videojuego.getGenero());
            ps.setString(5, videojuego.getPlataforma());
            ps.setDouble(6, videojuego.getPrecio());
            ps.setDate(7,videojuego.getFechaLanzamiento());
            ps.setInt(8, videojuego.getCantUDisp());
            ps.setInt(9, videojuego.getIdVendedor());
            int resultado = ps.executeUpdate();

            return resultado > 0;

        } catch (Exception ex) {
            System.err.println("Error al modificar videojuego: " + ex);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
    }
    
}
