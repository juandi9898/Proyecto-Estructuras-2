<%-- 
    Document   : paginaVendedor
    Created on : 5/11/2024, 11:39:50 p. m.
    Author     : juand
--%>


<%@page import="java.util.List"%>
<%@page import="mundo.Videojuego"%>
<%@page import="mundo.GestorVideojuego"%>
<%@include file="lib/header1.jsp" %>

<%@include file="lib/navbarVendedor.jsp" %>


<!-- Aqui el datatable con los videojuegois que ha agregado-->







<!-- Aqui el formulario para agregar videojuegos, la parte de editar y eliminar iria con los botones al modal -->



<%     GestorVideojuego gestor = GestorVideojuego.getInstance();
    List<Videojuego> videojuegos = gestor.listarParaVendedor(usuarioN.getIdUsuario());

    //Recordar que usuarioN viene ya por el importe del navbar
    //Es el id del Usuario que esta en la página en este caso el ID del admin
    //usuarioN.getIdUsuario(); 

%>


<!--En el value, va el id que viene del objeto de usuario de rol vendedor que esta agregando-->

<h1 class="text-success"><b>Lista Videojuegos Agregados</b></h1>

<a href="paginaAgregarJuego.jsp" class="btn btn-success" style="margin-left: 150px">Agregar Videojuego</a>

<div class="table-container">
    <table class="table table-striped"  id="myTable" >
        <thead>
            <tr>
                <th scope="col" style="color:blue;">IdJuego</th>
                <th scope="col" style="color:blue;">Titulo</th>
                <th scope="col" style="color:blue;">Descripción</th>
                <th scope="col" style="color:blue;">Genero</th>
                <th scope="col" style="color:blue;">Plataforma</th>
                <th scope="col" style="color:blue;">Precio</th>
                <th scope="col" style="color:blue;">FechaLanzamiento</th>
                <th scope="col" style="color:blue;">Unidades Disponibles</th>
                <th scope="col" style="color:blue;">Acciones</th>

            </tr>
        </thead>
        <tbody>
            <%                  if (videojuegos != null && !videojuegos.isEmpty()) {
                    for (Videojuego videojuego : videojuegos) {
            %>
            <tr>
                <th scope="row"><%= videojuego.getIdVideojuego()%></th>
                <td><%= videojuego.getTitulo()%></td>
                <td><%= videojuego.getDescripcion()%></td>
                <td><%= videojuego.getGenero()%></td>
                <td><%= videojuego.getPlataforma()%></td>
                <td><%= videojuego.getPrecio()%></td>
                <td><%= videojuego.getFechaLanzamiento()%></td>
                <td><%= videojuego.getCantUDisp()%></td>
                <td>
                    <a class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal"
                       data-id="<%= videojuego.getIdVideojuego()%>"
                       data-titulo="<%= videojuego.getTitulo()%>"
                       data-descripcion="<%=videojuego.getDescripcion()%>"
                       data-genero="<%= videojuego.getGenero()%>"
                       data-plataforma="<%= videojuego.getPlataforma()%>"
                       data-precio="<%=videojuego.getPrecio()%>"
                       data-fecha_lan="<%=videojuego.getFechaLanzamiento()%>"
                       data-unidades_d="<%=videojuego.getCantUDisp()%>"
                       ><i class="fa-solid fa-marker"></i></a>
                    <a class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal2"
                       data-id="<%= videojuego.getIdVideojuego()%>"><i class="fa fa-trash"></i></a>

                </td>



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

<!-- Modal Editar-->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h1 class="modal-title fs-5 text-primary" id="exampleModalLabel"><b>Editar Videojuego</b></h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="sv_editarVideojuego" method="POST">

                    <div class="mb-3">
                        <label for="titulo" class="form-label"><strong>Titulo: </strong></label>
                        <input type="text" class="form-control" id="modalTitulo"  name="titulo" placeholder="Titulo" required>
                    </div>
                    <div class="mb-3">
                        <label for="descripcion" class="form-label"><strong>Descripción: </strong></label>
                        <textarea class="form-control" id="modalDescripcion" name="descripcion" placeholder="Descripción" required rows="3"></textarea>
                    </div>

                    <div class="mb-3">
                        <label for="genero" class="form-label"><strong>Género: </strong></label>
                        <input type="text" class="form-control" id="modalGenero"  name="genero" placeholder="Género" required>
                    </div>
                    <div class="mb-3">
                        <label for="plataforma" class="form-label"><strong>Plataforma: </strong></label>
                        <input type="text" class="form-control" id="modalPlataforma"  name="plataforma" placeholder="Plataforma" required>
                    </div>
                    <div class="mb-3">
                        <label for="precio" class="form-label"><strong>Precio: </strong></label>
                        <input type="text" class="form-control" id="modalPrecio"  name="precio" placeholder="Precio" required>
                    </div>
                    <div class="mb-3">
                        <label for="fechaLan" class="form-label"><strong>Fecha Lanzamiento: </strong></label>
                        <input type="date" class="form-control" id="modalFechaLan"  name="fechaLan" placeholder="Fecha Lanzamiento" required>
                    </div>
                    <div class="mb-3">
                        <label for="unidadesD" class="form-label"><strong>Unidades Disponibles: </strong></label>
                        <input type="text" class="form-control" id="modalUnidadesD"  name="unidadesD" placeholder="Unidades Disponibles" required>
                    </div>

                    <input type="hidden" class="form-control" id="modal_Id" name="id" >
                    <input type="hidden" class="form-control" id="modal_IdVendedor" name="idVendedor" value="<%=usuarioN.getIdUsuario()%>" >



                    <!-- Cuando añadimos class btn btn-primary lo que hace es que el enlace se parezca a un boton gracias a bootstrap-->

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-primary">Guardar Cambios</button>
                    </div>


                </form>

            </div>
        </div>
    </div>
</div>


<!--Modal Eliminar-->
<div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5 text-danger" id="exampleModalLabel"><b>Eliminar Videojuego</b></h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <p>¿Estas seguro que deseas eliminar este Usuario?</p>
                <form action="sv_borrarJuego" method="POST">
                    <input type="hidden" class="form-control" id="modal_Id"  name="id">
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-danger">Aceptar</button>
                    </div>
                </form>

            </div>

        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        // Manejar el evento cuando se hace clic en el enlace de la modal
        $('#exampleModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget); // Botón que abrió la modal
            var titulo = button.data('titulo');
            var descripcion = button.data('descripcion');
            var genero = button.data('genero');
            var plataforma = button.data('plataforma');
            var precio = button.data('precio');
            var fechaLan = button.data('fecha_lan');
            var unidadesD = button.data('unidades_d');
       
            var id = button.data('id');


            // Actualizar el contenido de la modal
            var modal = $(this);
            modal.find('#modal_Id').val(id);
            modal.find('#modalTitulo').val(titulo);
            modal.find('#modalDescripcion').val(descripcion);
            modal.find('#modalGenero').val(genero);
            modal.find('#modalPlataforma').val(plataforma);
            modal.find('#modalPrecio').val(precio);
            modal.find('#modalFechaLan').val(fechaLan);
            modal.find('#modalUnidadesD').val(unidadesD);
            
        });
    });

    $('#exampleModal2').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Botón que abrió el modal
        var id = button.data('id');  // Obtiene el correo del botón
        var modal = $(this);
        modal.find('#modal_Id').val(id); // Actualiza el campo oculto
    });


</script>




