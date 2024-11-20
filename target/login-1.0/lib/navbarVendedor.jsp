
<%@page import="mundo.Usuario"%>
<%

Usuario usuarioN=(Usuario)session.getAttribute("usuario");

%>

<nav class="navbar navbar-expand-lg bg-body-tertiary" style="width: 100%; ">
    <div class="container-fluid">
        <a class="navbar-brand text-primary" href="paginaVendedor.jsp" style="margin-left: 60px;"><b>GamesStore</b></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent" style="margin-left: 900px">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="paginaVendedor.jsp"><strong>Productos</strong></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="paginaHVendedor.jsp"><strong>HistorialVentas</strong></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <strong>
                            
                           <!-- Aqui creo mejor mandar el objeto porque mas abajo se usa id, y en esta parte si usar el nombre del usuario mas apellido -->
                                        <%=usuarioN.getNombre()+" "+usuarioN.getApellido()%>

                        </strong>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#"><strong>Tipo: </strong>Vendedor</a></li>
                       
                         <!-- Para que se invalide la sesion cuando se le de a cerrar sesión, eso va al get-->
              <li><a class="dropdown-item" href="sv_validarUsuario" style="color: red;">Cerrar Sesión</a></li>
          
                        
                        
                    </ul>
                </li>

            </ul>

        </div>
    </div>
</nav>