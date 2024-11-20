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
public class GestorFavorito {
     PreparedStatement ps;
    ResultSet rs;

    private GestorFavorito() {

    }

    private static GestorFavorito instance;

    public static synchronized GestorFavorito getInstance() {
        if (instance == null) {
            instance = new GestorFavorito();
        }
        return instance;
    }
    
    
      public ArrayList<Favorito> listar(int usuarioId) {
        Connection conexion = obtenerConexion();
        ArrayList<Favorito> listaFavoritos = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("Select * from favoritos where usuario_id=?");
            ps.setInt(1,usuarioId);
            rs = ps.executeQuery();

            while (rs.next()) {
                Favorito favorito=new Favorito();
                
                favorito.setIdUsuario(rs.getInt("usuario_id"));
                favorito.setIdJuego(rs.getInt("videojuego_id"));
                
                
                listaFavoritos.add(favorito);
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
        return listaFavoritos;
    }

  
 public boolean agregarAFavoritos(int usuarioId, int videojuegoId) {
        Connection conexion = obtenerConexion();
        try {
            ps = conexion.prepareStatement("INSERT INTO favoritos (usuario_id, videojuego_id) VALUES (?, ?)");
            ps.setInt(1, usuarioId);
            ps.setInt(2, videojuegoId);

            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (Exception ex) {
            System.err.println("Error al agregar a favoritos: " + ex);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error al cerrar la conexión: " + ex);
            }
        }
    }     
 
  public boolean eliminarDeFavoritos(int usuarioId, int videojuegoId) {
        Connection conexion = obtenerConexion();
        try {
            ps = conexion.prepareStatement("DELETE FROM favoritos WHERE usuario_id = ? AND videojuego_id = ?");
            ps.setInt(1, usuarioId);
            ps.setInt(2, videojuegoId);

            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (Exception ex) {
            System.err.println("Error al eliminar de favoritos: " + ex);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error al cerrar la conexión: " + ex);
            }
        }
    }


  
  public ArrayList<Favorito> listarFavoritosPorUsuario(int usuarioId) {
        Connection conexion = obtenerConexion();
        ArrayList<Favorito> listaFavoritos = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("SELECT * FROM favoritos WHERE usuario_id = ?");
            ps.setInt(1, usuarioId);

            rs = ps.executeQuery();
            while (rs.next()) {
                Favorito favorito = new Favorito();
                favorito.setIdUsuario(rs.getInt("usuario_id"));
                favorito.setIdJuego(rs.getInt("videojuego_id"));

                listaFavoritos.add(favorito);
            }
        } catch (Exception ex) {
            System.err.println("Error al listar favoritos: " + ex);
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error al cerrar la conexión: " + ex);
            }
        }
        return listaFavoritos;
    }



    public boolean existeEnFavoritos(int usuarioId, int videojuegoId) {
        Connection conexion = obtenerConexion();
        try {
            ps = conexion.prepareStatement("SELECT * FROM favoritos WHERE usuario_id = ? AND videojuego_id = ?");
            ps.setInt(1, usuarioId);
            ps.setInt(2, videojuegoId);

            rs = ps.executeQuery();
            return rs.next(); // Retorna true si hay resultados, false si no
        } catch (Exception ex) {
            System.err.println("Error al verificar favoritos: " + ex);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error al cerrar la conexión: " + ex);
            }
        }
    }


      
    
}
