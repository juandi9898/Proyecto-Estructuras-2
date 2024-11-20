<%-- 
    Document   : paginaFavoritos
    Created on : 15/11/2024, 12:12:28 a. m.
    Author     : juand
--%>

<%@page import="mundo.Videojuego"%>
<%@page import="java.util.List"%>
<%@page import="mundo.Favorito"%>
<%@page import="mundo.GestorVideojuego"%>
<%@page import="mundo.GestorFavorito"%>
<%@include file="lib/header1.jsp" %>


<%@include file="lib/navbarUsuario.jsp" %>


<%
GestorFavorito gestorFavorito=GestorFavorito.getInstance();

List<Favorito> favoritos=gestorFavorito.listar(usuarioN.getIdUsuario());

GestorVideojuego gestorVideojuego=GestorVideojuego.getInstance();



%>
<h1><b>Favoritos</b></h1>



<div class="container text-center my-4">
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
        
    <%
            for (Favorito favorito : favoritos) {
            
                   Videojuego videojuego=gestorVideojuego.buscarPorId(favorito.getIdJuego());

        %>
        <div class="col">
            <div class="card h-100" style="width: 18rem;">
                <!-- Imagen del videojuego -->
                <img src="https://images.ctfassets.net/rbl6nw8n2c6i/5BNkTpdOEFzF8aAwIZis97/381e3e39db7f34aa0d413ed8295dd051/gaming_article.png?fm=png&fl=png8" class="card-img-top" alt="<%= videojuego.getTitulo() %>">
                
                <div class="card-body">
                    <!-- Título del videojuego -->
                    <h5 class="card-title text-success"><strong><%= videojuego.getTitulo() %></strong></h5>
                    <!-- Descripción del videojuego -->
                    <p class="card-text"><%= videojuego.getGenero() %></p>
                    <!-- Enlace o acción -->
                    <p class="card-text"><strong>$<%= videojuego.getPrecio()%></strong></p>
                    
                    <a href="sv_detalleVideojuego?id=<%= videojuego.getIdVideojuego() %>" class="btn btn-primary">Ver Detalles</a>
                    <br>
                    <br>
                    
                    <a href="sv_borrardeFav?id=<%=videojuego.getIdVideojuego()%>&idUsuario=<%=usuarioN.getIdUsuario()%>" class="text-primary" style="margin-lefr: 50px;"><u>Eliminar de Favoritos</u></a>
                    
                    
                    <!-- -->
                </div>
            </div>
        </div>
        <% } %> 
        
        
        
    
        
    </div>
</div>





<%@include file="lib/footer1.jsp" %>
