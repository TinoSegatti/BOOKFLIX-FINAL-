package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorDB {
	private static final String controlador = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/bookflix";
	private static final String usuario = "root";
	private static final String contraseña = "123456789";
	
	
	static {
		try {
			Class.forName(controlador);
			
		} catch (ClassNotFoundException e) {
			System.out.println("No se pudo cargar el controlador MySQL.");
        	e.printStackTrace();
		}
	}
	public Connection conectar() {
		Connection conexion = null;
	    try {
	        	conexion = DriverManager.getConnection(url, usuario, contraseña);
	        	System.out.println("conectado con exito");
	        	//realizar opercaiones
	        	
	        	

	        	// Cerrar la conexión cuando hayas terminado
	    
	    	} catch (SQLException e) {
	    		System.out.println("Error al conectar a la base de datos.");
	        	e.printStackTrace();
	    	}
	    return conexion;
	}

}
