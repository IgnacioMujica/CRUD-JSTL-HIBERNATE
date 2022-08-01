package com.et.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.et.dto.CategoriaDTO;

import com.et.dto.ProductoDTO;
import com.et.facade.Facade;



public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		obtenerCategorias();
		obtenerProductos();
	//insertarInscripcion();
	
}

	public static void obtenerCategorias() throws ClassNotFoundException, SQLException {
		List<CategoriaDTO> lista = new ArrayList<CategoriaDTO>();
		Facade facade = new Facade();
		lista = facade.obtenerCategorias();
		
		for (CategoriaDTO categoria : lista) {
			System.out.println(categoria.getIdCategoria());
			System.out.println(categoria.getNombreCategoria());
		}		
	}
		
	public static void obtenerProductos() throws ClassNotFoundException, SQLException {
		List<ProductoDTO> lista = new ArrayList<ProductoDTO>();
		Facade facade = new Facade();
		lista = facade.obtenerProductos();
		for (ProductoDTO producto : lista) {
			System.out.println(producto.getIdProducto());
			System.out.println(producto.getNombreProducto());
			System.out.println(producto.getPrecioProducto());
			System.out.println(producto.getDescripcionProducto());
			System.out.println(producto.getIdCategoria());
		}

	}
	
	/*private static void insertarInscripcion() throws ClassNotFoundException, SQLException {
		int resultado;
		Facade facade = new Facade();
		
		InscripcionDTO inscripcion = new InscripcionDTO();
		inscripcion.setId_curso("1");
		inscripcion.setId_forma_pago("1958");
		inscripcion.setNombre("pequeno timmy");
		inscripcion.setTelefono(98854);
		
		resultado = facade.guardarInscripcion(null);
		System.out.println("Insertado correcto, id " + resultado);
	}*/
}



