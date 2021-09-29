<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta charset="utf-8">
<title>Consulta</title>
</head>
<body>
	<%@include file="administracion.jsp"%>
	<div id="Contenido">
		<section class="resultado">
			<h2>
				Usuario:
				<%
			out.println(request.getAttribute("Nombre"));
			%>
			</h2>
			<br>
			<p>
				Cedula:
				<%
			out.println(request.getAttribute("Cedula"));
			%>
				<br> Correo:
				<%
				out.println(request.getAttribute("Correo"));
				%>
				<br> Usuario:
				<%
				out.println(request.getAttribute("Usuario"));
				%>
				<br>
			</p>
		</section>




	</div>

    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="css/estilo.css">
    <meta charset="utf-8">
	<title>MinTech Encontrado</title>
</head>
<body>
<%@include file="administracion.jsp" %>
<body>
	 <div id="Contenido">
	 	<section class="resultado">
			<h2>Usuario encontrado:</h2><br>
				<p>
					Nombre:  <%out.print(request.getAttribute("Nombre"));%><br>
					Cedula:  <%out.print(request.getAttribute("Cedula"));%><br>
					Correo:  <%out.print(request.getAttribute("Correo"));%><br>
					Usuario:  <%out.print(request.getAttribute("Usuario"));%><br>
				</p>
		</section>
	</div>
</body>
</html>