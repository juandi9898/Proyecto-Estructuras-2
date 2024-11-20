/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL="jdbc:mysql://localhost:3306/ventas?autoReconnet=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "072005juand";

    
    
    static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Conexion() {
        
    }

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver de MySQL
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            if (conexion != null) {

                System.out.println("Conexión exitosa a la base de datos");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }
}
