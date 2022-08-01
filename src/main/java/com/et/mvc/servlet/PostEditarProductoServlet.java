package com.et.mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.et.dto.ProductoDTO;
import com.et.facade.Facade;


@WebServlet("/PostEditaProducto")
public class PostEditarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Facade facade = new Facade();
		try {
			@SuppressWarnings("unused")
			int resultado;
			
			ProductoDTO producto = new ProductoDTO();
			producto.setIdProducto((int) Integer.parseInt(request.getParameter("ID_PRODUCTO")));
			producto.setNombreProducto(request.getParameter("NOMBRE_PRODUCTO"));
			producto.setPrecioProducto((int) Integer.parseInt(request.getParameter("PRECIO_PRODUCTO")));
			producto.setDescripcionProducto(request.getParameter("DESCRIPCION_PRODUCTO"));
			producto.setIdCategoria((int) Integer.parseInt(request.getParameter("ID_CATEGORIA")));
		
			System.out.println(producto);

			resultado = facade.editarProducto(producto);

			request.getRequestDispatcher("listar").forward(request,  response);
			
			}
		catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
	}
	

	

}
