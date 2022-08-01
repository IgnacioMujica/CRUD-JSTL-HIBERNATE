package com.et.mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.et.dto.CategoriaDTO;
import com.et.facade.Facade;
import com.et.dto.ProductoDTO;


@WebServlet("/PreIngresarServlet")
public class PreIngresarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Facade facade = new Facade();
		List<ProductoDTO> productos = new ArrayList<ProductoDTO>();
		List<CategoriaDTO> categorias = new ArrayList<CategoriaDTO>();
		try {
			productos = facade.obtenerProductos();
			categorias = facade.obtenerCategorias();
			request.setAttribute("productos", productos);
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("inscripcion.jsp").forward(request,  response);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
