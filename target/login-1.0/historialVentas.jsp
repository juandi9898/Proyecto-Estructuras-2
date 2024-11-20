<%-- 
    Document   : historialVentas
    Created on : 12/11/2024, 7:27:07 p. m.
    Author     : juand
--%>

<%@page import="mundo.Videojuego"%>
<%@page import="mundo.GestorVenta"%>
<%@page import="mundo.GestorVideojuego"%>
<%@page import="mundo.Venta"%>
<%@page import="java.util.List"%>
<%@page import="mundo.Usuario"%>
<%@page import="mundo.GestorUsuario"%>
<%@include file="lib/header1.jsp" %>



<%@include file="lib/navbarAdmin.jsp" %>




<%     
    GestorVenta gestorVentas = GestorVenta.getInstance();
    List<Venta> ventas = gestorVentas.listarParaAdmin();
    GestorUsuario gestorUsuario = GestorUsuario.getInstance();
    GestorVideojuego gestorJuego = GestorVideojuego.getInstance();

    //Recordar que usuarioN viene ya por el importe del navbar
    //Es el id del Usuario que esta en la página en este caso el ID del admin
    //usuarioN.getIdUsuario(); 

%>


<!--En el value, va el id que viene del objeto de usuario de rol vendedor que esta agregando-->

<h1 class="text-success"><b>Historial Ventas Global</b></h1>


<div class="table-container">
    <table class="table table-striped"  id="myTable" >
        <thead>
            <tr>
                <th scope="col" style="color:blue;">CorreoVendedor</th>
                <th scope="col" style="color:blue;">Correo Usuario</th>
                <th scope="col" style="color:blue;">Videojuego</th>
                <th scope="col" style="color:blue;">Cantidad</th>
                <th scope="col" style="color:blue;">PrecioUnidad</th>
                <th scope="col" style="color:blue;">Precio Total</th>
                <th scope="col" style="color:blue;">FechaVenta</th>
            </tr>
        </thead>
        <tbody>
            <%                  if (ventas != null && !ventas.isEmpty()) {
                    for (Venta venta : ventas) {

                        Usuario usuarioComp = gestorUsuario.buscaPorId(venta.getIdUsuario());
                        Usuario vendedor=gestorUsuario.buscaPorId(venta.getIdVendedor());
                        Videojuego videojuego = gestorJuego.buscarPorId(venta.getIdJuego());

            %>
            <tr>
                <th scope="row"><%= vendedor.getCorreo()%></th>
                <td><%= usuarioComp.getCorreo()%></td>
                <td><%= videojuego.getTitulo()%></td>
                <td><%= venta.getCantidadVender()%></td>
                <td>$<%=videojuego.getPrecio()%></td>
                <td>$<%= videojuego.getPrecio() * venta.getCantidadVender()%></td><!--Multiplicamos el precio del juego por la cantidad de la venta para sacar el precio total-->
                <td><%= venta.getFecha_venta()%></td>




                <%
                        }
                    } else {
                        out.println("<tr><td colspan='5'>No se encontraron videojuegos.</td></tr>");
                    }%>
        </tbody>
    </table>
</div>
<br> 









<%@include file="lib/footer1.jsp" %>
