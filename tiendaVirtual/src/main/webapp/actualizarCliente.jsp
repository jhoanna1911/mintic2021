<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="estilo.css">
    <meta charset="utf-8">
	<title>Actualizar</title>
</head>
<body>
<%@include file="administracion.jsp" %>
       <div id="Contenido">            
            <section  class="registro">
            <form action=./tv_servlet method="post">
                <h2>Actualizar cliente</h2><br>
                <p>Cedula: </p>
				<input class="ingdatos" type="text" id="ActualizaCedula" name="ActualizaCedulaCliente" required>
				<br> <br>
                <h2>Datos a actualizar: </h2><br>
                <p>Nombre completo:</p>
                <input class="ingdatos" type="text" id="nombre" name="ActualizanombreCliente" required>
                <p>Dirección:</p>
                <input class="ingdatos" type="text" id="correo" name="ActualizaDireccionCliente" required>
                <p>Teléfono:</p>
                <input class="ingdatos" type="text" id="usuario" name="ActualizaTelefonoCliente" required>
                <p>Correo Electrónico:</p>
                <input class="ingdatos" type="text" id="contraseña" name="ActualizaCorreoCliente" required> 
                <br> <br>  
                <p><input type="submit" class="boton-crea" value="Actualizar"></p>
                <br>
                </form>
            </section>       
        
        </div>

</body>
</html>