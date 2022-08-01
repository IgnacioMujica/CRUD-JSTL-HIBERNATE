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
import com.et.dto.ProductoDTO;
import com.et.facade.Facade;


@WebServlet("/listar")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Facade facade = new Facade ();
		
		
		List<ProductoDTO> productos = new ArrayList<ProductoDTO>();	
		List<CategoriaDTO> categorias = new ArrayList<CategoriaDTO>();	

			try {
				productos = facade.obtenerProductos();
				categorias = facade.obtenerCategorias();
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("productos",  productos);
			request.setAttribute("categorias",  categorias);
						
			request.getRequestDispatcher("listarproductos.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Facade facade = new Facade ();
		
		
		List<ProductoDTO> productos = new ArrayList<ProductoDTO>();	
		List<CategoriaDTO> categorias = new ArrayList<CategoriaDTO>();	

			try {
				productos = facade.obtenerProductos();
				categorias = facade.obtenerCategorias();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("productos",  productos);
			request.setAttribute("categorias",  categorias);
			
			
			request.getRequestDispatcher("listarproductos.jsp").forward(request, response);


	}
	
}
