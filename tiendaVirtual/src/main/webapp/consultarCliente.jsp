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
	<%@include file="administracion.jsp"%>
	<div id="Contenido">
		<section class="registro">
			<h2>Consultar cliente</h2>
			<br>
			<p>Cedula:</p>
			<form action=./tv_servlet method="get">
				<input class="ingdatos" type="text" name="cedulaCliente" required>
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