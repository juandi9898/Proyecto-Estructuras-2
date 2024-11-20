/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package SERVLETS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
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
@WebServlet(name = "sv_editarVideojuego", urlPatterns = {"/sv_editarVideojuego"})
public class sv_editarVideojuego extends HttpServlet {

    
    GestorVideojuego gestor=GestorVideojuego.getInstance();
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
            out.println("<title>Servlet sv_editarVideojuego</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet sv_editarVideojuego at " + request.getContextPath() + "</h1>");
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

        String id = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String genero = request.getParameter("genero");
        String plataforma = request.getParameter("plataforma");
        String precio = request.getParameter("precio");
        String fechaLan = request.getParameter("fechaLan");
        String unidadesD = request.getParameter("unidadesD");
        String idVendedor = request.getParameter("idVendedor");

        //Verificando que llegan los datos
        /*System.out.println("IdVideojuego: "+id);
        System.out.println("Titulo: "+titulo);
        System.out.println("Descripcion: "+descripcion);
        System.out.println("Genero: "+genero);
        System.out.println("Plataforma: "+plataforma);
        System.out.println("Precio: "+precio);
        System.out.println("Fecha Lanzamiento: "+fechaLan);
        System.out.println("Unidades Disponibles: "+unidadesD);
        System.out.println("Id Vendedor: "+idVendedor);
        */
        
        Videojuego juegoEditar=new Videojuego();
        
        
           
           
          
      
         
            
    
     
        
        
        juegoEditar.setIdVideojuego(Integer.parseInt(id));
        juegoEditar.setTitulo(titulo);
        juegoEditar.setDescripcion(descripcion);
        juegoEditar.setGenero(genero);
        juegoEditar.setPlataforma(plataforma);
        juegoEditar.setPrecio(Double.parseDouble(precio));
        Date fechaBien=Date.valueOf(fechaLan);
        juegoEditar.setFechaLanzamiento(fechaBien);
        juegoEditar.setCantUDisp(Integer.parseInt(unidadesD));
        juegoEditar.setIdVendedor(Integer.parseInt(idVendedor));
        
        
        
        gestor.modificar(juegoEditar);
        
        request.getRequestDispatcher("paginaVendedor.jsp").forward(request, response);
        
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
