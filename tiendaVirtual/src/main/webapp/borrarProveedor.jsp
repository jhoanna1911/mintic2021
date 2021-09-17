<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta charset="utf-8">
<title>Eliminar</title>
</head>
<body>
	<%@include file="administracion.jsp"%>
	<div id="Contenido">
		<section class="registro">
			<form action=./tv_servlet method="post">
				<h2>Eliminar proveedor</h2>
				<br>
				<p>Nit:</p>
				<input class="ingdatos" type="text" name="nitBorrar" required> <br>
				<br>
				<p>
					<input type="submit" class="boton-crea" value="Eliminar">
				</p>
				<br>
			</form>
		</section>



	</div>

</body>
</html>