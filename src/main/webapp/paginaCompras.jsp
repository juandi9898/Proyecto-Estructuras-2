    <%-- 
    Document   : paginaCompras
    Created on : 15/11/2024, 12:12:46 a. m.
    Author     : juand
--%>

<%@page import="mundo.Videojuego"%>
<%@page import="mundo.GestorVideojuego"%>
<%@page import="java.util.List"%>
<%@page import="mundo.Venta"%>
<%@page import="mundo.GestorVenta"%>
<%@include file="lib/header1.jsp" %>


<%@include file="lib/navbarUsuario.jsp" %>

                        


<%
GestorVenta gestorVentas=GestorVenta.getInstance();

List<Venta> ventas=gestorVentas.listarParaUsuario(usuarioN.getIdUsuario());

GestorVideojuego gestorVideojuego=GestorVideojuego.getInstance();





%>
<h1><b>Compras</b></h1>



<div class="container text-center my-4">
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
        
    <%
            for (Venta venta : ventas) {
            
                   Videojuego videojuego=gestorVideojuego.buscarPorId(venta.getIdJuego());
                   


        %>
        <div class="col">
            <div class="card h-100" style="width: 18rem;">
                <!-- Imagen del videojuego -->
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1YLw9p4N2cJMtCRVHsror90W-P7UW4gFfbZEcXnF4svPubB2XmFtcCI_tzxXsl_U0ncw&usqp=CAU" class="card-img-top" alt="<%= videojuego.getTitulo() %>">
                
                <div class="card-body">
                    <!-- Título del videojuego -->
                    <h5 class="card-title text-success"><strong><%= videojuego.getTitulo() %></strong></h5>
                    <!-- Descripción del videojuego -->
                    <p class="card-text"><%= videojuego.getGenero() %></p>
                    <!-- Enlace o acción -->
                    <p class="card-text"><strong>$<%= videojuego.getPrecio()*venta.getCantidadVender()%></strong></p>
                   
                    <p class="card-text"><strong>Cantidad Comprada: <%= venta.getCantidadVender()%></strong></p>
                    
                   
                    
                    <!-- -->
                </div>
            </div>
        </div>
        <% } %> 
        
        
        
    
        
    </div>
</div>





<%@include file="lib/footer1.jsp" %>
