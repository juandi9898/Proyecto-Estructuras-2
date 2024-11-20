/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package SERVLETS;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mundo.GestorUsuario;
import mundo.Usuario;

/**
 *
 * @author juand
 */
@WebServlet(name = "sv_registrarUsuario", urlPatterns = {"/sv_registrarUsuario"})
public class sv_registrarUsuario extends HttpServlet {

    GestorUsuario gestorUsuario = GestorUsuario.getInstance();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sv_registrarUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet sv_registrarUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String contraseña = request.getParameter("contraseña");

        int idRol = 3; // Porque inicialmente todos van a ser usuarios al registrarse

        // Encriptamos la contraseña en MD5
        String contraseñaEncriptada = encriptarMD5(contraseña);

        
        Usuario usuarioBuscar=gestorUsuario.buscar(correo);
        
        if(usuarioBuscar==null){
        
                
        Usuario usuarioAgregar = new Usuario();
        usuarioAgregar.setNombre(nombre);
        usuarioAgregar.setApellido(apellido);
        usuarioAgregar.setCorreo(correo);
        usuarioAgregar.setContraseña(contraseñaEncriptada); 
        usuarioAgregar.setIdRol(idRol);

        gestorUsuario.insertar(usuarioAgregar);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else{
            System.out.println("El correo ya esta en uso");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        
        }
        
        
        }
    
    
    
     private String encriptarMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            
            // Completar con ceros si el hash es menor de 32 caracteres
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
