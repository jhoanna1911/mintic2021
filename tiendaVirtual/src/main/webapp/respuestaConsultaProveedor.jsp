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
				Proveedor:
				<%
			out.println(request.getAttribute("Nombre"));
			%>
			</h2>
			<br>
			<p>
				Nit:
				<%
			out.print(request.getAttribute("Nit"));
			%><br> Ciudad:
				<%
			out.print(request.getAttribute("Ciudad"));
			%><br> Telefono:
				<%
			out.print(request.getAttribute("Telefono"));
			%><br> Direccion:
				<%
			out.print(request.getAttribute("Direccion"));
			%><br>
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
	<title>MinTech Cliente Encontrado</title>
</head>
<body>
<%@include file="administracion.jsp" %>
<body>
	 <div id="Contenido">
	 	<section class="resultado">
			<h2>Proveedor encontrado:</h2><br>
				<p>
					Nombre:  <%out.print(request.getAttribute("Nombre"));%><br>
					Nit:  <%out.print(request.getAttribute("Nit"));%><br>
					Ciudad:  <%out.print(request.getAttribute("Ciudad"));%><br>
					Telefono:  <%out.print(request.getAttribute("Telefono"));%><br>
					Direccion:  <%out.print(request.getAttribute("Direccion"));%><br>
				</p>
		</section>
	</div>

</body>
</html>