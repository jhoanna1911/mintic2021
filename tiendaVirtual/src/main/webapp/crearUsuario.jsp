<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="estilo.css">
    <meta charset="utf-8">
	<title>Usuarios</title>
</head>
<body>
<%@include file="administracion.jsp" %>
       <div id="Contenido">            
            <section  class="registro">
            <form action=./tv_servlet method="post">
                <h2>Crear usuario</h2><br>
                <p>Cedula: </p>
                <input class="ingdatos" type="text" id="cedula" name="CreaCedula" required> 
                <p>Nombre completo:</p>
                <input class="ingdatos" type="text" id="nombre" name="Creanombre" required>
                <p>Correo electronico:</p>
                <input class="ingdatos" type="text" id="correo" name="CreaCorreo" required>
                <p>Usuario:</p>
                <input class="ingdatos" type="text" id="usuario" name="CreaUsuario" required>
                <p>Contraseña:</p>
                <input class="ingdatos" type="text" id="contraseña" name="CreaContrasena" required> 
                <br> <br>  
                <p><input type="submit" class="boton-crea" value="Crear"></p>
                <br>
                </form>
            </section>
        
        
        
        </div>

</body>
</html>