<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar Producto</title>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
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

	<!-- NAV BAR  -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<!--  LOGO  -->
		<div>
			<img class=icon src="images/icono_limpieza.png" alt="icono limpieza">
		</div>
		<div>
			<img class=icon src="images/editar_bd.png" alt="icono eliminar">
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
				<li class="nav-item"><a class="nav-link" href="listar">Listar
						Productos<span class="sr-only"></span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="PreIngresarServlet">Agregar Producto<span class="sr-only"></span></a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="PreEliminarServlet">Eliminar Producto<span
						class="sr-only"></span></a></li>
				<li class="nav-item active"><a class="nav-link"
					href="PreEditarServlet">Editar Producto<span class="sr-only">(current)</span></a>
				</li>

			</ul>
		</div>
	</nav>
	<!-- /NAV BAR  -->
	<form action="RealizaEdicion" method="POST">
		<table class="table table-striped">
			<thead>
				<tr>
					<th style="text-align: center;">Seleccionar</th>
					<th style="text-align: center;">Id Producto</th>
					<th>Nombre</th>
					<th style="text-align: center;">Precio</th>
					<th>Descripción</th>
					<th>Nombre Categoría</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="productos" items="${requestScope.productos}">
					<tr>
						<td style="text-align: center;"><input type="radio"
							name="id_seleccionado" value="${productos.getIdProducto()}"></td>
						<td style="text-align: center;"><c:out
								value="${productos.getIdProducto()}" /></td>
						<td><c:out value="${productos.getNombreProducto()}" /></td>
						<td style="text-align: center;"><c:out
								value="${productos.getPrecioProducto()}" /></td>
						<td><c:out value="${productos.getDescripcionProducto()}" /></td>
						<td><c:out value="${productos.getNombreCategoria()}" /></td>
					</tr>
				</c:forEach>
				<tr style="text-align: center;">
					<td colspan="2"><input type="submit" value="Editar ✏️"></td>
					<td colspan="3">
					<td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>