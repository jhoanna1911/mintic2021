<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="estilo.css">
    <meta charset="utf-8">
	<title>Clientes</title>
</head>
<body>
<%@include file="administracion.jsp" %>
       <div id="Contenido">            
            <section  class="registro">
            <form action=./tv_servlet method="post">
                <h2>Crear cliente</h2><br>
                <p>Cedula: </p>
                <input class="ingdatos" type="text" id="cedula" name="CreaCedulaCliente" required> 
                <p>Nombre completo:</p>
                <input class="ingdatos" type="text" id="nombre" name="CreanombreCliente" required>
                <p>Dirección:</p>
                <input class="ingdatos" type="text" id="direccion" name="CreaDirecciónCliente" required>
                <p>Teléfono:</p>
                <input class="ingdatos" type="text" id="telefono" name="CreaTelefonoCliente" required> 
                <p>Correo electronico:</p>
                <input class="ingdatos" type="text" id="correo" name="CreaCorreoCliente" required>
                <br> <br>  
                <p><input type="submit" class="boton-crea" value="Crear"></p>
                <br>
                </form>
            </section>
        
        
        
        </div>

</body>
</html>