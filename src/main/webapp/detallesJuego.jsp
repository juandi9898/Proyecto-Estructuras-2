<%-- 
    Document   : detallesJuego
    Created on : 17/11/2024, 11:37:34 a. m.
    Author     : juand
--%>

<%@page import="mundo.GestorUsuario"%>
<%@page import="mundo.Videojuego"%>
<%@include file="lib/header1.jsp" %>

<!-- Ya que este se repite en todas las paginas que derivan de usuario, seria mejor ponerlo en lib como navbarUsuario.jsp y solo incluirlo como con el header y footer-->
<!-- Asi mismo en las de los otros roles-->


<%@include file="lib/navbarUsuario.jsp" %>

<%
Videojuego juegoDetalles = (Videojuego) request.getAttribute("juegoDetalles");
int unidadesDisponibles = juegoDetalles.getCantUDisp(); // Obtener las unidades disponibles del videojuego
%>

<div class="container my-5">
    <!-- Título del videojuego -->
    <h1 class="text-center text-primary">Detalles del Videojuego</h1>

    <div class="row mt-4 align-items-center">
        <!-- Imagen fija a la izquierda -->
        <div class="col-md-4">
            <img src="https://img.freepik.com/foto-gratis/controlador-sujecion-manos-alto-angulo_23-2149829169.jpg?semt=ais_hybrid" 
                 style="width: 100%; height: auto; max-width: 500px; max-height: 500px;" 
                 class="rounded shadow">
        </div>

        <!-- Información del videojuego a la derecha -->
        <div class="col-md-8">
            <div class="card shadow">
                <div class="card-body">
                    <!-- Formulario para realizar la compra -->
                    <form action="sv_registrarVenta" method="POST">
                        <!-- Campo oculto para el ID del videojuego -->
                        <input type="hidden" id="idVideojuego" name="idVideojuego" value="<%= juegoDetalles.getIdVideojuego() %>">

                        <!-- Campo oculto para el ID del usuario (comprador) -->
                        <input type="hidden" id="idUsuario" name="idUsuario" value="<%= usuarioN.getIdUsuario() %>">

                        <!-- Campo oculto para el ID del vendedor -->
                        <input type="hidden" id="idVendedor" name="idVendedor" value="<%= juegoDetalles.getIdVendedor() %>">

                        <!-- Título -->
                        <h2 class="text-success"><strong>Título: <%= juegoDetalles.getTitulo() %></strong></h2>

                        <!-- Descripción -->
                        <h3><b>Descripción</b></h3>
                        <p><%= juegoDetalles.getDescripcion() %></p>

                        <!-- Género -->
                        <h4><b>Género:</b> <span class="text-secondary"><%= juegoDetalles.getGenero() %></span></h4>

                        <!-- Plataforma -->
                        <h4><b>Plataforma:</b> <span class="text-secondary"><%= juegoDetalles.getPlataforma() %></span></h4>

                        <!-- Precio -->
                        <h4><b>Precio:</b> <span class="text-success">$<%= juegoDetalles.getPrecio() %></span></h4>

                        <!-- Fecha de Lanzamiento -->
                        <h4><b>Fecha de Lanzamiento:</b> <span class="text-secondary"><%= juegoDetalles.getFechaLanzamiento() %></span></h4>

                        <!-- Unidades Disponibles -->
                        <h4><b>Unidades Disponibles:</b> <span class="text-secondary"><%= juegoDetalles.getCantUDisp() %></span></h4>

                        <!-- Vendedor -->
                        <h4><b>Vendedor:</b> 
                            <span class="text-secondary">
                                <%
                                    GestorUsuario gestorUsuario = GestorUsuario.getInstance();
                                    Usuario usuarioBuscar = gestorUsuario.buscaPorId(juegoDetalles.getIdVendedor());
                                    String nombreVendedor = usuarioBuscar != null 
                                        ? usuarioBuscar.getNombre() + " " + usuarioBuscar.getApellido() 
                                        : "Desconocido";
                                    out.print(nombreVendedor);
                                %>
                            </span>
                        </h4>

                        <!-- Input para cantidad a comprar -->
                        <div class="mt-3">
                            <label for="cantidad" class="form-label text-secondary"><b>Cantidad que desea comprar</b></label>
                            <input type="number" class="form-control" id="cantidad" name="cantidad" min="1" max="<%=unidadesDisponibles%>" value="1" required><!-- Da error por netbeans pero si funciona -->
                        </div>

                        <!-- Botón para comprar -->
                        
           
                        <button type="submit" class="btn btn-success mt-4">Comprar</button>
                    </form>
                </div>
            </div>

            <!-- Botón para volver -->
            <div class="text-center mt-4">
                <a href="paginaUsuario.jsp" class="btn btn-secondary">Volver</a>
            </div>
        </div>
    </div>
</div>




<%@include file="lib/footer1.jsp" %>

