package com.et.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.et.conexiones.AdministradorConexion;
import com.et.constantes.Constantes;

public class EliminarProductoDAO {

	public int eliminarProducto(int IdProducto) throws ClassNotFoundException, SQLException {

		try (PreparedStatement sentenciaEliminar = AdministradorConexion.obtieneConexion()
				.prepareStatement(Constantes.ELIMINAR_PRODUCTO)) {

			sentenciaEliminar.setInt(1, IdProducto);

			int filasEliminadas = sentenciaEliminar.executeUpdate();
			if (filasEliminadas > 0) {
				System.out.println("Algo borramos... espero sea lo que querias.");
			}
			return filasEliminadas;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return IdProducto;
	}

}
