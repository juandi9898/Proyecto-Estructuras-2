<%-- 
    Document   : paginaAgregarJuego
    Created on : 15/11/2024, 11:03:54 p. m.
    Author     : juand
--%>
<%@include file="lib/header1.jsp" %>

<%@include file="lib/navbarVendedor.jsp" %>

<div class="container d-flex justify-content-center mt-5">
    <div class="row">
        <div class="col">
            <div class="card card-body">



                <br>
                <div class="text-center">
                    <h1 class="text-success"><b>Agregar Videojuego</b></h1>
                </div>
                <br>
                
                
                      <form action="sv_agregarJuego" method="POST">
                          <label for="nombre" class="form-label"><strong>Titulo:</strong></label>
                    <input type="text" class="form-control" id="titulo" name="titulo" placeholder="Titulo" required>

                 
                        <label for="descripcion" class="form-label"><strong>Descripción: </strong></label>
                        <textarea class="form-control" id="descripcion" name="descripcion" placeholder="Descripción" required rows="3" ></textarea>
              
                    
                    <label for="genero" class="form-label"><strong>Género: </strong></label>
                    <input type="text" class="form-control" id="genero" name="genero" placeholder="Género" required>
                    
                    <label for="plataforma" class="form-label"><strong>Plataforma: </strong></label>
                    <input type="text" class="form-control" id="plataforma" name="plataforma" placeholder="Plataforma" required>
                    
                    <label for="precio" class="form-label"><strong>Precio: </strong></label>
                    <input type="text" class="form-control" id="precio" name="precio" placeholder="Precio" required>
                              <label for="fechaLanz" class="form-label"><strong>Fecha de Lanzamiento: </strong></label>
                    <input type="date" class="form-control" id="fechaLanzamiento" name="fechaLanzamiento" placeholder="Fecha Lanzamiento" required>
                   
                    <label for="cantidadUDisp" class="form-label"><strong>Cantidad Unidades Disponibles: </strong></label>
                    <input type="text" class="form-control" id="cUnidadDisp" name="cUnidadDisp" placeholder="Cantidad Unidades Disponibles" required>
                    
         
                    <input type="hidden" class="form-control" id="idVendedor" name="idVendedor" value="<%=usuarioN.getIdUsuario()%>"><!--En el value, va el id que viene del objeto de usuario de rol vendedor que esta agregando-->

                    <div class="text-center" style="margin-top: 10px;">
                        <a class="btn btn-secondary" href="paginaVendedor.jsp">Cancelar</a>
                        <button type="submit" class="btn btn-primary" name="enviar">Agregar</button>
                    </div>

                </form>
                  
            </div>
        </div>
    </div>
</div>

<%@include file="lib/footer1.jsp" %>
