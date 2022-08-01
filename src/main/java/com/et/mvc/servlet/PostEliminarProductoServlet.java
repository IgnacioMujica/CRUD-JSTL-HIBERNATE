package com.et.mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.et.facade.Facade;


@WebServlet("/eliminaProducto")
public class PostEliminarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_producto = (int) Integer.parseInt(request.getParameter("id_seleccionado"));
		
		
		Facade facade = new Facade();
		try {
			@SuppressWarnings("unused")
			int resultado;


			resultado = facade.eliminarProducto(id_producto);

			request.getRequestDispatcher("listar").forward(request,  response);
			
			}
		catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
	}
	

	

}
