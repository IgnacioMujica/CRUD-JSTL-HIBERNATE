package com.et.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.et.constantes.Constantes;
import com.et.dto.ProductoDTO;

public class RegistraProductoDAO {

	public int registrarProducto(ProductoDTO producto) throws ClassNotFoundException, SQLException {
		System.out.println("Corriendo metodo inserar producto");
		System.out.println(producto.getNombreProducto());
		System.out.println(producto.getPrecioProducto());
		System.out.println(producto.getDescripcionProducto());
		System.out.println(producto.getIdCategoria());
		System.out.println("");

		// ejecutamos un insert a la tabla

		// para sacar el siguiente valor de tu secuencia oracle
		String queryObtenerIdProducto = "SELECT MAX(ID_PRODUCTO)+1 FROM PRODUCTO";
		// para insertar una inscripcion
		System.out.println(queryObtenerIdProducto);

		String insertarInscripcion = "INSERT INTO PRODUCTO(ID_PRODUCTO, NOMBRE_PRODUCTO, PRECIO_PRODUCTO, DESCRIPCION_PRODUCTO, ID_CATEGORIA)"
				+ "VALUES (?,?,?,?,?)";
		System.out.println(insertarInscripcion);
		// generamos la conexion a la BD
		Class.forName(Constantes.STRING_CONEXION_ORACLE);
		Connection conexion = null;
		String url = Constantes.URL_CONEXION_ORACLE;
		conexion = DriverManager.getConnection(url, Constantes.USUARIO_ORACLE, Constantes.PASSWORD_ORACLE);
		System.out.println("conectados a DB");
		// preparamos las querys en sentencias por separado

		try (
				PreparedStatement sentenciaInsert = conexion.prepareStatement(insertarInscripcion);
				PreparedStatement sentenciaObtieneId = conexion.prepareStatement(queryObtenerIdProducto);
		) {
			// ejecutamos la query del id

			ResultSet resultado = sentenciaObtieneId.executeQuery();
			if (resultado.next()) {

				// armamos el insert de inscripciones
				sentenciaInsert.setInt(1, resultado.getInt(1));
				sentenciaInsert.setString(2, producto.getNombreProducto());
				sentenciaInsert.setInt(3, producto.getPrecioProducto());
				sentenciaInsert.setString(4, producto.getDescripcionProducto());
				sentenciaInsert.setInt(5, producto.getIdCategoria());

				// ejecutamos el insert

				if (sentenciaInsert.executeUpdate() != 1) {
					System.out.println("ocurrio un error al insertar los datos");
				} else {
					System.out.println("insert ok");
				}
			}

		} catch (Exception ex) {

		}
		return 1;

	}

}
