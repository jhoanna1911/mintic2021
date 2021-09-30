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
			<h2>Cargar productos</h2>
			<br>
			<form action=./FileTest method="post" enctype="multipart/form-data" >
		
				<input type='file' name='fileName' accept=".csv" required/> 
				<p>
				<br>
				<input type="submit" class="boton-crea" value="Subir" /> <br> <br>

				</p>

				<br>
				<h2></h2>
				<br>
			</form>
		</section>




	</div>

</body>
</html>