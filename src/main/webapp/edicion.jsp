<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar</title>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<!--  LOGO  -->
		<div>
			<img class=icon src="images/icono_limpieza.png" alt="icono limpieza">
		</div>
		<div>
			<img class=icon src="images/editar_bd.png" alt="icono listar">
		</div>
		<!--  /LOGO  -->
		<span class="navbar-brand">EDITAR</span>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="listar">Listar Productos<span class="sr-only"></span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="PreIngresarServlet">Agregar Producto<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="PreEliminarServlet">Eliminar Producto<span
						class="sr-only"></span></a></li>
				<li class="nav-item active"><a class="nav-link"
					href="PreEditarServlet">Editar Producto<span class="sr-only"></span></a>
				</li>

			</ul>
		</div>
	</nav>
	<div
		style="height: 300px; width: 400px; position: absolute; left: 50%; top: 50%; -webkit-transform: translate(-50%, -50%); transform: translate(-50%, -50%); text-align: center;">
		<form action="PostEditaProducto" method="POST">
			<input type="hidden" name="ID_PRODUCTO" id="ID_PRODUCTO" value="${producto.getIdProducto()}">
			
			<label style="display: inline-block; width: 150px; text-align: left;">Nombre</label> <input type="text" name="NOMBRE_PRODUCTO" id="NOMBRE_PRODUCTO" value="${producto.getNombreProducto()}"><br> 
			<label style="display: inline-block; width: 150px; text-align: left;">Precio</label> <input type="text" name="PRECIO_PRODUCTO" id="PRECIO_PRODUCTO" value="${producto.getPrecioProducto()}"><br>
			<label style="display: inline-block; width: 150px; text-align: left;">Descripción</label> <input type="text" name="DESCRIPCION_PRODUCTO" id="DESCRIPCION_PRODUCTO"	value="${producto.getDescripcionProducto()}"><br> 
			<label style="display: inline-block; width: 150px; text-align: left;">Categoría</label>
			<select name="ID_CATEGORIA">
				<option value="${producto.getIdCategoria()}">${nombrecat}</option>
				<c:forEach var="categorias" items="${requestScope.categorias}">
					<option value="${categorias.getIdCategoria()}">
						${categorias.getNombreCategoria()}</option>
				</c:forEach>
			</select> <br>
			<div class="col-md-12 text-center m-1">
				<input type="submit" value="Confirmar ✔️">
			</div>
		</form>
	</div>
</body>
</html>