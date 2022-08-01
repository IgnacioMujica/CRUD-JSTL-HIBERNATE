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

import com.et.facade.Facade;
import com.et.dto.CategoriaDTO;
import com.et.dto.ProductoDTO;


@WebServlet("/RealizaEdicion")
public class EditarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_producto = (int) Integer.parseInt(request.getParameter("id_seleccionado"));
		System.out.println("ID Seleccionado" + id_producto);
		Facade facade = new Facade ();

			try {
				ProductoDTO producto = new ProductoDTO();	
				List<CategoriaDTO> categorias = new ArrayList<CategoriaDTO>();	
				producto = facade.seleccionarUnProducto(id_producto);
				System.out.println("Categoria del prod seleccionado:" + producto.getIdProducto());
				categorias = facade.obtenerCategorias();
				
				String nombre_categoria;
											
				for (int i = 0; i < categorias.size(); i++) {

					if (producto.getIdCategoria() == categorias.get(i).getIdCategoria()) {
						nombre_categoria = categorias.get(i).getNombreCategoria();
						request.setAttribute("nombrecat",  nombre_categoria);
						System.out.println(nombre_categoria);
					}
				}
				
				request.setAttribute("producto",  producto);
				request.setAttribute("categorias",  categorias);
				
				request.getRequestDispatcher("edicion.jsp").forward(request, response);
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	
						
			
	}

}

