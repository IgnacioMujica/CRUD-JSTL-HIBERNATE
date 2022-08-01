package com.et.facade;

import java.sql.SQLException;
import java.util.List;

import com.et.dao.CategoriaDAO;
import com.et.dao.EditarProductoDAO;
import com.et.dao.EliminarProductoDAO;
import com.et.dao.ObtenerProductosDAO;
import com.et.dao.RegistraProductoDAO;
import com.et.dao.SeleccionarUnProductoDAO;
import com.et.dto.CategoriaDTO;
import com.et.dto.ProductoDTO;


public class Facade {
	
	public List<ProductoDTO> obtenerProductos() throws ClassNotFoundException, SQLException {
		ObtenerProductosDAO dao = new ObtenerProductosDAO();
		return dao.obtenerProductos();
	}
		
	public List<CategoriaDTO> obtenerCategorias() throws ClassNotFoundException, SQLException {
		CategoriaDAO dao = new CategoriaDAO();
		return dao.obtenerCategorias();
	}

	public int registrarProducto(ProductoDTO producto) throws ClassNotFoundException, SQLException {
		RegistraProductoDAO dao = new RegistraProductoDAO();
		return dao.registrarProducto(producto);
	}
	
	public int eliminarProducto(int id_producto) throws ClassNotFoundException, SQLException {
		EliminarProductoDAO dao = new EliminarProductoDAO();
		return dao.eliminarProducto(id_producto);
	}
	public ProductoDTO seleccionarUnProducto(int id_producto) throws ClassNotFoundException, SQLException {
		SeleccionarUnProductoDAO dao = new SeleccionarUnProductoDAO();
		return dao.seleccionarUnProducto(id_producto);
		
	}

	public int editarProducto(ProductoDTO producto) throws ClassNotFoundException, SQLException {
		EditarProductoDAO dao = new EditarProductoDAO();
		return dao.editarProducto(producto);
	}
}
