<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="estilo.css">
    <meta charset="utf-8">
	<title>Proveedores</title>
</head>
<body>
<%@include file="administracion.jsp" %>
       <div id="Contenido">            
            <section  class="registro">
            <form action=./tv_servlet method="post">
                <h2>Crear proveedor</h2><br>
                <p>Nit: </p>
                <input class="ingdatos" type="text" id="cedula" name="CreaNit" required> 
                <p>Nombre:</p>
                <input class="ingdatos" type="text" id="nombre" name="CreanombreProveedor" required>
                <p>Dirección:</p>
                <input class="ingdatos" type="text" id="correo" name="CreaDireccionProveedor" required>
                <p>Teléfono:</p>
                <input class="ingdatos" type="text" id="usuario" name="CreaTelefonoProveedor" required>
                <p>Ciudad:</p>
                <input class="ingdatos" type="text" id="contraseña" name="CreaCiudadProveedor" required> 
                <br> <br>  
                <p><input type="submit" class="boton-crea" value="Crear"></p>
                <br>
                </form>
            </section>
        
        
        
        </div>

</body>
</html>