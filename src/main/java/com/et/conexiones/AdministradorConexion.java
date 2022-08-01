package com.et.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;



public class AdministradorConexion {
	
	private static Connection conn = null;

	//CONSTRUCTOR
	private AdministradorConexion() {
		
		String url = Constantes.URL_CONEXION_ORACLE;
		String driver = Constantes.STRING_CONEXION_ORACLE;
		String usuario = Constantes.USUARIO_ORACLE;
		String password = Constantes.PASSWORD_ORACLE;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,usuario,password);
			System.out.println("Se genero conexion a BD");
		}catch(Exception ex) {
			
		}
		
	}
	// METODO PARA SER LLAMADO
	public static Connection obtieneConexion() {
		if(conn == null) {
			new AdministradorConexion();
		}
		return conn;
	}
	
}
