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
public class GestorUsuario {

    PreparedStatement ps;
    ResultSet rs;

    private GestorUsuario() {

    }

    private static GestorUsuario instance;

    public static synchronized GestorUsuario getInstance() {
        if (instance == null) {
            instance = new GestorUsuario();
        }
        return instance;
    }

    public ArrayList<Usuario> listar() {
        Connection conexion = obtenerConexion();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("Select * from usuario where idRol!=1");
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContraseña(rs.getString("contrasena"));
                usuario.setIdRol(rs.getInt("idRol"));
                listaUsuarios.add(usuario);
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
        return listaUsuarios;
    }

    public boolean insertar(Usuario usuario) {
        Connection conexion = obtenerConexion();
        try {
            ps = conexion.prepareStatement("INSERT INTO usuario(nombre, apellido, correo, contrasena, idRol) VALUES(?,?,?,?,?) ");

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getContraseña());
            ps.setInt(5, usuario.getIdRol());
            

            int resultado = ps.executeUpdate();

            return resultado > 0;

        } catch (Exception ex) {
            System.err.println("Error al insertar Usuario: " + ex);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
    }
    
    
    
    //Seguir modificando metodos pero para Usuario
    
    
    
    

    // Método para buscar un artículo por su correo y seria hacerlo unique o no se
    
    public Usuario buscar(String correo) {
        Connection conexion = obtenerConexion();
        try {
            ps = conexion.prepareStatement("select * from usuario where correo=?");
            ps.setString(1, correo);

            rs = ps.executeQuery();

            if (rs.next()) {
                Usuario usuarioSeleccionado = new Usuario();
                usuarioSeleccionado.setIdUsuario(rs.getInt("idUsuario"));
                usuarioSeleccionado.setNombre(rs.getString("nombre"));
                usuarioSeleccionado.setApellido(rs.getString("apellido"));
                usuarioSeleccionado.setCorreo(rs.getString("correo"));
                usuarioSeleccionado.setContraseña(rs.getString("contrasena"));
                usuarioSeleccionado.setIdRol(rs.getInt("idRol"));
                return usuarioSeleccionado;
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
    
    
     public Usuario buscaPorId(int idUsuario) {
        Connection conexion = obtenerConexion();
        try {
            ps = conexion.prepareStatement("select * from usuario where idUsuario=?");
            ps.setInt(1, idUsuario);

            rs = ps.executeQuery();

            if (rs.next()) {
                Usuario usuarioSeleccionado = new Usuario();
                usuarioSeleccionado.setIdUsuario(rs.getInt("idUsuario"));
                usuarioSeleccionado.setNombre(rs.getString("nombre"));
                usuarioSeleccionado.setApellido(rs.getString("apellido"));
                usuarioSeleccionado.setCorreo(rs.getString("correo"));
                usuarioSeleccionado.setContraseña(rs.getString("contrasena"));
                usuarioSeleccionado.setIdRol(rs.getInt("idRol"));
                return usuarioSeleccionado;
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
    
    

    public boolean modificar(Usuario usuario) {
        Connection conexion = obtenerConexion();
        try {
            ps = conexion.prepareStatement("update usuario set nombre=?, apellido=?,correo=?,contrasena=?, idRol=? where idUsuario=?");
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getContraseña());
            ps.setInt(5, usuario.getIdRol());
            ps.setInt(6, usuario.getIdUsuario());

            int resultado = ps.executeUpdate();

            return resultado > 0;

        } catch (Exception ex) {
            System.err.println("Error al modificar usuario: " + ex);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
    }

    public boolean eliminar(int idUsuario) {
        Connection conexion = obtenerConexion();
        try {
            ps = conexion.prepareStatement("delete from usuario where idUsuario=? ");
            ps.setInt(1, idUsuario);

            int resultado = ps.executeUpdate();

            return resultado > 0;

        } catch (Exception ex) {
            System.err.println("Error al eliminar usuario: " + ex);
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
