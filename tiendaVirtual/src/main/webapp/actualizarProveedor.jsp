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
                <h2>Actualizar proveedor</h2><br>
                <p>Nit: </p>
				<input class="ingdatos" type="text" id="ActualizaCedula" name="ActualizaNit" required>
				<br> <br>
                <h2>Datos a actualizar: </h2><br>
                <p>Nombre:</p>
                <input class="ingdatos" type="text" id="nombre" name="ActualizanombreP" required>
                <p>Dirección:</p>
                <input class="ingdatos" type="text" id="correo" name="ActualizaDireccionP" required>
                <p>Teléfono:</p>
                <input class="ingdatos" type="text" id="usuario" name="ActualizaTelefonoP" required>
                <p>Ciudad:</p>
                <input class="ingdatos" type="text" id="contraseña" name="ActualizaCiudadP" required> 
                <br> <br>  
                <p><input type="submit" class="boton-crea" value="Actualizar"></p>
                <br>
                </form>
            </section>       
        
        </div>

</body>
</html>