package com.et.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.et.conexiones.AdministradorConexion;
import com.et.constantes.Constantes;
import com.et.dto.ProductoDTO;

public class EditarProductoDAO {

	public int editarProducto(ProductoDTO producto) throws ClassNotFoundException, SQLException {

		try (PreparedStatement sentenciaEditar = AdministradorConexion.obtieneConexion()
				.prepareStatement(Constantes.QUERY_EDITAR_PRODUCTO)) {

		System.out.println(producto.getNombreProducto());
		System.out.println(producto.getPrecioProducto());
		System.out.println(producto.getDescripcionProducto());
		System.out.println(producto.getIdCategoria());
		System.out.println(producto.getIdProducto());
				
		sentenciaEditar.setString(1, producto.getNombreProducto());
		sentenciaEditar.setInt(2, producto.getPrecioProducto());
		sentenciaEditar.setString(3, producto.getDescripcionProducto());
		sentenciaEditar.setInt(4, producto.getIdCategoria());
		sentenciaEditar.setInt(5, producto.getIdProducto());
				
		int filasEditadas = sentenciaEditar.executeUpdate();
		
		if (filasEditadas > 0) {
			System.out.println("Algo editamos... espero sea lo que querias.");
		}
		return filasEditadas; 
		
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return 0;
		
	}
}

