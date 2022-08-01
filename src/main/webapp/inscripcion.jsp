<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingresar Producto</title>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<!--  LOGO  -->
	<div>
      <img class=icon src="images/icono_limpieza.png" alt="icono limpieza">
   </div>
	<div>
      <img class=icon src="images/agregar_bd.png" alt="icono listar">
   </div>
<!--  /LOGO  -->
		<span class="navbar-brand">AGREGAR</span>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="listar">Listar Productos<span class="sr-only"></span></a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="PreIngresarServlet">Agregar Producto<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="PreEliminarServlet">Eliminar Producto<span class="sr-only"></span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="PreEditarServlet">Editar Producto<span class="sr-only"></span></a>
				</li>
				
			</ul>
		</div>
	</nav>
	<div
		style="height: 300px; width: 400px; position: absolute; left: 50%; top: 50%; -webkit-transform: translate(-50%, -50%); transform: translate(-50%, -50%); text-align: center;">
		<form action="ingresaProducto" method="POST">
						
			<label style="display: inline-block; width: 150px; text-align:left;">Nombre</label> <input type="text" name="NOMBRE_PRODUCTO" id="NOMBRE_PRODUCTO"><br>
			<label style="display: inline-block; width: 150px; text-align:left;">Precio</label> <input type="text" name="PRECIO_PRODUCTO" id="PRECIO_PRODUCTO"><br>
			<label style="display: inline-block; width: 150px; text-align:left;">Descripción</label> <input type="text" name="DESCRIPCION_PRODUCTO" id="DESCRIPCION_PRODUCTO"><br>
			<label style="display: inline-block; width: 150px; text-align:left;">Categoría</label>
			<select name="ID_CATEGORIA">
				<c:forEach var="categorias" items="${requestScope.categorias}">
					<option value="${categorias.getIdCategoria()}">
						${categorias.getNombreCategoria()}
					</option>
				</c:forEach>
			</select>
			<br>
			<div class="col-md-12 text-center m-1"> 
			<input type="submit" value="Ingresar Producto ✔️">
			</div>
		</form>
	</div>
</body>
</html>