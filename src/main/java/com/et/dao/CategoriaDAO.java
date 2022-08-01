package com.et.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.et.conexiones.AdministradorConexion;
import com.et.conexiones.Constantes;

import com.et.dto.CategoriaDTO;

public class CategoriaDAO {

	public List<CategoriaDTO> obtenerCategorias() {
		List<CategoriaDTO> listaDeCategorias = new ArrayList<CategoriaDTO>();
		try(PreparedStatement sentencia = AdministradorConexion.obtieneConexion()
				.prepareStatement(Constantes.QUERY_OBTENER_CATEGORIAS)){
		
			ResultSet resultado = sentencia.executeQuery();

			while(resultado.next()) {
				
				CategoriaDTO categoria = new CategoriaDTO();
				
				categoria.setIdCateogria(resultado.getInt("ID_CATEGORIA"));
				categoria.setNombreCategoria(resultado.getString("NOMBRE_CATEGORIA"));

				listaDeCategorias.add(categoria);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return listaDeCategorias;

	}
	
	
}
