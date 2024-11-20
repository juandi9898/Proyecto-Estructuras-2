<%-- 
    Document   : paginaAdmin
    Created on : 5/11/2024, 11:38:54 p. m.
    Author     : juand
--%>

<%@page import="java.util.List"%>
<%@page import="mundo.Usuario"%>
<%@page import="mundo.GestorUsuario"%>
<%@include file="lib/header1.jsp" %>

<%@include file="lib/navbarAdmin.jsp" %>

  


             
              
              

<%
    
    GestorUsuario gestor=GestorUsuario.getInstance();
    List<Usuario> usuarios =gestor.listar();
    
    //Recordar que usuarioN viene ya por el importe del navbar
    //Es el id del Usuario que esta en la página en este caso el ID del admin
    
    //usuarioN.getIdUsuario(); 
    
    

%>
 

<!-- Carrusel-->
<div id="carouselExample" class="carousel slide">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://cloud.softline.ru/files/resized/slides/istock-1357661160.1980x500.center.center.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="https://www.azienda-digitale.it/wp-content/uploads/2022/12/conservazione-digitale-1980x500.jpg" class="d-block w-100" alt="...">
        </div>

        <div class="carousel-item">
            <img src="https://www.professionista-digitale.it/wp-content/uploads/cambiamento-consulente-lavoro-1980x500.png" class="d-block w-100" alt="...">
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




<h1 class="text-center text-primary"><b>Lista de Usuarios</b></h1>

<div class="table-container">
    <table class="table table-striped"  id="myTable" >
        <thead>
            <tr>
            <th scope="col" >Id</th>
            <th scope="col">Nombre</th>
            <th scope="col">Apellido</th>
            <th scope="col">Correo</th>
            <th scope="col">Contraseña</th>
            <th scope="col">idRol</th>
            <th scope="col">Acciones</th>

            </tr>
        </thead>
        <tbody>
            <%                  if (usuarios != null && !usuarios.isEmpty()) {
                    for (Usuario usuario : usuarios) {
            %>
            <tr>
            <th scope="row"><%= usuario.getIdUsuario()%></th>
            <td><%= usuario.getNombre()%></td>
            <td><%= usuario.getApellido()%></td>
            <td><%= usuario.getCorreo()%></td>
            <td><%= usuario.getContraseña()%></td>
            <td><%= usuario.getIdRol()%></td>
             <td>
                <a class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal"
                   data-id="<%= usuario.getIdUsuario()%>"
                   data-nombre="<%= usuario.getNombre()%>"
                   data-apellido="<%= usuario.getApellido()%>"
                   data-correo="<%= usuario.getCorreo()%>"
                   data-contraseña="<%=usuario.getContraseña()%>"
                   data-idRol="<%=usuario.getIdRol()%>"><i class="fa-solid fa-marker"></i></a>
                <a class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal2"
                   data-id="<%= usuario.getIdUsuario()%>"><i class="fa fa-trash"></i></a>

            </td>
            </tr>

            <%
                    }
                } else {
                    out.println("<tr><td colspan='5'>No se encontraron Usuarios.</td></tr>");
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

                <h1 class="modal-title fs-5 text-primary" id="exampleModalLabel"><b>Editar Usuario</b></h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="sv_editarUsuario" method="POST">
                    <div class="mb-3">
                        <label for="nombre" class="form-label"><strong>Nombre</strong></label>
                        <input type="text" class="form-control" id="modalNombre"  name="nombre" placeholder="Nombre " required>
                    </div>
                    <div class="mb-3">
                        <label for="apellido" class="form-label"><strong>Apellido</strong></label>
                        <input type="text" class="form-control" id="modalApellido"  name="apellido" placeholder="Apellido" required>
                    </div>
                    <div class="mb-3">
                        <label for="correo" class="form-label"><strong>Correo</strong></label>
                        <input type="text" class="form-control" id="modalCorreo"  name="correo" placeholder="Correo" required>
                    </div>
                     <div class="mb-3">
                         <label for="contraseña" class="form-label"><strong>Contraseña</strong></label>
                        <br>
                        <label for="contraseña" class="form-label">(Si no se quiere cambiar, se deja vacio)</label>
                        <input type="text" class="form-control" id="modal_Contraseña"  name="contraseña" placeholder="Contraseña">
                    </div>
                    
                    <div class="mb-3">
                        <label for="Rol" class="form-label"><strong>Rol</strong></label>
                        <select name="idRol" class="form-control" required>
                            <option value="2">Vendedor</option>
                            <option value="3">Usuario</option>
                        </select>
                    </div>
                    
                    
               


                    <input type="hidden" class="form-control" id="modal_Id" name="id" >


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
                <h1 class="modal-title fs-5 text-danger" id="exampleModalLabel"><b>Eliminar Usuario</b></h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                
                <p>¿Estas seguro que deseas eliminar este Usuario?</p>
                <form action="sv_borrarUsuario" method="POST">
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
            var nombre = button.data('nombre');
            var apellido = button.data('apellido');
            var correo = button.data('correo');
            var idRol = button.data('idRol');
            var id = button.data('id');


            // Actualizar el contenido de la modal
            var modal = $(this);
            modal.find('#modal_Id').val(id);
            modal.find('#modalNombre').val(nombre);
            modal.find('#modalApellido').val(apellido);
            modal.find('#modalCorreo').val(correo);
            modal.find('#modalIdRol').val(idRol);
            
        });
    });

    $('#exampleModal2').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Botón que abrió el modal
        var id = button.data('id');  // Obtiene el correo del botón
        var modal = $(this);
        modal.find('#modal_Id').val(id); // Actualiza el campo oculto
    });


</script>
    
 
