package com.et.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.et.conexiones.AdministradorConexion;
import com.et.constantes.Constantes;
import com.et.dto.ProductoDTO;

public class SeleccionarUnProductoDAO {

	public ProductoDTO seleccionarUnProducto(int idProducto) throws ClassNotFoundException, SQLException {
		
		try (PreparedStatement sentenciaSeleccionar = AdministradorConexion.obtieneConexion()
				.prepareStatement(Constantes.SELECCIONAR_PRODUCTO)) {

			sentenciaSeleccionar.setInt(1,  idProducto);
			
			ResultSet resultado = sentenciaSeleccionar.executeQuery();
			ProductoDTO producto = new ProductoDTO();
			
			while (resultado.next()) {
				
				producto.setIdProducto(resultado.getInt("ID_PRODUCTO"));
				producto.setNombreProducto(resultado.getString("NOMBRE_PRODUCTO"));
				producto.setPrecioProducto(resultado.getInt("PRECIO_PRODUCTO"));
				producto.setDescripcionProducto(resultado.getString("DESCRIPCION_PRODUCTO"));
				producto.setIdCategoria(resultado.getInt("ID_CATEGORIA"));
				
			}
			return producto;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;	
	}
}
