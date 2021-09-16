<!doctype html>

<html lang="es">

<head>

<meta charset="utf-8">

<title>Formulario de Acceso</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="https://fonts.googleapis.com/css?family=Nunito&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Overpass&display=swap"
	rel="stylesheet">

<!-- Link hacia el archivo de estilos css -->
<link rel="stylesheet" href="css/login.css">

<style type="text/css">
</style>

<script type="text/javascript">
	
</script>

</head>

<body>

	<div id="contenedor">
		<div id="central">
			<div id="login">
				<div class="titulo">Bienvenido</div>
				<img src="Imagenes/MINTECH.png" class="logo"> 
				<form id="loginform" method="post" action="./tv_servlet">
					<input type="text" name="Usuario" placeholder="Usuario" required>

					<input type="password" placeholder="Contrasena" name="Contrasena"
						required>
					<button type="submit" title="Ingresar" name="Ingresar">Ingresar</button>
				</form>
			</div>
			<div class="inferior">
				<a href="#">Volver</a>
			</div>
		</div>
	</div>

</body>

</html>