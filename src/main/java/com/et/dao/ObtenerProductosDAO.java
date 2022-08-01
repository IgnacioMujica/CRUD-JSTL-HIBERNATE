package com.et.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.et.conexiones.AdministradorConexion;
import com.et.conexiones.Constantes;
import com.et.dto.CategoriaDTO;
import com.et.dto.ProductoDTO;
import com.et.facade.Facade;

public class ObtenerProductosDAO {

	public List<ProductoDTO> obtenerProductos() throws ClassNotFoundException, SQLException {
		
		try (PreparedStatement sentencia = AdministradorConexion.obtieneConexion()
				.prepareStatement(Constantes.QUERY_OBTENER_PRODUCTOS)) {

			ResultSet resultado = sentencia.executeQuery();
			List<ProductoDTO> listaDeProductos = new ArrayList<ProductoDTO>();
			List<CategoriaDTO> categorias = new ArrayList<CategoriaDTO>();
			Facade facade = new Facade ();
			categorias = facade.obtenerCategorias();
			//ResultSetMetaData rsmd = resultado.getMetaData();
			//int columnsNumber = rsmd.getColumnCount();

			
			while (resultado.next()) {
			    /*for (int i = 1; i <= columnsNumber; i++) {
			        if (i > 1) System.out.print(",  ");
			        String columnValue = resultado.getString(i);
			        System.out.print(columnValue + " " + rsmd.getColumnName(i));
			    }
			    System.out.println("");*/
						
				ProductoDTO producto = new ProductoDTO();
				producto.setIdProducto(resultado.getInt("ID_PRODUCTO"));
				System.out.println(resultado.getInt("ID_PRODUCTO"));
				producto.setNombreProducto(resultado.getString("NOMBRE_PRODUCTO"));
				System.out.println(resultado.getString("NOMBRE_PRODUCTO"));
				producto.setPrecioProducto(resultado.getInt("PRECIO_PRODUCTO"));
				System.out.println(resultado.getInt("PRECIO_PRODUCTO"));
				producto.setDescripcionProducto(resultado.getString("DESCRIPCION_PRODUCTO"));
				System.out.println(resultado.getString("DESCRIPCION_PRODUCTO"));
				producto.setIdCategoria(resultado.getInt("ID_CATEGORIA"));
				System.out.println(resultado.getInt("ID_CATEGORIA"));
				
				String nombre_categoria;		
					
				//Por cada categoria en la lista de categorias						
				for (int i = 0; i < categorias.size(); i++) {
					//Si el ID_CATEGORIA de nuestro producto coincide con el ID_CATEGORIA de la categoria actual de la lista
					if (producto.getIdCategoria() == categorias.get(i).getIdCategoria()) {
						// tomamos el NOMBRE_CATEGORIA correspondiente a la categoria actual de la lista
						nombre_categoria = categorias.get(i).getNombreCategoria();
						// le asignamos al producto ese NOMBRE_CATEGORIA
						producto.setNombreCategoria(nombre_categoria);
						
					}
				}


				
				listaDeProductos.add(producto);

			}
			return listaDeProductos;
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return null;

	}
}
