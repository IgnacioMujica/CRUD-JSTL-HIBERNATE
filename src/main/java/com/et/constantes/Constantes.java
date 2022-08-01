package com.et.constantes;

public class Constantes {
	
	public static final String STRING_CONEXION_ORACLE = "oracle.jdbc.driver.OracleDriver";
	public static final String URL_CONEXION_ORACLE = "jdbc:oracle:thin:@localhost:1521/xe";
	public static final String USUARIO_ORACLE = "mrclean";
	public static final String PASSWORD_ORACLE = "123";

	public static final String QUERY_OBTENER_PRODUCTOS = "SELECT * FROM PRODUCTOS;";
	public static final String QUERY_OBTENER_CATEGORIAS = "SELECT * FROM CATEGORIAS;";
	public static final String QUERY_EDITAR_PRODUCTO = "UPDATE PRODUCTO SET NOMBRE_PRODUCTO=?, PRECIO_PRODUCTO=?, DESCRIPCION_PRODUCTO=?, ID_CATEGORIA=? WHERE ID_PRODUCTO=?";
	public static final String SELECCIONAR_PRODUCTO = "SELECT * FROM PRODUCTO WHERE ID_PRODUCTO = ?";
	public static final String ELIMINAR_PRODUCTO = "DELETE FROM PRODUCTO WHERE ID_PRODUCTO = ?";


}