<%-- 
    Document   : paginaUsuario
    Created on : 5/11/2024, 11:40:01 p. m.
    Author     : juand
--%>


<%@page import="mundo.GestorVideojuego"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="mundo.Videojuego"%>
<%@include file="lib/header1.jsp" %>

<!-- Ya que este se repite en todas las paginas que derivan de usuario, seria mejor ponerlo en lib como navbarUsuario.jsp y solo incluirlo como con el header y footer-->
<!-- Asi mismo en las de los otros roles-->


<%@include file="lib/navbarUsuario.jsp" %>

<%
    

    GestorVideojuego gestor=GestorVideojuego.getInstance();
    List<Videojuego> videojuegos =gestor.listarParaUsuario();
    
    //Recordar que usuarioN viene ya por el importe del navbar
    //Es el id del Usuario que esta en la página en este caso el ID del admin
    
    //usuarioN.getIdUsuario(); 
    

%>


<!-- Carrusel-->
<div id="carouselExample" class="carousel slide">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://www.neobyte.es/img/cms/BrandLandings/Asus/314/Banner%20Landing%201920x500.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="https://cdn11.bigcommerce.com/s-1lneulkq0h/product_images/uploaded_images/cyberpunk-2077-landing-page-1920-x-500.png" class="d-block w-100" alt="...">
        </div>

        <div class="carousel-item">
            <img src="https://www.clavecd.es/wp-content/uploads/Banniere_Vbucks_Fortnite-ES.jpg" class="d-block w-100" alt="...">
        </div>

    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<!-- Fin Carrusel-->

<div class="container text-center my-4">
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
        
    <%
            for (Videojuego videojuego : videojuegos) {
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
                    
                    <a href="sv_agregarAFav?id=<%=videojuego.getIdVideojuego()%>&idUsuario=<%=usuarioN.getIdUsuario()%>" class="text-primary" style="margin-lefr: 50px;"><u>Añadir a Favoritos</u></a>
                    
                    
                    <!-- -->
                </div>
            </div>
        </div>
        <% } %> 
        
        
        
    
        
    </div>
</div>

<!-- Cards -->










<%@include file="lib/footer1.jsp" %>
