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
import javax.servlet.http.HttpSession;
import mundo.GestorUsuario;
import mundo.Usuario;

/**
 *
 * @author juand
 */
@WebServlet(name = "sv_validarUsuario", urlPatterns = {"/sv_validarUsuario"})
public class sv_validarUsuario extends HttpServlet {

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
            out.println("<title>Servlet sv_validarUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet sv_validarUsuario at " + request.getContextPath() + "</h1>");
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

        HttpSession session = request.getSession(false); // Obtiene la sesión si existe
        if (session != null) {
            session.invalidate(); // Invalida la sesión
            System.out.println("Sesión cerrada correctamente.");
        }
        
        response.sendRedirect("index.jsp"); // Redirige a la página de inicio

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

        String correo = request.getParameter("correo");
        String contraseña = request.getParameter("contraseña");

        System.out.println("Correo: " + correo);
        System.out.println("Contraseña: " + contraseña);

        String contraseñaEncriptada = encriptarMD5(contraseña);//Encriptamos la contraseña para hacer la comparación con la que esta en la bd

        Usuario usuarioBuscar = gestorUsuario.buscar(correo);

        if (usuarioBuscar == null) {
            System.out.println("No se encontró el Usuario en la BD");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            if (usuarioBuscar.getCorreo().equals(correo) && usuarioBuscar.getContraseña().equals(contraseñaEncriptada)) {
                int idRol = usuarioBuscar.getIdRol();

                //Aqui podria ser pasar como atributo de la sesion o asi, el usuario que entro para poder eso en la parte de perfil en las páginas, seria chevere
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuarioBuscar);//Se manda el objeto como atributo de la Sesión para usarlo en la parte del nombre del Usuario y el idVendedor entre otros, como para tener disponible

                switch (idRol) {
                    case 1:
                        System.out.println("Eres el admin, bienvenido");
                        request.getRequestDispatcher("paginaAdmin.jsp").forward(request, response);
                        break;
                    case 2:
                        System.out.println("Eres el vendedor, bienvenido");
                        request.getRequestDispatcher("paginaVendedor.jsp").forward(request, response);
                        break;
                    case 3:
                        System.out.println("Eres un usuario, bienvenido");
                        request.getRequestDispatcher("paginaUsuario.jsp").forward(request, response);
                        break;

                }

            } else {
                System.out.println("Correo o contraseña incorrectos");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

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
