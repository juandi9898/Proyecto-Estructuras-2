/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package SERVLETS;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mundo.GestorVideojuego;
import mundo.Videojuego;

/**
 *
 * @author juand
 */
@WebServlet(name = "sv_detalleVideojuego", urlPatterns = {"/sv_detalleVideojuego"})
public class sv_detalleVideojuego extends HttpServlet {

    GestorVideojuego gestor = GestorVideojuego.getInstance();

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
            out.println("<title>Servlet sv_detalleVideojuego</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet sv_detalleVideojuego at " + request.getContextPath() + "</h1>");
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

        String id = request.getParameter("id");

        Videojuego juegoDetalles = gestor.buscarPorId(Integer.parseInt(id));

        //Comprobando si llegan los datos
        System.out.println("Id: " + juegoDetalles.getIdVideojuego());
        System.out.println("Titulo: " + juegoDetalles.getTitulo());
        System.out.println("Descripcion: " + juegoDetalles.getDescripcion());
        System.out.println("Genero: " + juegoDetalles.getGenero());
        System.out.println("Plataforma: "+juegoDetalles.getPlataforma());
        System.out.println("Precio: "+juegoDetalles.getPrecio());
        System.out.println("Fecha Lanzamiento: "+juegoDetalles.getFechaLanzamiento());
        System.out.println("Unidades Disponibles: "+juegoDetalles.getCantUDisp());
        System.out.println("Id Vendedor: "+juegoDetalles.getIdVendedor());

        
        request.setAttribute("juegoDetalles", juegoDetalles);
        request.getRequestDispatcher("detallesJuego.jsp").forward(request, response);
        
        
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
        processRequest(request, response);
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
