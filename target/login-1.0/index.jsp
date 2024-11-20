<%-- 
    Document   : index
    Created on : 30/10/2024, 7:38:24 a. m.
    Author     : juand
--%>
<%@include file="lib/header.jsp" %>


<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="sv_registrarUsuario" method="POST">
            <h1>Crear Cuenta</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
            </div>
            <span>o usa tu e-mail para registrarte</span>
            <input type="text" placeholder="Nombre" name="nombre" />
            <input type="text" placeholder="Apellido" name="apellido" />
            <input type="email" placeholder="Correo" name="correo" />
            <input type="password" placeholder="Contraseña" name="contraseña" />
            <button>Registrarse</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="sv_validarUsuario" method="POST">
            <h1>Iniciar Sesión</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
            </div>
            <span>o usa tu cuenta</span>
            <input type="email" placeholder="Correo"  name="correo"/>
            <input type="password" placeholder="Contraseña" name="contraseña" />
            <a href="#">¿Olvidaste tu Contraseña?</a>
            <button>Iniciar Sesión</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Bienvenido de vuelta!</h1>
                <p>Para mantenerse conectado con nosotros, inicie sesión con su información personal</p>
                <button class="ghost" id="signIn">Iniciar Sesión</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Hola, amigo!</h1>
                <p>Introduce tus datos personales y comienza tu viaje con nosotros.</p>
                <button class="ghost" id="signUp">Registrarse</button>
            </div>
        </div>
    </div>
</div>


<%@include file="lib/footer.jsp" %>


