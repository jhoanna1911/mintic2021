<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="estilo.css">
    <meta charset="utf-8">
	<title>Consultar</title>
</head>
<body>
<%@include file="administracion.jsp" %>
       <div id="Contenido">            
            <section  class="registro">
            <form action=./tv_servlet method="post">
                <h2>Actualizar usuario</h2><br>
                <p>Cedula: </p>
				<input class="ingdatos" type="text" id="ActualizaCedula" name="ActualizaCedula" required>
				<br> <br>
                <h2>Datos a actualizar: </h2><br>
                <p>Nombre completo:</p>
                <input class="ingdatos" type="text" id="nombre" name="Actualizanombre" required>
                <p>Correo electronico:</p>
                <input class="ingdatos" type="text" id="correo" name="ActualizaCorreo" required>
                <p>Usuario:</p>
                <input class="ingdatos" type="text" id="usuario" name="ActualizaUsuario" required>
                <p>Contraseña:</p>
                <input class="ingdatos" type="text" id="contraseña" name="ActualizaContrasena" required> 
                <br> <br>  
                <p><input type="submit" class="boton-crea" value="Actualizar"></p>
                <br>
                </form>
            </section>       
        
        </div>

</body>
</html>