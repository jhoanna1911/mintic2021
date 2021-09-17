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
	<%@include file="administracion.jsp"%>
	<div id="Contenido">
		<section class="registro">
			<h2>Consultar proveedor</h2>
			<br>
			<p>Nit:</p>
			<form action=./tv_servlet method="post">
				<input class="ingdatos" type="text" name="nit" required>
				<br> <br>
				<p>
					<input type="submit" class="boton-crea" id="botonConsulta"
						value="Consultar">
				</p>

				<br>
				<h2></h2>
				<br>
			</form>
		</section>




	</div>

</body>
</html>