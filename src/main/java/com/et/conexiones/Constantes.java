package com.et.conexiones;

public class Constantes {
	
	public static final String STRING_CONEXION_ORACLE = "oracle.jdbc.driver.OracleDriver";
	public static final String URL_CONEXION_ORACLE = "jdbc:oracle:thin:@localhost:1521/xe";
	public static final String USUARIO_ORACLE = "mrclean";
	public static final String PASSWORD_ORACLE = "123";
	

	// SELECCIONES
	public static final String QUERY_OBTENER_CATEGORIAS = "select * from categoria";
	public static final String QUERY_OBTENER_PRODUCTOS = "select * from producto";

	


}
